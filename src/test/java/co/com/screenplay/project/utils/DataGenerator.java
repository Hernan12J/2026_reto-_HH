/**
 * @author Hernan J
 * @created 03/22/2026 12:30 p. m.
 */
package co.com.screenplay.project.utils;

import com.github.javafaker.Faker;

public class DataGenerator {

    private static final Faker faker = new Faker();

    public static String generateUsername() {
        return "TestHernan" + faker.number().digits(10);
    }

    public static String generatePassword() {
        return faker.internet().password();
    }
}