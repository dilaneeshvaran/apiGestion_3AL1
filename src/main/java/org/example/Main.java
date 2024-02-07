package org.example;

import java.util.List;

import BDD.Database;
import io.javalin.Javalin;
import modele.User;

public class Main {
    public static void main(String[] args) {

        Database database = new Database();

       //List<String> developers = database.fetchAllDevelopers();
       List<User> users = database.fetchAllDevelopers();
       database.addMemberToTeam(0,users.get(1));

        var app = Javalin.create(/*config*/)
                .get("/", ctx -> {
            // Get data from JSON file

            // Set JSON data as response
            //ctx.result(developers.get(0));
            ctx.result(users.get(1).getName());
            //user.getName();
        })
        .start(7070);
    }
}