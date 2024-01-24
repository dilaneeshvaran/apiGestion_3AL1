package BDD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private String url = "jdbc:mysql://localhost/projet_lprs_java?serverTimezone=UTC";
    private String user = "projetlprs";
    private String password = "lprs18Po220@";
    public Connection getConnection() {

        try {
            Connection cnx = DriverManager.getConnection(this.url,this.user,this.password);
            //System.out.print("Etat de la connexion :");
            //System.out.print(cnx.isClosed()?"fermée":"ouverte \r\n");
            return cnx;

        } catch (SQLException e) {
            System.out.print("erreur");
            e.printStackTrace();
            return null;
        }
    }
}


