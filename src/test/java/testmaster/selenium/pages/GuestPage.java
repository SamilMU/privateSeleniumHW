package testmaster.selenium.pages;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import testmaster.selenium.methods.Methods;
import testmaster.selenium.pages.base.BasePage;

public class GuestPage extends BasePage {

    /** Constants */
    private static String pageUrl = "https://open.spotify.com/";
    private static String tabName = "Spotify – Web Player";
    private static By signUpButton = By.xpath("//div[@class='LKFFk88SIRC9QKKUWR5u']//button[text()='Sign up']");
    private static By loginButton = By.cssSelector("button[data-testid='login-button']");
    private static By componentShelf = By.xpath("//section[@data-testid='component-shelf' and @aria-label='Spotify Playlists']");
    private static By closeTermsPopUpButton = By.cssSelector("div[id='onetrust-banner-sdk']");

    public GuestPage(){
        guestPageLoadedCheck();
        closeTermsFooterIfOpen();
    }

    public void guestPageLoadedCheck(){

        tabNameAndUrlCheck(tabName, methods.driver.getTitle(), pageUrl, methods.driver.getCurrentUrl());
        sideBarCheck();

        assertTrue(methods.isElementVisible(signUpButton,10));
        assertTrue(methods.isElementVisible(loginButton,20));
        assertTrue(methods.isElementVisible(componentShelf,20));

    }

    public void clickLoginButton(){

        assertTrue(methods.isElementClickable(loginButton,10));
        methods.clickElement(loginButton);
        methods.waitBySeconds(5);

    }

    public void closeTermsFooterIfOpen(){

        if(methods.isElementVisible(closeTermsPopUpButton,3)){

            By termsAndCookiesButton = By.xpath("//button[@class='onetrust-close-btn-handler onetrust-close-btn-ui banner-close-button ot-close-icon']");
            assertTrue(methods.isElementClickable(termsAndCookiesButton,10));
            methods.clickElement(termsAndCookiesButton);

        }

    }

    /**
     a[href="/search"]
     a[href="/collection"]
     button[data-testid="login-button"]
     //button[text()="Kaydol"]
     */
    //a[@aria-current="page" and ./span[text()="Ana sayfa"]]
}
