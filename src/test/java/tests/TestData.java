package tests;

import com.github.javafaker.Faker;

import static utils.RandomUtils.*;

public class TestData {
    static Faker faker = new Faker();
    public final static String FIRST_NAME = faker.address().firstName(),
            LAST_NAME = faker.address().lastName(),
            EMAIL = faker.internet().emailAddress(),
            GENDER = getRandomGender(),
            PHONE_NUMBER = String.valueOf(faker.number().randomNumber(10, true)),
            DAY = "15",
            MONTH = "August",
            YEAR = "1980",
            SUBJECT = getRandomSubject(),
            HOBBY = getRandomHobby(),
            ATTACHMENT = "Picture.PNG",
            ADDRESS = faker.witcher().quote(),
            STATE = "NCR",
            CITY = "Delhi",
            SUBMIT_VALUE = "Thanks for submitting the form";


}
