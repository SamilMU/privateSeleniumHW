package testmaster.selenium.test;

import org.junit.jupiter.api.Test;
import testmaster.selenium.driver.Driver;
import testmaster.selenium.pages.*;

public class SpotifyTest extends Driver {

    GuestPage guestPage;
    LoginPage loginPage;
    HomePage homePage;
    PlaylistPage playlistPage;
    SearchPage searchPage;

    @Test
    public void loginTest(){

        /**
        https://github.com/YunusBalaman/TestmasterSeleniumProject
         */
        System.out.println("Spotify");
        init();
//        guestPage.controlGuestPage();
        guestPage.clickLoginButton();
//        loginPage.controlLoginPage();
        loginPage.validLogin("yunussahabt@gmail.com","Testinium2022");
        homePage.loginControl("YunusB");

    }

    public void seleniumTestAutomationHWTest(){
        init();
        guestPage.clickLoginButton();
        loginPage.validLogin("samil.unal@testinium.com","@webbcry37228");
        homePage.loginControl("Samil");

        homePage.clickCustomPlaylist();

        playlistPage.changePlaylistName();

        playlistPage.clickSearchButton();

        searchPage.search("Daft Punk");

        searchPage.addSongs2Playlist();

        searchPage.clickCreatePlaylistButton();

        playlistPage.play2ndSongFor10Sec();

    }

    public void init(){
        guestPage = new GuestPage();
        loginPage = new LoginPage();
        homePage = new HomePage();
        playlistPage = new PlaylistPage();
        searchPage = new SearchPage();
    }
}
