package org.example;

import java.util.List;

public class User {
    public int userid;
    public  String name;
    public  String email;
    List <Stack> devSack;
    public int niveau;

    public User(String name, String email, int niveau, List <Stack> sackList) {
        this.name = name;
        this.email = email;
        this.niveau = niveau;
        this.devSack = sackList;
    }
}
