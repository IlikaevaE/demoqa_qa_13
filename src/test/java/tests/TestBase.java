package tests;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attachments;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.RegistrationFormPage;

import static com.codeborne.selenide.Selenide.webdriver;

public class TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1820x980";
        //  Configuration.holdBrowserOpen = true;
    }
    @AfterEach
     void afterEach() {
        Attachments.takeScreenshot("Last screenshot");
        Attachments.browserConsoleLogs();
        Attachments.pageSource();
        Attachments.addVideo();
    }
}
