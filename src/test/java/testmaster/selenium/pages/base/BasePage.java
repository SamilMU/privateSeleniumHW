package testmaster.selenium.pages.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import testmaster.selenium.methods.Methods;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasePage {

    protected Methods methods;
    protected static final Logger logger = LogManager.getLogger(Methods.class);
    protected static String playlistName;

    public BasePage(){
        this.methods = new Methods();
        logger.warn(" Browser language should be English! ");
    }

    public void tabNameAndUrlCheck(String expectedTabName, String actualTabName, String expectedURL, String actualURL){

        assertEquals(expectedTabName, actualTabName);
        assertEquals(expectedURL, actualURL);

        logger.info("Tab ismi ve URL kontrolü yapıldı.");

        // TODO Logged in checks and User checks should be here.
        // TODO Custom playlist clicks and checks should be here.
    }

    public void sideBarCheck(){

        assertTrue(methods.isElementVisible(By.cssSelector("a[href='/search']"),20));
        assertTrue(methods.isElementVisible(By.cssSelector("a[href='/collection']"),20));

    }

    public void loggedInCheck(String username){

            String usernameElement = "figure[data-testid=\"user-widget-avatar\"]" + "[title=\""+ username+"\"]";
            String usernameTitle = methods.getAttribute(By.cssSelector("figure[data-testid=\"user-widget-avatar\"]"),"title");
            String actualUserName = methods.getText(By.xpath("//span[@data-testid='user-widget-name']"));

            Assertions.assertTrue(methods.isElementVisible(By.cssSelector(usernameElement),20));
            Assertions.assertEquals(username, usernameTitle);
            Assertions.assertEquals(username, actualUserName);

    }

    public void visibleElementCheck(By... by){
        for(By byCurrent : by){
            assertTrue(methods.isElementVisible(byCurrent,5));
        }
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

    public long getSongPosition(){
        String songDurationStr = methods.getAttribute(By.xpath("//div[@data-testid='playback-duration']"),
                "data-test-position");
        Long songDuration = Long.parseLong(songDurationStr);
        return songDuration;
    }


}
