package dao;

import javafx.util.Pair;
import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrainerDAO {
    public boolean add(Trainer trainer){
        Connection connection = null; //FIX ME: CONNECTION
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO"); //FIX ME: STATEMENT
            ps.setInt(1, trainer.getId());
            ps.setString(2, trainer.getName());
            ps.setString(3, trainer.getSex());
            ps.setString(4, trainer.getHometown());
            int i = ps.executeUpdate();
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean remove(int trainerID){
        Connection connection = null; //FIX ME: Connection
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

    public Trainer get(int trainerID){
        Connection connection = null; //FIX ME: CONNECTION
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT"); //FIX ME: QUERY
            if(rs.next()) {
                return new Trainer(
                        rs.getInt(""),
                        rs.getString(""),
                        rs.getString(""),
                        rs.getString("")
                ); //FIX ME: COLUMN NAMES
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<CaughtPokemon> getCaughtPokemon(int trainerID){
        Connection connection = null; //FIX ME: CONNECTION
        List<CaughtPokemon> pokemon = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT"); //FIX ME: QUERY
            while(rs.next()) {
                pokemon.add(new CaughtPokemonDAO().get(trainerID, rs.getInt("")));//FIX ME: COLUMN NAME
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return pokemon;
    }

    public List<PokemonSpecies> getCaughtSpecies(int trainerID){
        Connection connection = null; //FIX ME: CONNECTION
        List<PokemonSpecies> species = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT"); //FIX ME: QUERY
            while(rs.next()) {
                species.add(new PokemonSpeciesDAO().get(rs.getInt("")));//FIX ME: COLUMN NAME
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return species;
    }
}
