package testmaster.selenium.pages;

import org.openqa.selenium.By;
import org.w3c.dom.ranges.Range;
import testmaster.selenium.pages.base.BasePage;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchPage extends BasePage {


    public void search(String searchStr){

        By searchTextBox = By.xpath("//input[@data-testid='search-input']");

        assertTrue(methods.isElementVisible(searchTextBox,10));

        methods.sendKeys(searchTextBox, searchStr);

    }

    public void addSongs2Playlist(){


        By songsChip = By.xpath("//a[@class='ZWI7JsjzJaR_G8Hy4W6J' and position()=2]");

        assertTrue(methods.isElementClickable(songsChip,10));

        methods.clickElement(songsChip);

        for(int i=2;i<5;i++){  // Song list index starts at 2.
            
            String selectedSongStr = "//div[@class='JUa6JJNj7R_Y3i4P8YUX' and @role='presentation']//div[@aria-rowindex=" + i + "]";
            
            By selectedSong = By.xpath(selectedSongStr);

            methods.hoverElement(selectedSong);

            By selectedSongMoreButton = By.xpath(selectedSongStr+"//button[@data-testid='more-button']");

            assertTrue(methods.isElementClickable(selectedSongMoreButton,10));

            methods.clickElement(selectedSongMoreButton);

            String moreButtonMenuItems = "//button[@class='wC9sIed7pfp47wZbmU6m']//span[text()=";

            By addToPlaylistMenuItem = By.xpath(moreButtonMenuItems + "'Add to playlist']");

            methods.hoverElement(addToPlaylistMenuItem);

            By myPlaylistMenuItem = By.xpath(moreButtonMenuItems+"'Spotify Listem']");

            assertTrue(methods.isElementClickable(myPlaylistMenuItem,10));

            methods.clickElement(myPlaylistMenuItem);
            
            methods.waitBySeconds(2);

        }
    }
}
