package repository;

import BDD.Database;
import modele.User;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserRepository {
    private Database coBdd;
    private String table = "User";
    private String tableTow = "competance";

    public UserRepository() {
        coBdd = new Database();
    }

    public User inscription (User utilisateur) throws SQLException{
        String sql;
        PreparedStatement pstm;


            sql = "INSERT INTO `"+table+"`( `nom`, `email`) VALUES (?,?)";

            pstm = coBdd.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, utilisateur.getName());
            pstm.setString(3, utilisateur.getEmail());
            pstm.executeUpdate();
            ResultSet rs = pstm.getGeneratedKeys();
            if(rs.next())
            {
                int last_inserted_id = rs.getInt(1);
                System.out.println(last_inserted_id);
                utilisateur.getUserid(last_inserted_id);
            }

        return utilisateur;
    }

    public User getUserByCompetance(String email) {
        User utilisateur = null;
        String sql = "SELECT * FROM " + table + " WHERE email=?";
        PreparedStatement pstm;
        try {
            pstm = coBdd.getConnection().prepareStatement(sql);
            pstm.setString(1, email);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                System.out.println(rs.getString("nom"));
                utilisateur = new User(rs.getInt("id_user"), rs.getString("nom"), rs.getString("email"));
            }
        } catch (SQLException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }

        return utilisateur;
    }

}
