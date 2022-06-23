package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static tests.TestData.*;

public class RegistrationFormWithPageObjectsTests extends TestBase {
    @Test
    @DisplayName("Fill in the registration form")
    void successfulTest() {
        step("Open the registration form", () -> {
            registrationFormPage.openPage();
        });
        step("Fill in the needed fields", () -> {
            registrationFormPage
                    .setFirstName(FIRST_NAME)
                    .setLastName(LAST_NAME)
                    .setUserEmail(EMAIL)
                    .setGender(GENDER)
                    .setUserNumber(PHONE_NUMBER)
                    .setDateOfBirth(DAY, MONTH, YEAR)
                    .setSubject(SUBJECT)
                    .setHobbies(HOBBY)
                    .addAttachment(ATTACHMENT)
                    .setAddress(ADDRESS)
                    .setState(STATE)
                    .setCity(CITY)
                    .clickSubmit(SUBMIT_VALUE);
        });
        step("Check the results", () -> {
            registrationFormPage
                    .checkResult("Student Name", FIRST_NAME + " " + LAST_NAME)
                    .checkResult("Student Email", EMAIL)
                    .checkResult("Gender", GENDER)
                    .checkResult("Mobile", PHONE_NUMBER)
                    .checkResult("Date of Birth", DAY + " " + MONTH + "," + YEAR)
                    .checkResult("Subjects", SUBJECT)
                    .checkResult("Hobbies", HOBBY)
                    .checkResult("Picture", ATTACHMENT)
                    .checkResult("Address", ADDRESS)
                    .checkResult("State and City", STATE + " " + CITY);
        });


    }

}
