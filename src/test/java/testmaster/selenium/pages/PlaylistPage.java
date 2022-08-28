package testmaster.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testmaster.selenium.pages.base.BasePage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PlaylistPage extends BasePage {


    /**
     * Constants
     */
    private static String pageUrl = "https://open.spotify.com/playlist/";
    private static String tabName = "Spotify - My Playlist";
    private static By moreButton = By.xpath("//div[@data-testid='action-bar-row']//button[@data-testid='more-button']");
    private static By playListNameBox = By.xpath("//button[@class='wCkmVGEQh3je1hrbsFBY']");
    private static By playlistEditTextBox = By.xpath("//input[@data-testid='playlist-edit-details-name-input']");
    private static By playlistEditSaveButton = By.xpath("//button[@data-testid='playlist-edit-details-save-button']");
    private static By playlistMoreButton = By.xpath("//div[@class='eSg4ntPU2KQLfpLGXAww']//button[@data-testid='more-button']");
    private static By dropdownMenuDeleteButton = By.xpath("//button[@class='wC9sIed7pfp47wZbmU6m']//span[text()='Delete']");
    private static By deletionConfirmationButton = By.xpath("//button[@class='Button-qlcn5g-0 hgTVhT']//span[text()='DELETE']");
    private static By playlistDeletedPopUp = By.cssSelector("div[class=AOaoydTb5lrGytHbTAAy]");
    private static By moreOptionsMenu = By.xpath("//div[@id='context-menu']");
    private static By playButton;
    private static By selectedMenuItem;
    public void playlistPageLoadedCheck() {

        String urlWithoutRedirection = methods.driver.getCurrentUrl().substring(0, 34);
        String defaultTabName = methods.driver.getTitle().substring(0, 20);

        tabNameAndUrlCheck(tabName, defaultTabName, pageUrl, urlWithoutRedirection);
        sideBarCheck();

        assertTrue(methods.isElementVisible(moreButton, 20));

    }

    public void changePlaylistName(String newPlaylistName) {

        playlistName = newPlaylistName;

        assertTrue(methods.isElementClickable(playListNameBox, 10));
        methods.clickElement(playListNameBox);

        assertTrue(methods.isElementVisible(playlistEditTextBox, 10));
        methods.sendKeys(playlistEditTextBox, newPlaylistName);

        assertTrue(methods.isElementClickable(playlistEditSaveButton, 10));
        methods.clickElement(playlistEditSaveButton);

    }

    public void playSong(String songName, long duration) {
    
        String selectedMenuItemStr = "//div[contains(text(),'"+ songName +"')]";
        selectedMenuItem = By.xpath(selectedMenuItemStr);
        methods.scrollElementIfNeeded(selectedMenuItem);

        methods.hoverElement(selectedMenuItem);

        playButton = By.xpath(
                "//button[@class='RfidWIoz8FON2WhFoItU' and contains(@aria-label,'" + songName + "')]");
        assertTrue(methods.isElementClickable(playButton, 10));
        methods.clickElement(playButton);

        long songPos = getSongPosition();
        methods.waitBySeconds(8);
        
        while(songPos<(duration*1000)){
            methods.waitByMilliSeconds(200);
            songPos = getSongPosition();
            logger.info("Song pos : " + songPos + " and aimed duration : " + duration);
        }

        methods.clickElement(By.xpath("//button[@data-testid='control-button-playpause']"));
        methods.waitByMilliSeconds(200);
    
        List<WebElement> sideBarPlaylistSoundIcon = methods.driver.findElements(
                By.xpath(
                "//div[@class='g_jOSq3pLY5p4tldskrw']//button[@class='CCeu9OfWSwIAJqA49n84 ZcKzjCkYGeMizcSAP8UX']"));
        assertEquals(sideBarPlaylistSoundIcon.size(),0);

    }



    public void removeSongFromPlaylist(int index) {
    
        String playlistSizeXPath = "//div[@aria-label='" + playlistName + "']//div[@role='row']";
        int playlistSize = methods.countListSize(playlistSizeXPath);

        String selectedMenuItemStr = "//div[@class='JUa6JJNj7R_Y3i4P8YUX']//div[@aria-rowindex='" + (index+1) + "']";
        selectedMenuItem = By.xpath(selectedMenuItemStr);
        methods.hoverElement(selectedMenuItem);
        
        By selectedSongMoreButton = By.xpath(selectedMenuItemStr + "//button[@data-testid='more-button']");
        methods.hoverElement(selectedSongMoreButton);
        methods.clickElement(selectedSongMoreButton);

        assertTrue(methods.isElementVisible(moreOptionsMenu,5));

        String moreButtonMenuItems = "//button[@class='wC9sIed7pfp47wZbmU6m']//span[text()=";
        By removeSongFromPlaylistMenuItem = By.xpath(moreButtonMenuItems + "'Remove from this playlist']");
        methods.clickElement(removeSongFromPlaylistMenuItem);
        methods.waitByMilliSeconds(200);

        assertNotEquals(methods.countListSize(playlistSizeXPath), playlistSize);
        logger.info("Şarkı listeden çıkarıldı.");
    }

    public void removePlaylist() {

        methods.scrollElementIfNeeded(playlistMoreButton);

        assertTrue(methods.isElementClickable(playlistMoreButton, 10));
        methods.clickElement(playlistMoreButton);

        assertTrue(methods.isElementClickable(dropdownMenuDeleteButton,20));
        methods.clickElement(dropdownMenuDeleteButton);

        assertTrue(methods.isElementClickable(deletionConfirmationButton, 10));
        methods.clickElement(deletionConfirmationButton);

        assertTrue(methods.isElementVisible(playlistDeletedPopUp, 3));
        logger.info("Playlist silindi.");
        methods.waitBySeconds(5);

    }

}
