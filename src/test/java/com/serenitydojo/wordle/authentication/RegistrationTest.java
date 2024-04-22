package com.serenitydojo.wordle.authentication;

import com.serenitydojo.wordle.testdata.Player;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class RegistrationTest {
    WebDriver driver;

    @BeforeEach
    void openDriver() {
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1024, 768));
    }

    @AfterEach
    void closeDriver() {
        driver.quit();
    }

    @Test
    @DisplayName("User should be able to register from the home page")
    void user_should_be_able_to_register_from_the_home_page() {
        driver.get("http://localhost:5173/");

        driver.findElement(By.linkText("Create Account")).click();

        WebElement heading = driver.findElement(By.className("section-heading"));

        assertThat(heading.isDisplayed()).isTrue();
        assertThat(heading.getText()).isEqualTo("Sign up");
    }

    @Test
    @DisplayName("The registration page should display the required fields")
    void registration_page_should_display_the_required_fields() {
        driver.get("http://localhost:5173/signup");

        WebElement nameField = driver.findElement(By.id("name"));
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement countryField = driver.findElement(By.id("country"));

        assertThat(nameField.isDisplayed()).isTrue();
        assertThat(passwordField.isDisplayed()).isTrue();
        assertThat(emailField.isDisplayed()).isTrue();
        assertThat(countryField.isDisplayed()).isTrue();
    }

    @Test
    void a_user_can_create_a_new_account_by_providing_the_mandatory_information() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        Player newPlayer = Player.newPlayer();
        driver.get("http://localhost:5173/signup");

        driver.findElement(By.id("name")).sendKeys(newPlayer.name());
        driver.findElement(By.id("email")).sendKeys(newPlayer.email());
        driver.findElement(By.id("password")).sendKeys(newPlayer.password());
        new Select(driver.findElement(By.id("country")))
                .selectByVisibleText(newPlayer.country());
        driver.findElement(By.id("create-account")).click();

        assertThat(driver.getCurrentUrl()).isEqualTo("http://localhost:5173/signup");

        waitUntilTheScreenSettles();
        driver.findElement(By.id("name")).sendKeys(newPlayer.name());
        driver.findElement(By.id("password")).sendKeys(newPlayer.password());
        driver.findElement(By.id("login")).click();

        wait.until(ExpectedConditions.urlToBe("http://localhost:5173/game"));

        assertThat(driver.getCurrentUrl()).isEqualTo("http://localhost:5173/game");
    }

    void waitUntilTheScreenSettles() {
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
