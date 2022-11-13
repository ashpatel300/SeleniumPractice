package com.automation.application.shoppingcart.testDataManager;

import com.github.javafaker.Faker;

import java.util.Date;

public class RandomDataGenerator {

    public static String getUserName(){
        return new Faker().name().username();
    }
    public static String getFirstName(){
        return new Faker().name().firstName();
    }
    public static String getLastName(){
        return new Faker().name().lastName();
    }
    public static String getEmailAddress(){
        return new Faker().internet().safeEmailAddress();
    }
    public static Date getDateOfBirth(){
        return new Faker().date().birthday();
    }
    public static String get(){
        return new Faker().name().username();
    }
    public static String getPassword(){
        return new Faker().internet().password();
    }



    public static void main(String[] args) {

        System.out.println(RandomDataGenerator.getUserName());
    }
}
