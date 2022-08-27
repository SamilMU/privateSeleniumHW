package testmaster.selenium.pages;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import testmaster.selenium.methods.Methods;
import testmaster.selenium.pages.base.BasePage;

public class GuestPage extends BasePage {


    public GuestPage(){

    }

    public void guestPageAssertions(){

        //TODO different assertions

        assertTrue(methods.isElementVisible(By.xpath("//a[@aria-current=\"page\" and ./span[text()=\"Ana sayfa\"]]"),20));
        assertTrue(methods.isElementVisible(By.cssSelector("a[href=\"/search\"]"),20));
        assertTrue(methods.isElementVisible(By.cssSelector("a[href=\"/collection\"]"),20));
        assertTrue(methods.isElementVisible(By.xpath("//button[text()=\"Kaydol\"]"),30));
        assertTrue(methods.isElementVisible(By.cssSelector("button[data-testid=\"login-button\"]"),20));

    }

    public void clickLoginButton(){

        By loginButton = By.xpath("//button[@data-testid='login-button']");

        assertTrue(methods.isElementClickable(loginButton,10));

        methods.clickElement(loginButton);

    }


    /**
     a[href="/search"]
     a[href="/collection"]
     button[data-testid="login-button"]
     //button[text()="Kaydol"]
     */
    //a[@aria-current="page" and ./span[text()="Ana sayfa"]]
}
