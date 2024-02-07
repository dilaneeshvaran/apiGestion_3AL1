package modele;

import java.util.List;

public class User {
    private String mail;
    private String name;
    private List<String> competence;

    public User(String mail, String name, List<String> competence) {
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

    public List<String> getCompetence() {
        return competence;
    }

    public void setCompetence(List<String> competence) {
        this.competence = competence;
    }
}
