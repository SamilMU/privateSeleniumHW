package testmaster.selenium.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import testmaster.selenium.methods.Methods;
import testmaster.selenium.pages.base.BasePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePage extends BasePage {

    /** Constants */
    private static String pageUrl = "https://open.spotify.com/";
    private static String tabName = "Spotify - Web Player";

    public HomePage(){

        homePageLoadedCheck();

    }

    public void homePageLoadedCheck(){

        tabNameAndUrlCheck(tabName, methods.driver.getTitle(), pageUrl, methods.driver.getCurrentUrl());
        sideBarCheck();
        loggedInCheck("Samil"); // Might take as a parameter.

    }


    //TODO can take a playlist name but there are hidden elemets atop.
    public void clickCustomPlaylist(){

        By customPlaylistButton = By.xpath("//div[@class='AINMAUImkAYJd4ertQxy']");

        assertTrue(methods.isElementClickable(customPlaylistButton,10));

        methods.clickElement(customPlaylistButton);

    }

}
