package dao;

import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CaughtPokemonDAO {

    public boolean add(CaughtPokemon pokemon){
        Connection connection = null; //FIX ME: CONNECTION
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO"); //FIX ME: STATEMENT
            ps.setInt(1, pokemon.getId());
            ps.setInt(2, pokemon.getTrainerId());
            ps.setInt(3, pokemon.getSpeciesId());
            ps.setString(4, pokemon.getSex());
            ps.setInt(5, pokemon.getLevel());
            ps.setString(6, pokemon.getNickname());
            //FIX ME: Add Moves
            int i = ps.executeUpdate();
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    public boolean remove(int trainerID, int caughtPokemonID){
        Connection connection = null; //FIX ME: Connection
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate(""); //FIX ME: STATEMENT
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    public CaughtPokemon get(int trainerID, int caughtPokemonID){
        Connection connection = null; //FIX ME: CONNECTION
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(""); //FIX ME: QUERY
            if(rs.next()) {
                List<Move> moves = new ArrayList<>(); //FIX ME: GET MOVES
                return new CaughtPokemon(rs.getInt(""),
                        rs.getInt(""),
                        rs.getInt(""),
                        rs.getString(""),
                        rs.getInt(""),
                        rs.getString(""),
                        moves
                        ); //FIX ME: COLUMN NAMES
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
