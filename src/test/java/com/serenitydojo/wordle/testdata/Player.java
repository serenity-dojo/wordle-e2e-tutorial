package com.serenitydojo.wordle.testdata;

import com.github.javafaker.Faker;

public record Player(String name, String email, String password, String country, boolean optin) {
    public static Player newPlayer() {
        Faker fake = Faker.instance();
        return new Player(
                fake.name().username(),
                fake.internet().emailAddress(),
                "Player!123",
                "Brazil",
                true
        );
    }
}
