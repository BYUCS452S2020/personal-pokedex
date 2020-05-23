package dao;

import javafx.util.Pair;
import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PokemonSpeciesDAO {
    Connection connection;
    public PokemonSpeciesDAO(Connection con) { connection = con; }

    public boolean add(PokemonSpecies species){
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

    public PokemonSpecies get(int speciesID){
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT"); //FIX ME: QUERY
            if(rs.next()) {
                List<Pair<String,Move>> moves = new ArrayList<>(); //FIX ME: GET MOVES
                return new PokemonSpecies(
                        rs.getInt("SpeciesID"),
                        rs.getString("SpeciesName"),
                        rs.getString("SpeciesPokemonName"),
                        rs.getString("SpeciesImageUrl"),
                        rs.getString("SpeciesType1"),
                        rs.getString("SpeciesType2"),
                        rs.getString("SpeciesHeight"),
                        rs.getString("SpeciesWeight"),
                        rs.getString("SpeciesText"),
                        rs.getInt("SpeciesBaseHP"),
                        rs.getInt("SpeciesBaseAttack"),
                        rs.getInt("SpeciesBaseDefense"),
                        rs.getInt("SpeciesBaseSpecial"),
                        rs.getInt("SpeciesBaseSpeed"),
                        moves
                ); //FIX ME: COLUMN NAMES
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<Pair<String, Move>> getMoves(int speciesID){
        List<Pair<String, Move>> moves = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT"); //FIX ME: QUERY JOIN TABLES
            while(rs.next()) {
                moves.add(null);//FIX ME: RS.GETS
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return moves;
    }
}
