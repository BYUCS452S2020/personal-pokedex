package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private Connection con;
    private static Database db_instance = null;
    /**
     * Opens a new connection
     */
    public static Database getInstance() {
        if(db_instance == null) {
            db_instance = new Database();
        }

        return db_instance;
    }

    public Connection openConnection()
    {
        try {
            Class.forName("org.sqlite.JDBC");
            final String CONNECTION_URL = "jdbc:sqlite:./dungeons.db";
            con = DriverManager.getConnection(CONNECTION_URL);
            con.setAutoCommit(false);
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("You're killing me smalls");
        }

        return con;
    }

    public void closeConnection(boolean commit)
    {
        try {
            if (commit) {
                con.commit();
            }
            else {
                con.rollback();
            }

            con.close();
            con = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
