package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexioBD {

    private String host = "localhost";
    private String puerto = "3306";
    private String user = "root";
    private String password = "tu contraseña";
    private String basedatos = "pizzeria";

    public ConnexioBD(String host, String puerto, String user, String password, String basedatos) {
        this.host = host;
        this.puerto = puerto;
        this.user = user;
        this.password = password;
        this.basedatos = basedatos;
    }

    public ConnexioBD() {

    }

    public Connection connexioBD() {
        Connection con = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + puerto + "/" + basedatos + "?user=" + user + "&password=" + password + "");

        } catch (SQLException sqle) {

            System.err.println("Codigo error: " + sqle.getErrorCode() + "\n"
                    + "Mensaje: " + sqle.getMessage() + "\n");
        }
        return con;

    }

    public void tacaConnexioDB() {

        try {
            Connection con = connexioBD();
            if (con != null) {
                con.close();
            }
        } catch (SQLException sQLException) {
            System.err.println("Connexio tancada");
        }

    }

}
