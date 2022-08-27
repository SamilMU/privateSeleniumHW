package testmaster.selenium.pages.base;

import org.openqa.selenium.By;
import testmaster.selenium.methods.Methods;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasePage {

    protected Methods methods;

    public BasePage(){
        this.methods = new Methods();
    }

    public void assertTabName(){

    }

    public void assertPageLoaded(){

    }

    public void clickSearchButton(){

        By createPlaylistButton = By.xpath("//a[@class='link-subtle ATUzFKub89lzvkmvhpyE' and @href='/search']");

        assertTrue(methods.isElementClickable(createPlaylistButton,10));

        methods.clickElement(createPlaylistButton);

    }

    public void clickCreatePlaylistButton(){

        By createPlaylistButton = By.xpath("//button[@data-testid='create-playlist-button']");

        assertTrue(methods.isElementClickable(createPlaylistButton,10));

        methods.clickElement(createPlaylistButton);

    }


}
