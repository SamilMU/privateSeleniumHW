package testmaster.selenium.pages;

import org.openqa.selenium.By;
import org.w3c.dom.ranges.Range;
import testmaster.selenium.pages.base.BasePage;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchPage extends BasePage {


    private static String pageUrl = "https://open.spotify.com/search";
    private static String tabName = "Spotify – Search";
    private static By searchTextBox = By.xpath("//input[@data-testid='search-input']");
    private static By chipOfSongs = By.xpath("//span[@class='ChipInner-sc-1ly6j4j-0 dLSEQM' and text()='Songs']");
    private static By selectedListItem;

    public SearchPage() {
        searchPageLoadedCheck("");
    }

    public void searchPageLoadedCheck(String searchStr) {

        String searchPageUrl = methods.driver.getCurrentUrl();
        if (searchStr != "") {
            searchPageUrl = searchPageUrl + "/" + searchStr;
        }

        tabNameAndUrlCheck(tabName, methods.driver.getTitle(), pageUrl, searchPageUrl);

        assertTrue(methods.isElementVisible(By.xpath("//h2[contains(text(),'Browse')]"), 20));
        assertTrue(methods.isElementVisible(By.xpath("//h3[contains(text(),'Podcasts')]"), 20));


    }

    public void search(String searchStr) {

        assertTrue(methods.isElementVisible(searchTextBox, 10));
        methods.sendKeys(searchTextBox, searchStr);
        searchPageLoadedCheck(searchStr);

    }

    public void addSongs2Playlist() {

        assertTrue(methods.isElementClickable(chipOfSongs, 10));

        methods.clickElement(chipOfSongs);

        assertTrue(methods.isElementVisible(By.xpath("//div[contains(@aria-label,'All songs for')]"), 20));

        for (int i = 2; i < 5; i++) {  // Song list index starts at 2.

            String selectedSongStr = "//div[@class='JUa6JJNj7R_Y3i4P8YUX' and @role='presentation']//div[@aria-rowindex=" + i + "]";

            selectedListItem = By.xpath(selectedSongStr);
            methods.hoverElement(selectedListItem);

            By selectedSongMoreButton = By.xpath(selectedSongStr + "//button[@data-testid='more-button']");
            assertTrue(methods.isElementClickable(selectedSongMoreButton, 10));
            methods.clickElement(selectedSongMoreButton);

            String moreButtonMenuItems = "//button[@class='wC9sIed7pfp47wZbmU6m']//span[text()=";
            By addToPlaylistMenuItem = By.xpath(moreButtonMenuItems + "'Add to playlist']");
            methods.hoverElement(addToPlaylistMenuItem);

            By myPlaylistMenuItem = By.xpath(moreButtonMenuItems + "'" + playlistName + "']");
            assertTrue(methods.isElementClickable(myPlaylistMenuItem, 10));

            methods.clickElement(myPlaylistMenuItem);
            methods.waitBySeconds(2);
        }
    }
}
