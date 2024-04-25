package com.serenitydojo.wordle;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class E2EBase {

    protected WebDriver driver;

    @BeforeEach
    void openDriver() {
        if (System.getProperty("driverName").equals("chrome")) {
            driver = new ChromeDriver();
        } else {
            driver = new FirefoxDriver();
        }
    }

    @AfterEach
    void closeDriver() {
        driver.quit();
    }


}
