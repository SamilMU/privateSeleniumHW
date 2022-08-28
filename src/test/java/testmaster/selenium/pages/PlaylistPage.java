package testmaster.selenium.pages;

import org.openqa.selenium.By;
import testmaster.selenium.pages.base.BasePage;

import static org.junit.jupiter.api.Assertions.*;

public class PlaylistPage extends BasePage {


    /**
     * Constants
     */
    private static String pageUrl = "https://open.spotify.com/playlist/";
    private static String tabName = "Spotify - My Playlist";

    public PlaylistPage() {
        playlistPageLoadedCheck();
    }

    public void playlistPageLoadedCheck() {

        String urlWithoutRedirection = methods.driver.getCurrentUrl().substring(0, 33);
        String defaultTabName = methods.driver.getTitle().substring(0, 20);

        tabNameAndUrlCheck(tabName, defaultTabName, pageUrl, urlWithoutRedirection);
        sideBarCheck();

        assertTrue(methods.isElementVisible
                (By.xpath("//div[@data-testid='action-bar-row']//button[@data-testid='more-button']"),
                        20));

    }

    public void changePlaylistName(String newPlaylistName) {


        By playlistNameButton = By.xpath("//button[@class='wCkmVGEQh3je1hrbsFBY']");
        assertTrue(methods.isElementClickable(playlistNameButton, 10));
        methods.clickElement(playlistNameButton);


        By playlistNewNameTextBox = By.xpath("//input[@data-testid='playlist-edit-details-name-input']");

        assertTrue(methods.isElementVisible(playlistNewNameTextBox, 10));
        assertTrue(methods.isElementVisible(By.xpath
                        ("//div[@class='CU0wnmWejIvyEsRRtSac']//button[@data-testid='edit-image-button']"),
                20));
        methods.sendKeys(playlistNewNameTextBox, newPlaylistName);


        By playlistSaveButton = By.xpath("//button[@data-testid='playlist-edit-details-save-button']");
        assertTrue(methods.isElementClickable(playlistSaveButton, 10));
        methods.clickElement(playlistSaveButton);

    }

    // TODO

    /**
     * data-testid:"playback-position" or value of data-testid:"playback-duration"
     */
    public void playSong(String songName, long duration) {

        String wantedMenuItem = "//div[contains(text(),'"+ songName +"')]";
        By menuItemBy = By.xpath(wantedMenuItem);
        methods.scrollElementIfNeeded(menuItemBy);

        //TODO test hover
        //methods.hoverElement(menuItemBy);

        By playButton = By.xpath(wantedMenuItem + "//button[@class='RfidWIoz8FON2WhFoItU']");
        assertTrue(methods.isElementClickable(playButton, 10));

        methods.clickElement(By.xpath(wantedMenuItem + "//span[@class='Type__TypeElement-goli3j-0 eDbSCl']"));

        assertTrue(methods.isElementClickable(playButton, 10));

        methods.clickElement(playButton);


        Long songPos = getSongPosition();
        while(songPos<duration*1000){
            methods.waitByMilliSeconds(500);
            songPos = getSongPosition();
        }

        methods.clickElement(By.xpath("//button[@data-testid='control-button-playpause']"));
        methods.waitByMilliSeconds(500);
        assertEquals(getSongPosition(),songPos);

    }



    // TODO get index as parameter.
    public void removeSongFromPlaylist(int index) {

        // TODO use global playlist name const
        String playlistSizeXPath = "//div[@aria-label='Spotify Listem']//div[@role='row']";
        int playlistSize = methods.countChildObjects(playlistSizeXPath);
        String wantedMenuItem = "//div[@class='JUa6JJNj7R_Y3i4P8YUX']//div[@aria-rowindex='" + index+1 + "']";
        By wantedMenuItemBy = By.xpath(wantedMenuItem);
        methods.hoverElement(wantedMenuItemBy);

        By selectedSongMoreButton = By.xpath(wantedMenuItem + "//button[@data-testid='more-button']");
        assertTrue(methods.isElementClickable(selectedSongMoreButton, 10));
        methods.clickElement(selectedSongMoreButton);

        assertTrue(methods.isElementVisible(By.xpath("//div[@id='context-menu']"),5));

        String moreButtonMenuItems = "//button[@class='wC9sIed7pfp47wZbmU6m']//span[text()=";
        By removeSongFromPlaylistMenuItem = By.xpath(moreButtonMenuItems + "'Remove from this playlist']");
        methods.clickElement(removeSongFromPlaylistMenuItem);
        // TODO use 'playlist remove check' to check if song is removed.
        methods.waitBySeconds(1);
        assertNotEquals(methods.countChildObjects(playlistSizeXPath), playlistSize);

    }

    public void removePlaylist() {

        By selectedSongMoreButton = By.xpath("//div[@class='eSg4ntPU2KQLfpLGXAww']//button[@data-testid='more-button']");
        methods.scrollElementIfNeeded(selectedSongMoreButton);
        assertTrue(methods.isElementClickable(selectedSongMoreButton, 10));

        methods.clickElement(selectedSongMoreButton);
        // TODO make sure menu is opened.
        methods.clickElement(By.xpath("//button[@class='wC9sIed7pfp47wZbmU6m']//span[text()='Delete']"));
        // TODO check if PopUp is existent.
        By deletionConfirmationButton = By.xpath("//button[@class='Button-qlcn5g-0 hgTVhT']//span[text()='DELETE']");

        assertTrue(methods.isElementClickable(deletionConfirmationButton, 10));

        methods.clickElement(deletionConfirmationButton);

        assertTrue(methods.isElementVisible(By.cssSelector("div[class=AOaoydTb5lrGytHbTAAy]"), 3));

        methods.waitBySeconds(5);

    }
}
