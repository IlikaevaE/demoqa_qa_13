package utils;

import org.checkerframework.checker.index.qual.PolyUpperBound;

import java.util.Random;

public class RandomUtils {
    public static String getRandomGender() {
        String[] gender = {"Male", "Female", "Other"};
        Random random = new Random();
        String newGender = gender[random.nextInt(gender.length)];

        return newGender;
    }
    public static String getRandomHobby() {
        String[] hobby = {"Sports", "Reading", "Music"};
        Random random = new Random();
        String newHobby = hobby[random.nextInt(hobby.length)];
        return newHobby;
    }
    public static String getRandomSubject() {
        String[] subject = {"Social Studies", "Maths", "Economics", "English", "Arts", "Biology", "Physics",
                "Chemistry", "Hindi", "Computer Science", "Accounting", "History"};
        Random random = new Random();
        String newSubject = subject[random.nextInt(subject.length)];
        return newSubject;
    }
}
