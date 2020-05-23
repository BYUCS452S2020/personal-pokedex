package dao;

import model.*;

import java.sql.*;

public class MoveDAO {
    Connection connection;
    public MoveDAO(Connection con) {
        connection = con;
    }

    public boolean add(Move move){
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO"); //FIX ME: STATEMENT
            ps.setInt(1, move.getId());
            ps.setString(2, move.getName());
            ps.setString(3, move.getType());
            ps.setString(4, move.getText());
            ps.setInt(5, move.getPp());
            ps.setInt(6, move.getBase());
            ps.setInt(7, move.getAccuracy());
            int i = ps.executeUpdate();
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean remove(int moveID){
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE"); //FIX ME: STATEMENT
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public Move get(int moveID){
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT"); //FIX ME: QUERY
            if(rs.next()) {
                return new Move(
                        rs.getInt("MoveID"),
                        rs.getString("MoveName"),
                        rs.getString("MoveType"),
                        rs.getString("MoveText"),
                        rs.getInt("MovePP"),
                        rs.getInt("MoveBase"),
                        rs.getInt("MoveAccuracy")
                        );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
