package utils;

import api.User;
import com.github.javafaker.Faker;

public class DataGenerator {
    static Faker faker= new Faker();
    public static String EMAIL = faker.internet().safeEmailAddress().toString();
    public static String PASS = faker.internet().password(6, 30);
    public static String WRONG_PASS = faker.internet().password(1,5);
    public static String NAME = faker.name().username().toString();
    public static User randomUser(){
        return new User()
                .withName(NAME)
                .withEmail(EMAIL)
                .withPassword(PASS);
    }
    public static User randomWrongUser(){
        return new User()
                .withName(NAME)
                .withEmail(EMAIL)
                .withPassword(WRONG_PASS);
    }
}
