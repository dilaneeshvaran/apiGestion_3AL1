package org.example;

import java.util.ArrayList;
import java.util.List;

import BDD.Database;
import io.javalin.Javalin;
import modele.User;

public class Main {
    public static void main(String[] args) {

        Database database = new Database();

       //List<String> developers = database.fetchAllDevelopers();
       List<User> users = database.fetchAllDevelopers();
       //database.addMemberToTeam(0,users.get(1));

       //new skill list for testing
       List <List<Object>> competence= new ArrayList<>();
       List<Object> skillset1 = new ArrayList<>();
       skillset1.add("c#");
        skillset1.add(8);
        competence.add(skillset1);

        List<Object> skillset2 = new ArrayList<>();
        skillset2.add("js");
        skillset2.add(10);
        competence.add(skillset2);

        List <List<Object>> requiredDevsPerStack= new ArrayList<>();
        List<Object> stack1 = new ArrayList<>();
        stack1.add(2);
        stack1.add("php");
        requiredDevsPerStack.add(stack1);

        List<Object> stack2 = new ArrayList<>();
        stack2.add(3);
        stack2.add("java");
        requiredDevsPerStack.add(stack2);

       

       //create new user to test recruit
       User user=new User("jd@gmail.com", "kokku", competence);
       database.removeProjets(0);
       Projet project = database.nextStartingProject();
       //database.recruitDeveloper(user);
       //database.fireDeveloper(user);
       //database.transferDev(user, 0, 1);
       List<User> usersBySkill = database.getDevByStackXp("php", 2);

       Projet newProject = new Projet(0, "projet1", "description", "2021-12-12", "2021-10-11", "high", "in progress", requiredDevsPerStack);
       database.proposeProject(newProject);

        var app = Javalin.create(/*config*/)
                .get("/", ctx -> {
            // Get data from JSON file

            // Set JSON data as response
            //ctx.result(developers.get(0));
            ctx.result(project.getNom());
            //user.getName();
        })
        .start(7070);
    }
}