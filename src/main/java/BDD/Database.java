package BDD;

import org.example.Equipe;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

import modele.User;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private String filename="C:\\Users\\jilla\\IdeaProjects\\java-project-2\\src\\main\\java\\resources\\sample.json";

    @SuppressWarnings("unchecked")
public JSONArray readJsonFile() {
    JSONArray data = new JSONArray();
        try {
            FileReader reader = new FileReader(filename);

            JSONParser jsonParser = new JSONParser();

            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

            data = (JSONArray) jsonObject.get("company");
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
}


    public List<User> fetchAllDevelopers() {
        JSONArray data = readJsonFile();
        User user = null;
        List<User> userList = new ArrayList<>();

        JSONObject firstObject = (JSONObject) data.get(0);
        JSONArray developers = (JSONArray) firstObject.get("developers");
            System.out.println("developers::::::::::::::" +developers.toString());

            for (Object dev : developers) {
                JSONObject person = (JSONObject) dev;
                user = new User((String) person.get("mail"), (String) person.get("name"), (List<String>) person.get("competence"));
                System.out.println("competence::::::::::::::" +person.get("competence"));
                userList.add(user);
            }

        return userList;
    }

    public List<String> fetchAllProjects() {
        List<String> projects = new ArrayList<>();

        for (Object dataObj : projects) {
            JSONObject data = (JSONObject) dataObj;
            projects.add((String) data.get("projectName"));
        }
        return projects;
    }

    public List<String> fetchAllTeams() {
        List<String> teams = new ArrayList<>();

        for (Object dataObj : teams) {
            JSONObject data = (JSONObject) dataObj;
            teams.add((String) data.get("teamName"));
        }
        return teams;
    }

public void addMemberToTeam(int teamId, User member) {
    JSONArray data = readJsonFile();

    for (Object companyObj : data) {
        JSONObject company = (JSONObject) companyObj;
        JSONArray teams = (JSONArray) company.get("teams");

        for (Object teamObj : teams) {
            JSONObject team = (JSONObject) teamObj;
            Long teamIdLong = (Long) team.get("team_id");
            int id = teamIdLong.intValue();
            if (id == teamId) {
                JSONArray members = (JSONArray) team.get("members");
                members.add(member.getMail());
                System.out.println("members::::::::::::::" + team.get("members"));
                break;
            }
        }
    }

    JSONObject output = new JSONObject();
    output.put("company", data);

    try (FileWriter file = new FileWriter(filename)) {
        file.write(output.toJSONString());
        file.flush();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}