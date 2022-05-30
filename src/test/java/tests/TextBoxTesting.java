package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTesting {

    @BeforeAll
    static void BeforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1820x980";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void successfulTest() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");


        $("[id=firstName]").setValue("Sandra");
        $("[id=lastName]").setValue("Fischer");
        $("[id=userEmail]").setValue("sandra@gmail.com");
        $(byText("Female")).click();
        $("[id =userNumber]").setValue("8952658963");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__year-select").selectOption("1980");
        $(byText("15")).click();

        $(".subjects-auto-complete__input").click();
        $("#subjectsInput").sendKeys("Accounting");
        $("#subjectsInput").pressEnter();

        $(byText("Sports")).click();
        $(byText("Reading")).click();

        $("#uploadPicture").uploadFromClasspath("Picture.PNG");

        $("[id=currentAddress]").setValue("Bremen Street, 14");

        $("#react-select-3-input").setValue("Haryana");
        $("#react-select-3-input").pressEnter();

        $("#react-select-4-input").setValue("Karnal");
        $("#react-select-4-input").pressEnter();

        $("[id=submit]").click();

        $(".modal-content").shouldHave(
                text("Sandra"),
                text("Fischer"),
                text("sandra@gmail.com"),
                text("Female"),
                text("8952658963"),
                text("August"),
                text("1980"),
                text("15"),
                text("Accounting"),
                text("Sports"),
                text("Reading"),
                text("Picture.PNG"),
                text("Bremen Street, 14"),
                text("Haryana"),
                text("Karnal")
        );

    }


}
