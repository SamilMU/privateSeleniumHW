package testmaster.selenium.test;

import org.junit.jupiter.api.Test;
import testmaster.selenium.driver.Driver;
import testmaster.selenium.pages.*;

public class SpotifyTest extends Driver {

    // TODO Cleaner method names and less gibberish class-more clean names(use more steps if necessary.)
    // TODO More loggers. Differ the project further from the source.
    // TODO Additionally separate Test classes
    // TODO Git Page.
    // TODO POM check
    // TODO Check BDD and Gauge, maybe apply if time allows.

    GuestPage guestPage;
    LoginPage loginPage;
    HomePage homePage;
    PlaylistPage playlistPage;
    SearchPage searchPage;

    @Test
    public void seleniumTestAutomationHWTest(){
        init();
        guestPage.clickLoginButton();
        loginPage.validLogin("samil.unal@testinium.com","@webbcry37228");
        //homePage.loginControl("Samil");
        
        homePage.clickCreatePlaylistButton();

        playlistPage.changePlaylistName("Spotify Listem");

        playlistPage.clickSearchButton();

        searchPage.search("Daft Punk");

        searchPage.addSongs2Playlist();

        // Song name is can be partial but it is case-sensitive.
        homePage.clickCustomPlaylist("Spotify Listem");

        // Song name is can be partial but it is case-sensitive.
        playlistPage.playSong("Instant Crush",10);
        
        playlistPage.removeSongFromPlaylist(3);
        
        playlistPage.removePlaylist();

    }

    public void init(){
        guestPage = new GuestPage();
        loginPage = new LoginPage();
        homePage = new HomePage();
        playlistPage = new PlaylistPage();
        searchPage = new SearchPage();
    }
}
