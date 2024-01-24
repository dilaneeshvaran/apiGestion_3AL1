package modele;

import org.example.Competance;

import java.util.List;

public class User {
    public int userid;
    public  String name;
    public  String email;
    List <Competance> devCompetance;

    public User(String name, String email, List <Competance> sackList) {
        this.name = name;
        this.email = email;
        this.devCompetance = sackList;
    }

    public User(int userid, String name, String email) {
        this.userid = userid;
        this.name = name;
        this.email = email;
    }

    public int getUserid(int last_inserted_id) {
        return userid;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Competance> getDevCompetance() {
        return devCompetance;
    }
}
