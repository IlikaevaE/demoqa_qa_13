package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static tests.TestData.*;
import static utils.RandomUtils.getRandomGender;
import static utils.RandomUtils.getRandomHobby;

public class RegistrationFormWithPageObjectsTests extends TestBase {
    @Test
    void successfulTest() {
        registrationFormPage.openPage()
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setUserEmail(EMAIL)
                .setGender(GENDER)
                .setUserNumber(PHONE_NUMBER)
                .setDateOfBirth("15", "August", "1980")
                .setSubject(SUBJECT)
                .setHobbies(HOBBY)
                .addAttachment(ATTACHMENT)
                .setAddress(ADDRESS)
                .setState(STATE)
                .setCity(CITY)
                .clickSubmit(SUBMIT_VALUE);

        registrationFormPage
                .checkResult("Student Name", FIRST_NAME + " " + LAST_NAME)
                .checkResult("Student Email", EMAIL)
                .checkResult("Gender", GENDER)
                .checkResult("Mobile", PHONE_NUMBER)
                .checkResult("Date of Birth", "15 August,1980")
                .checkResult("Subjects", SUBJECT)
                .checkResult("Hobbies", HOBBY)
                .checkResult("Picture", ATTACHMENT)
                .checkResult("Address", ADDRESS)
                .checkResult("State and City", STATE + " " + CITY);

    }

}
