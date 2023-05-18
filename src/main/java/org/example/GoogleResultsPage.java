package org.example;

import lombok.Builder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

@Builder
public class GoogleResultsPage {
    private WebDriver driver;
    @Builder.Default By resultsContainer = By.id("search");

    // asserts google searh results page contains a query string
    public void assertResults(String query) {
        Assert.assertTrue(driver.findElement(resultsContainer).getText().contains(query));
    }

    public void assertResultsTitleContains(String text) {
        Assert.assertTrue(driver.getTitle().contains(text));
    }
}
