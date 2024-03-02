package BDD;

import org.example.Equipe;
import org.example.Projet;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

import modele.User;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Database {
    private String filename="src\\main\\java\\resources\\sample.json";

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
                user = new User((String) person.get("mail"), (String) person.get("name"), (List <List<Object>>) person.get("competence"));
                System.out.println("competence::::::::::::::" +person.get("competence"));
                userList.add(user);
            }

        return userList;
    }

public void addMemberToTeam(int teamId, User member) {
    JSONArray data = readJsonFile();
    boolean memberExist = false;

    for (Object companyObj : data) {
        JSONObject company = (JSONObject) companyObj;
        JSONArray teams = (JSONArray) company.get("teams");
        
        for (Object teamObj : teams) {
            JSONObject team = (JSONObject) teamObj;
            Long teamIdLong = (Long) team.get("team_id");
            int id = teamIdLong.intValue();
            if (id == teamId) {
                JSONArray members = (JSONArray) team.get("members");
                for (Object memObj : members) {
                    if (memObj instanceof String) {
                        String mem = (String) memObj;
                        if (member.getMail().equals(mem)) {
                            memberExist=true;
                            break;
                        }
                    }
                }
                if(!memberExist){
                    members.add(member.getMail());
                    System.out.println("members::::::::::::::" + team.get("members"));
                    break;
                }
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


public void createTeam(Equipe equipe)
{
    JSONArray data = readJsonFile();
    JSONArray teams;
    JSONObject newTeam = new JSONObject();
    newTeam.put("team_id", equipe.getId());
    newTeam.put("members", equipe.getMembers());

    for (Object companyObj : data) {
        JSONObject company = (JSONObject) companyObj;
        teams = (JSONArray) company.get("teams");
        teams.add(newTeam);
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

public void recruitDeveloper(User member) {
    JSONArray data = readJsonFile();

    JSONObject dev;
    String devId;
    JSONArray developers;
    boolean mailAlreadyExist = false;

    for (Object companyObj : data) {
        JSONObject company = (JSONObject) companyObj;
        developers = (JSONArray) company.get("developers");
        for (Object devObj : developers) 
        if (devObj instanceof JSONObject) {{
            dev = (JSONObject) devObj;
            devId = (String) dev.get("mail");
            if (member.getMail().equals(devId)) {
                mailAlreadyExist=true;
                break;
            }
        }}
        if (!mailAlreadyExist) {
            JSONObject newDeveloper = new JSONObject();
            newDeveloper.put("mail", member.getMail());
            newDeveloper.put("name", member.getName());
            newDeveloper.put("competence", member.getCompetence());
            developers.add(newDeveloper);
            System.out.println("devs::::::::::::::" + company.get("developers"));
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

public void fireDeveloper(User member)
{
    JSONArray data = readJsonFile();
    JSONObject dev;
    String devId;
    JSONArray developers;

    for (Object companyObj : data) {
        JSONObject company = (JSONObject) companyObj;
        developers = (JSONArray) company.get("developers");
        for (Object devObj : developers) {
            dev = (JSONObject) devObj;
            devId = (String) dev.get("mail");
            if (member.getMail().equals(devId)) {
                developers.remove(dev);
                System.out.println("devs::::::::::::::" + company.get("developers"));
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
public void transferDev(User member, int fromTeam, int toTeam) {
    JSONArray data = readJsonFile();
    JSONArray teams;
    JSONArray members;
    boolean memberExist = false;

    for (Object companyObj : data) {
        JSONObject company = (JSONObject) companyObj;
        teams = (JSONArray) company.get("teams");
        for (Object teamObj : teams) {
            JSONObject team = (JSONObject) teamObj;
            Long teamIdLong = (Long) team.get("team_id");
            int id = teamIdLong.intValue();
            if (id == fromTeam) {
                members = (JSONArray) team.get("members");
                for (Object memObj : members) {
                    if (memObj instanceof String) {
                        String mem = (String) memObj;
                        if (member.getMail().equals(mem)) {
                            memberExist = true;
                            members.remove(mem);
                            break;
                        }
                    }
                }
            }
            if (id == toTeam && memberExist) {
                members = (JSONArray) team.get("members");
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

public List<User> getDevByStackXp(String stack, int xp) {
    JSONArray data = readJsonFile();
    User user = null;
    List<User> userList = new ArrayList<>();

    for (Object companyObj : data) {
        JSONObject company = (JSONObject) companyObj;
        JSONArray developers = (JSONArray) company.get("developers");
        for (Object dev : developers) {
            JSONObject person = (JSONObject) dev;
            user = new User((String) person.get("mail"), (String) person.get("name"), (List <List<Object>>) person.get("competence"));
            for (Object competence : user.getCompetence()) {
                List<Object> skillset = (List<Object>) competence;
                if (skillset.get(0).equals(stack) && (Long) skillset.get(1) >= xp) {
                    userList.add(user);
                }
            }
        }
    }
    return userList;
}


public Projet nextStartingProject() {
    JSONArray data = readJsonFile();
    Projet projet = null;
    List<Projet> projets = new ArrayList<>();

    for (Object companyObj : data) {
        JSONObject company = (JSONObject) companyObj;
        JSONArray projects = (JSONArray) company.get("projects");
        for (Object proj : projects) {
            JSONObject project = (JSONObject) proj;
            if (project.get("status").equals("waiting")) {
                projet = new Projet((int) (long) project.get("projectId"), (String) project.get("name"), (String) project.get("description"), (String) project.get("endDate"), (String) project.get("startDate"), (String) project.get("priority"), (String) project.get("status"), (List <List<Object>>) project.get("requiredDevsPerStack"));
                projets.add(projet);
            }
        }
    }
    projets.sort((p1, p2) -> p1.getDateDebut().compareTo(p2.getDateDebut()));
    return projets.get(0);

}

public void removeProjets(int projectId)
    {
        JSONArray data = readJsonFile();
        JSONArray projects ;
        JSONObject projectToRemove = null;

        for (Object obj : data){
            JSONObject company = (JSONObject) obj;
            projects = (JSONArray) company.get("projects");
            for (Object projectsObj: projects){
                JSONObject project = (JSONObject) projectsObj;
                long id = (long) project.get("projectId");
                        if (id == projectId) {
                            projectToRemove = project;
                            break;
                        }
            }
            if (projectToRemove != null) {
                projects.remove(projectToRemove);
                break;
            }
        }
        JSONObject output = new JSONObject ( );
        output.put("company", data);

        try(FileWriter file = new FileWriter(filename)) {
            file.write(output.toJSONString( ));
            file.flush ( );
        } catch (IOException e) {
            e.printStackTrace( );
        }
    }

   public void proposeProject(Projet project)
{

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    LocalDate startDate = LocalDate.parse(project.getDateDebut(), formatter);
    LocalDate endDate = LocalDate.parse(project.getDateFin(), formatter);

    // Check if projet is more than 1 month
    long duration = ChronoUnit.MONTHS.between(startDate, endDate);
    if (duration <= 1) {
        System.out.println("Project must last more than 1 month");
        return;
    }

    // Check end date is afetr start date
    if (startDate.compareTo(endDate) >= 0) {
        System.out.println("End date should be after start date");
        return;
    }
    List<String> members = new ArrayList<>();
    Equipe equipe=null;
    List<User> devs = new ArrayList<>();
    
    if(project.getRequiredDevsPerStack().size() >= 0) {
        for (List<Object> stack : project.getRequiredDevsPerStack()) {
            devs = getDevByStackXp((String) stack.get(1), (int) stack.get(0));
            if (devs.size() == 0) {
                System.out.println("Project canceled, no available devs for stack " + stack.get(0));
                return;
            } else {
                for (User dev : devs) {
                    if (!members.contains(dev.getMail())) {
                        members.add(dev.getMail());
                        break;
                    }
                }
            }
            equipe = new Equipe(3, members);
        }
        createTeam(equipe);
    }


    JSONArray data = readJsonFile();
    JSONArray projects;
    JSONObject newProject = new JSONObject();
    newProject.put("projectId", project.getId());
    newProject.put("name", project.getNom());
    newProject.put("description", project.getDescriptif());
    newProject.put("endDate", project.getDateFin());
    newProject.put("startDate", project.getDateDebut());
    newProject.put("priority", project.getPriority());
    newProject.put("status", project.getStatus());
    newProject.put("requiredDevsPerStack", project.getRequiredDevsPerStack());
    newProject.put("team_id", equipe.getId());
    

    for (Object companyObj : data) {
        JSONObject company = (JSONObject) companyObj;
        projects = (JSONArray) company.get("projects");
        projects.add(newProject);
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