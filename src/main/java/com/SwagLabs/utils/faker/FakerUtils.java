package com.swaglabs.utils.faker;

import com.github.javafaker.Faker;
import com.swaglabs.utils.TimeManager;

import java.util.Locale;

public class FakerUtils {

    private static final Faker faker = new Faker(new Locale("en"));

    private FakerUtils() {}

    private static String escape(String input) {
        return input.replace("'", "''");
    }

    public static String generateName() {
        return escape(faker.name().firstName());
    }

    public static String generateEmail() {
        return faker.internet().emailAddress()
                .replace("@", TimeManager.getSimpleTimestamp() + "@");
    }

    public static String generatePassword() {
        return faker.internet().password(8, 16, true, true, true);
    }

    public static String generateCompany() {
        return escape(faker.company().name());
    }

    public static String generateAddress() {
        return escape(faker.address().fullAddress());
    }

    public static String generateCity() {
        return escape(faker.address().city());
    }

    public static String generateZipCode() {
        return faker.address().zipCode();
    }

    public static String generatePhoneNumber() {
        return faker.number().digits(11);
    }
}
