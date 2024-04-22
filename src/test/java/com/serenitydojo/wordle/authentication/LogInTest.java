package com.serenitydojo.wordle.authentication;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogInTest {

    WebDriver driver;

    @BeforeEach
    void openDriver() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void closeDriver() {
        driver.quit();
    }

    @Nested
    @DisplayName("When logging in")
    class WhenLoggingIn {

        @Test
        @DisplayName("The first page the user sees should invite the player to log in")
        void the_first_page_the_user_sees_should_invite_the_player_to_log_in() {

            driver.get("http://localhost:5173/");

            Assertions.assertThat(driver.getTitle()).isEqualTo("Wordle");
        }

        @Test
        @DisplayName("A user should be able to log in with a valid username and password")
        void a_user_should_be_able_to_log_in_with_a_valid_username_and_password() {

        }

        @Test
        @DisplayName("A user should not be able to log in with an invalid username and password")
        void a_user_should_not_be_able_to_log_in_with_an_invalid_username_and_password() {

        }

        @Test
        @DisplayName("A user should not be able to log in with an empty username and password")
        void a_user_should_not_be_able_to_log_in_with_an_empty_username_and_password() {

        }
    }
}
