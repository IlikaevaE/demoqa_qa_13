package tests;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.CredentialsConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.RegistrationFormPage;


public class TestBase {
    static CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
        Configuration.baseUrl = config.baseURL();
        Configuration.browser = System.getProperty("browser");
        Configuration.browserVersion = System.getProperty("browserVersion");
        Configuration.browserSize = System.getProperty("browserSize");
       Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
      // Configuration.remote = String.format("https://%s:%s@%s",config.login(), config.password(), config.remoteWD());


    }

    @AfterEach
    void afterEach() {
        Attach.screenshotAs("Last screenshot");
        Attach.browserConsoleLogs();
        Attach.pageSource();
        Attach.addVideo();
    }
}
