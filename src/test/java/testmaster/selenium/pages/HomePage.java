package testmaster.selenium.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import testmaster.selenium.methods.Methods;
import testmaster.selenium.pages.base.BasePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePage extends BasePage {


    public HomePage(){

    }

    public void loginControl(String username){

        String usernameElement = "figure[data-testid=\"user-widget-avatar\"]" +
                "[title=\""+ username+"\"]";

        Assertions.assertTrue(methods.isElementVisible(By.cssSelector(usernameElement),20));
        String usernameTitle = methods.getAttribute(By.cssSelector("figure[data-testid=\"user-widget-avatar\"]"),"title");
        Assertions.assertEquals(username, usernameTitle);
        String actualUserName = methods.getText(By.cssSelector("figure[data-testid=\"user-widget-avatar\"][title=\"YunusB\"]" +
                " ~ span[data-testid=\"user-widget-name\"]"));
        Assertions.assertEquals(username, actualUserName);
    }

    public void clickCustomPlaylist(){

        By customPlaylistButton = By.xpath("//div[@class='os-content']//span[text()='Spotify Listem']");

        assertTrue(methods.isElementClickable(customPlaylistButton,10));

        methods.clickElement(customPlaylistButton);

    }

}
