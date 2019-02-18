package com.athiththan.feign;

import com.athiththan.feign.adapter.JSONPlaceholder;
import com.athiththan.feign.dao.User;

import feign.Feign;
import feign.gson.GsonDecoder;

public class Application {
    public static void main(String[] args) {

        System.out.println("Feign Application started");

        JSONPlaceholder jsonPlaceholder = Feign.builder().decoder(new GsonDecoder()).target(JSONPlaceholder.class,
                "https://jsonplaceholder.typicode.com/users");

        System.out.println("List all users\n");

        // get all users from JSONPlaceholder
        jsonPlaceholder.users().stream().forEach(user -> System.out.println(user.toString()));

        System.out.println("\nList all emails of users\n");

        // get all users email address only
        jsonPlaceholder.users().stream().forEach(user -> System.out.println(user.getEmail()));

        System.out.println("\nGet a particular user by using his/her id\n");

        // get a user by id
        User user = jsonPlaceholder.users(1);
        System.out.println(user.toString());

        System.out.println("\nGet all post titles of a user using userId\n");

        // get all post titles of a user using userId
        jsonPlaceholder.posts(9).stream().forEach(p -> System.out.println(p.getTitle()));
    }
}
