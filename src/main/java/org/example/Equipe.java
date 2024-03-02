package org.example;

import java.util.List;

import modele.User;

public class Equipe {

    private int id;
    private List<String> members;

    public Equipe(int id,  List<String> members) {
        this.id = id;
        this.members = members;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }
}
