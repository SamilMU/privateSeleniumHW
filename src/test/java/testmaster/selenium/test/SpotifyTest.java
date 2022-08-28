package testmaster.selenium.test;

import org.junit.jupiter.api.Test;
import testmaster.selenium.driver.Driver;
import testmaster.selenium.pages.*;

public class SpotifyTest extends Driver {

    private static final String playlistName = "Spotify Listem";
    private static final String userEMail = "samil.unal@testinium.com";
    private static final String password = "@webbcry37228";
    GuestPage guestPage;
    LoginPage loginPage;
    HomePage homePage;
    PlaylistPage playlistPage;
    SearchPage searchPage;

    @Test
    public void seleniumTestAutomationHWTest(){

        init();
        
        guestPage.clickLoginButton();

        loginPage.validLogin(userEMail,password);
        
        homePage.homePageLoadedCheck();
        
        homePage.clickCreatePlaylistButton();

        playlistPage.changePlaylistName(playlistName);

        playlistPage.clickSearchButton();

        searchPage.search("Daft Punk");

        searchPage.addSongs2Playlist(3);

        // Song name is can be partial but it is case-sensitive.
        homePage.clickCustomPlaylist(playlistName);

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
