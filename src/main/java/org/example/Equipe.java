package org.example;

import java.util.List;

import modele.User;

public class Equipe {

    private int id;
    private int project_id;
    private List<String> members;

    public Equipe(int id, int project_id, List<String> members) {
        this.id = id;
        this.project_id = project_id;
        this.members = members;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }
}
