package dao;

import javafx.util.Pair;
import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PokemonSpeciesDAO {
    public boolean add(PokemonSpecies species){
        Connection connection = null; //FIX ME: CONNECTION
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO"); //FIX ME: STATEMENT
            ps.setInt(1,species.getId());
            ps.setString(2, species.getName());
            ps.setString(3, species.getSpeciesName());
            ps.setString(4, species.getImgUrl());
            ps.setString(5, species.getType1());
            ps.setString(6, species.getType2());
            ps.setString(7, species.getHeight());
            ps.setString(8, species.getWeight());
            ps.setString(9, species.getText());
            ps.setInt(10, species.getHp());
            ps.setInt(11, species.getAttack());
            ps.setInt(12, species.getDefense());
            ps.setInt(13, species.getSpecial());
            ps.setInt(14, species.getSpeed());
            //FIX ME: Insert Moves
            int i = ps.executeUpdate();
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    public boolean remove(int speciesID){
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
    public PokemonSpecies get(int speciesID){
        Connection connection = null; //FIX ME: CONNECTION
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(""); //FIX ME: QUERY
            if(rs.next()) {
                List<Pair<String,Move>> moves = new ArrayList<>(); //FIX ME: GET MOVES
                return new PokemonSpecies(
                        rs.getInt(""),
                        rs.getString(""),
                        rs.getString(""),
                        rs.getString(""),
                        rs.getString(""),
                        rs.getString(""),
                        rs.getString(""),
                        rs.getString(""),
                        rs.getString(""),
                        rs.getInt(""),
                        rs.getInt(""),
                        rs.getInt(""),
                        rs.getInt(""),
                        rs.getInt(""),
                        moves
                ); //FIX ME: COLUMN NAMES
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
