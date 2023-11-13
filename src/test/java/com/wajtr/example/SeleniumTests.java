package com.wajtr.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SeleniumTests {

    @LocalServerPort
    private int port;

    @BeforeAll
    static void init() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }

    @Test
    void firefoxWebDriverTest() {
    var driver = new FirefoxDriver();
        try {
            performTest(driver);
        } finally {
            driver.quit();
        }
    }

    @Test
    void chromeWebDriverTest() {
        var driver = new ChromeDriver();
        try {
            performTest(driver);
        } finally {
            driver.quit();
        }
    }

    private void performTest(RemoteWebDriver driver) {
        driver.get("http://localhost:" + port);

        var ordinaryElement = driver.findElement(By.id("ordinary-element"));
        assertThat(ordinaryElement.getText()).isEqualTo("Text inside ordinary element");

        var webComponentElement = driver.findElement(By.id("test-web-component"));
        assertThat(webComponentElement.getText()).isEqualTo("Text inside web component slot");
    }

}
