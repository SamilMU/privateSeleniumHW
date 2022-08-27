package testmaster.selenium.pages;

import org.openqa.selenium.By;
import testmaster.selenium.pages.base.BasePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlaylistPage extends BasePage {


    public void playlistPageAssertions(){

        //TODO add assertions

    }

    public void changePlaylistName(){

        By playlistNameButton = By.xpath("//button[@class='wCkmVGEQh3je1hrbsFBY']");

        assertTrue(methods.isElementClickable(playlistNameButton,10));

        methods.clickElement(playlistNameButton);

        By playlistNewNameTextBox = By.xpath("//input[@data-testid='playlist-edit-details-name-input']");

        assertTrue(methods.isElementVisible(playlistNewNameTextBox,10));
        // TODO collect constants to somewhere. This playlist name str can be used in search page.
        methods.sendKeys(playlistNewNameTextBox, "Spotify Listem");
        // TODO maybe add description as well
        By playlistEditSaveButton = By.xpath("//button[@data-testid='playlist-edit-details-save-button']");

        assertTrue(methods.isElementClickable(playlistEditSaveButton,10));

        methods.clickElement(playlistEditSaveButton);

    }

    public void play2ndSongFor10Sec(){

        String secondSongMenuItemStr = "//div[@class='JUa6JJNj7R_Y3i4P8YUX']//div[@aria-rowindex='3']";
        
        By secondSongMenuItem = By.xpath(secondSongMenuItemStr);

        methods.scrollElementIfNeeded(secondSongMenuItem);

        methods.waitBySeconds(2);
        
        //TODO make hover work and there can be a lot of assertions here
        
        methods.clickElement(By.xpath(secondSongMenuItemStr+"//span[@class='Type__TypeElement-goli3j-0 eDbSCl']"));

        By playButton = By.xpath(secondSongMenuItemStr+"//button[@class='RfidWIoz8FON2WhFoItU']");

        assertTrue(methods.isElementClickable(playButton,10));

        methods.clickElement(playButton);

        methods.waitBySeconds(10);

        methods.clickElement(By.xpath("//button[@data-testid='control-button-playpause']"));
        
    }
    
    public void remove3rdSongFromPlaylist(){
        
        String thirdSongMenuItemStr = "//div[@class='JUa6JJNj7R_Y3i4P8YUX']//div[@aria-rowindex='4']";
    
        By thirdSongMenuItem = By.xpath(thirdSongMenuItemStr);
    
        methods.hoverElement(thirdSongMenuItem);
    
        By selectedSongMoreButton = By.xpath(thirdSongMenuItemStr+"//button[@data-testid='more-button']");
    
        assertTrue(methods.isElementClickable(selectedSongMoreButton,10));
    
        methods.clickElement(selectedSongMoreButton);
    
        String moreButtonMenuItems = "//button[@class='wC9sIed7pfp47wZbmU6m']//span[text()=";
    
        By removeSongFromPlaylistMenuItem = By.xpath(moreButtonMenuItems + "'Remove from this playlist']");
    
        methods.clickElement(removeSongFromPlaylistMenuItem);
    
        methods.waitBySeconds(2);
        
    }
    
    public void removePlaylist(){
    
        By selectedSongMoreButton = By.xpath("//div[@class='eSg4ntPU2KQLfpLGXAww']//button[@data-testid='more-button']");
    
        methods.scrollElementIfNeeded(selectedSongMoreButton);
        
        assertTrue(methods.isElementClickable(selectedSongMoreButton,10));
        
        methods.clickElement(selectedSongMoreButton);
        
        methods.clickElement(By.xpath("//button[@class='wC9sIed7pfp47wZbmU6m']//span[text()='Delete']"));
        
        By deletionConfirmationButton = By.xpath("//button[@class='Button-qlcn5g-0 hgTVhT']//span[text()='DELETE']");
    
        assertTrue(methods.isElementClickable(deletionConfirmationButton,10));
        
        methods.clickElement(deletionConfirmationButton);
        
        assertTrue(methods.isElementVisible(By.cssSelector("div[class=AOaoydTb5lrGytHbTAAy]"),3));
    
        methods.waitBySeconds(5);
    
    }
}
