package testmaster.selenium.pages;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import testmaster.selenium.methods.Methods;
import testmaster.selenium.pages.base.BasePage;

public class GuestPage extends BasePage {

    /** Constants */
    private static String pageUrl = "https://open.spotify.com/";
    private static String tabName = "Spotify - Web Player";

    public GuestPage(){
        guestPageLoadedCheck();
        closeTermsFooterIfOpen();
    }

    public void guestPageLoadedCheck(){

        tabNameAndUrlCheck(tabName, methods.driver.getTitle(), pageUrl, methods.driver.getCurrentUrl());
        sideBarCheck();

        assertTrue(methods.isElementVisible(By.xpath("//div[@class='LKFFk88SIRC9QKKUWR5u']//button[text()='Sign up']"),20));
        assertTrue(methods.isElementVisible(By.cssSelector("button[data-testid='login-button']"),20));
        assertTrue(methods.isElementVisible(By.xpath("//section[@data-testid='component-shelf' and @aria-label='Spotify Playlists']"),20));

    }

    public void clickLoginButton(){
    
        By loginButton = By.xpath("//button[@data-testid='login-button']");

        assertTrue(methods.isElementClickable(loginButton,10));

        methods.clickElement(loginButton);

    }

    public void closeTermsFooterIfOpen(){

        By termsDiv = By.cssSelector("div[id='onetrust-banner-sdk']");

        if(methods.isElementVisible(termsDiv,3)){

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
