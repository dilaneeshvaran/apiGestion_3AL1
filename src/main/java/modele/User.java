package modele;

import java.util.List;

public class User {
    private String mail;
    private String name;
    private List <List<Object>> competence;

    public User(String mail, String name, List <List<Object>> competence) {
        this.mail = mail;
        this.name = name;
        this.competence = competence;
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List <List<Object>> getCompetence() {
        return competence;
    }

    public void setCompetence(List <List<Object>> competence) {
        this.competence = competence;
    }
}
