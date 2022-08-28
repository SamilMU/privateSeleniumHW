package testmaster.selenium.pages;

import org.openqa.selenium.By;
import testmaster.selenium.methods.Methods;
import testmaster.selenium.pages.base.BasePage;
import testmaster.selenium.test.SpotifyTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPage extends BasePage {

    /** Constants */
    private static String pageUrl = "https://accounts.spotify.com/en/login";
    private static String tabName = "Login - Spotify";

    public void loginPageLoadedCheck(){

        String urlWithoutRedirection = methods.driver.getCurrentUrl().substring(0,37);
        tabNameAndUrlCheck(tabName, methods.driver.getTitle(), pageUrl, urlWithoutRedirection);

        assertTrue(methods.isElementVisible(By.id("login-username"),20));
        assertTrue(methods.isElementVisible(By.id("login-password"),20));
        assertTrue(methods.isElementVisible(By.id("reset-password-link"),20));
        assertTrue(methods.isElementVisible(By.id("login-button"),20));
        assertTrue(methods.isElementVisible(By.xpath("//button[@data-testid='apple-login']"),20));

        // TODO Test this.
        visibleElementCheck(By.id("login-username"),By.id("login-password"),By.id("reset-password-link"),By.id("login-button"));

    }

    public void validLogin(String username, String password){
        
        loginPageLoadedCheck();
        
        methods.sendKeys(By.id("login-username"), username);
        methods.sendKeys(By.id("login-password"), password);
    
        methods.waitByMilliSeconds(200);
        assertTrue(methods.isElementClickable(By.id("login-button"),10));

        methods.clickElement(By.id("login-button"));
        
        methods.waitBySeconds(2);
        
    }

}
