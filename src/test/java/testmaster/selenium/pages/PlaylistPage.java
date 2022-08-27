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

        By secondSongMenuItem = By.xpath("//div[@class='JUa6JJNj7R_Y3i4P8YUX']//div[@aria-rowindex='2']");

        methods.scrollElementCenter(secondSongMenuItem);

        methods.hoverElement(secondSongMenuItem);

        By playButton = By.xpath("//button[@class='RfidWIoz8FON2WhFoItU']");

        assertTrue(methods.isElementClickable(playButton,10));

        methods.clickElement(playButton);

        methods.waitBySeconds(10);



    }
}
