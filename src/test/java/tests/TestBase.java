package tests;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.RegistrationFormPage;

public class TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1820x980";
        //Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

    }
    @AfterEach
     void afterEach() {
        Attach.screenshotAs("Last screenshot");
        Attach.browserConsoleLogs();
        Attach.pageSource();
        Attach.addVideo();
    }
}
