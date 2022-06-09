package tests;

import org.junit.jupiter.api.Test;
import static tests.TestData.*;

public class RegistrationFormWithPageObjectsTests extends TestBase {
    @Test
    void successfulTest() {
        registrationFormPage.openPage()
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

        registrationFormPage
                .checkResult("Student Name", FIRST_NAME + " " + LAST_NAME)
                .checkResult("Student Email", EMAIL)
                .checkResult("Gender", GENDER)
                .checkResult("Mobile", PHONE_NUMBER)
                .checkResult("Date of Birth", DAY + " " +MONTH +"," + YEAR)
                .checkResult("Subjects", SUBJECT)
                .checkResult("Hobbies", HOBBY)
                .checkResult("Picture", ATTACHMENT)
                .checkResult("Address", ADDRESS)
                .checkResult("State and City", STATE + " " + CITY);

    }

}
