package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalenderComponent;
import pages.components.ResultsTableComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {
    CalenderComponent calenderComponent = new CalenderComponent();
    ResultsTableComponent resultsTableComponent = new ResultsTableComponent();

    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            mobileNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbyInput = $("#hobbiesWrapper"),
            attachmentInput = $("#uploadPicture"),
            stateClick = $("#state"),
            stateInput = $("#stateCity-wrapper"),
            cityClick = $("#city"),
            cityInput = $("#stateCity-wrapper"),
            submitClick = $("#submit"),
            submitCheck = $("#example-modal-sizes-title-lg");


    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setGender(String value) {
        genderInput.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setUserNumber(String value) {
        mobileNumberInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        calenderComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationFormPage setSubject(String value) {
        subjectInput.sendKeys(value);
        subjectInput.pressEnter();
        return this;
    }

    public RegistrationFormPage setHobbies(String value) {
        hobbyInput.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage addAttachment(String value) {
        attachmentInput.uploadFromClasspath(value);
        return this;
    }

    public RegistrationFormPage setState(String value) {
        stateClick.click();
        stateInput.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setCity(String value) {
        cityClick.click();
        cityInput.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setAddress(String value) {
        $("#currentAddress").setValue(value);
        return this;
    }

    public RegistrationFormPage clickSubmit(String value) {
        submitClick.click();
        submitCheck.shouldHave(text(value));
        return this;
    }

    public RegistrationFormPage checkResult(String key, String value) {
        resultsTableComponent.checkResult(key, value);
        return this;
    }

}
