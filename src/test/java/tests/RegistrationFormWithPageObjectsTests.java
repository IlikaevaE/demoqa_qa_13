package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static tests.TestData.*;

public class RegistrationFormWithPageObjectsTests extends TestBase {
    @Test
    @DisplayName("Заполняем форму регистрации")
    void successfulTest() {
        step("Открываем форму регистрации", () -> {
            registrationFormPage.openPage();
        });
        step("Заполняем необходимые поля", () -> {
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
        step("Проверяем результат", () -> {
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
