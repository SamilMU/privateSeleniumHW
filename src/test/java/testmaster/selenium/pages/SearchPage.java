package testmaster.selenium.pages;

import org.openqa.selenium.By;
import org.w3c.dom.ranges.Range;
import testmaster.selenium.pages.base.BasePage;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchPage extends BasePage {

    public SearchPage() {
        searchPageAssertions();
    }

    // TODO

    /**
     * Url and tabname
     * "Browse All" and some categories
     * "What do you want to listen to"
     */
    public void searchPageAssertions() {

    }

    public void search(String searchStr) {

        By searchTextBox = By.xpath("//input[@data-testid='search-input']");

        assertTrue(methods.isElementVisible(searchTextBox, 10));

        methods.sendKeys(searchTextBox, searchStr);

    }

    public void addSongs2Playlist() {
        // TODO reach using "Songs", not pos.
        By songsChip = By.xpath("//span[@class='ChipInner-sc-1ly6j4j-0 dLSEQM' and text()='Songs']");

        assertTrue(methods.isElementClickable(songsChip, 10));

        methods.clickElement(songsChip);
        // TODO make sure "Songs" page is opened.
        for (int i = 2; i < 5; i++) {  // Song list index starts at 2.

            String selectedSongStr = "//div[@class='JUa6JJNj7R_Y3i4P8YUX' and @role='presentation']//div[@aria-rowindex=" + i + "]";

            By selectedSong = By.xpath(selectedSongStr);

            methods.hoverElement(selectedSong);
            // TODO Maybe check visibility of more button before getting it in a var.
            By selectedSongMoreButton = By.xpath(selectedSongStr + "//button[@data-testid='more-button']");

            assertTrue(methods.isElementClickable(selectedSongMoreButton, 10));

            methods.clickElement(selectedSongMoreButton);
            // TODO make sure menu is opened.
            String moreButtonMenuItems = "//button[@class='wC9sIed7pfp47wZbmU6m']//span[text()=";

            By addToPlaylistMenuItem = By.xpath(moreButtonMenuItems + "'Add to playlist']");

            methods.hoverElement(addToPlaylistMenuItem);
            // TODO make sure additional menu opened.
            By myPlaylistMenuItem = By.xpath(moreButtonMenuItems + "'Spotify Listem']");

            assertTrue(methods.isElementClickable(myPlaylistMenuItem, 10));

            methods.clickElement(myPlaylistMenuItem);
            // TODO use 'playlist delete check' and check if it is addded.
            methods.waitBySeconds(2);
        }
    }
}
