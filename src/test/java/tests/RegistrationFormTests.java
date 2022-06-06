package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationFormTests extends TestBase {

    @Test
    void successfulTest() {
        String firstName = "Sandra";
        String lastName = "Fischer";
        String email = "sandra@gmail.com";
        String phone = "8952658963";
        String address = "Bremen Street, 14";
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));


        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);

        /**Gender*/
        $("#genterWrapper").$(byText("Female")).click(); // 2. way to choose Gender
        //  $("[for=gender-radio-2]").click(); // - WRONG
        // $("#gender-radio-2").parent().click(); // the 1. way to choose Gender

        /**Mobile*/
        $("#userNumber").setValue(phone);

        /**Date of Birth*/
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__year-select").selectOption("1980");
        $(".react-datepicker__day--015").click(); // - выбираем 15 число
        // $(byText("15")).click(); // - неверный способ

        /**Subjects*/
        $("#subjectsInput").sendKeys("Accounting");
        $("#subjectsInput").pressEnter();

        /**Hobbies*/
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();

        /**Attachments*/
        $("#uploadPicture").uploadFromClasspath("Picture.PNG");

        /**Current Address*/
        $("#currentAddress").setValue(address);

        /**State and City*/
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();

        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();

        /**Submit*/
        $("#submit").click();

        /**Asserts */

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive").shouldHave(
                text(firstName),
                text(lastName),
                text(email),
                text("Female"),
                text(phone),
                text("Accounting"),
                text("Sports"),
                text("Reading"),
                text("Picture.PNG"),
                text(address),
                text("Haryana"),
                text("Karnal")
        );
        /**checking calendar */
 //       $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("15 August,1980")); // 1 способ

        checkTable("Date of Birth", "15 August,1980"); // лучше использовать этот способ

        Selenide.sleep(5000);

    }
    void checkTable(String key, String value){
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value));
    }
}
