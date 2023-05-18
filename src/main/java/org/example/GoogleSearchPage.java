package org.example;

import lombok.Builder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Builder
public class GoogleSearchPage {
    private WebDriver driver;
    private By searchTextBox;
    private By searchButton;
    private By feelingLuckyButton;

    public void open() {
        this.driver.get("https://www.google.com");
    }

    public void search(String query) {
        this.driver.findElements(searchTextBox).get(0).sendKeys(query);
        this.driver.findElements(searchButton).get(1).click();
    }

    public void searchImFeelingLucky(String selenium) {
        this.driver.findElements(searchTextBox).get(0).sendKeys(selenium);
        this.driver.findElements(feelingLuckyButton).get(1).click();
    }
}