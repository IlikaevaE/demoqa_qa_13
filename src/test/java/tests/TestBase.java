package tests;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import pages.RegistrationFormPage;

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
        SelenideLogger.addListener("allure", new AllureSelenide());
        Attach attach = new Attach();
        Attach.takeScreenshot("Last screenshot");
        Attach.browserConsoleLogs();
        Attach.pageSource();
        Attach.addVideo();
    }
}
