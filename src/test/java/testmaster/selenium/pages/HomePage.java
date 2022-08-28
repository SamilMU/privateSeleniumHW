package testmaster.selenium.pages;

import org.openqa.selenium.By;
import testmaster.selenium.pages.base.BasePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePage extends BasePage {

    /** Constants */
    private static String pageUrl = "https://open.spotify.com/";
    private static String tabName = "Spotify – Web Player";

    public void homePageLoadedCheck(){
        
        tabNameAndUrlCheck(tabName, methods.driver.getTitle(), pageUrl, methods.driver.getCurrentUrl());
        sideBarCheck();
        loggedInCheck("Samil"); // Might take as a parameter.

    }

    public void clickCustomPlaylist(String playlistName){

        By customPlaylistButton = By.xpath("//a[contains(@href,'playlist')]//span[text()='" + playlistName + "']");
        assertTrue(methods.isElementClickable(customPlaylistButton,10));
        methods.clickElementJs(customPlaylistButton);

    }


}
