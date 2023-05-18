package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterSuite;

public class GoogleSearchTest {
    private WebDriver driver;

    @AfterTest
    public void tearDown() {
        driver.close();
    }
    @AfterSuite
    public void tearDownAll() {
        driver.quit();
    }
    @Test
    public void testGoogleSearchChrome() {
        this.driver = new ChromeDriver();
        GoogleSearchPage googleSearchPage = GoogleSearchPage.builder()
                .driver(driver)
                .searchTextBox(By.name("q"))
                .searchButton(By.name("btnK"))
                .feelingLuckyButton(By.name("btnI"))
                .build();
        googleSearchPage.open();
        googleSearchPage.search("Selenium");
        GoogleResultsPage googleResultsPage = GoogleResultsPage.builder()
                .driver(driver)
                .build();
        googleResultsPage.assertResults("Selenium");

    }

    @Test
    public void testGoogleImFeelingLuckyChrome() {
        this.driver = new ChromeDriver();
        GoogleSearchPage googleSearchPage = GoogleSearchPage.builder()
                .driver(driver)
                .searchTextBox(By.name("q"))
                .searchButton(By.name("btnK"))
                .feelingLuckyButton(By.name("btnI"))
                .build();
        googleSearchPage.open();
        googleSearchPage.searchImFeelingLucky("Selenium");
        GoogleResultsPage googleResultsPage = GoogleResultsPage.builder()
                .driver(driver)
                .build();
        googleResultsPage.assertResultsTitleContains("Selenium");

    }
}
