package dao;

import javafx.util.Pair;
import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrainerDAO {
    Connection connection;
    public TrainerDAO(Connection con) { connection = con; }

    public boolean add(Trainer trainer){
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
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT"); //FIX ME: QUERY
            if(rs.next()) {
                return new Trainer(
                        rs.getInt("TrainerID"),
                        rs.getString("TrainerName"),
                        rs.getString("TrainerSex"),
                        rs.getString("TrainerHometown")
                ); //FIX ME: COLUMN NAMES
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<CaughtPokemon> getCaughtPokemon(int trainerID){
        List<CaughtPokemon> pokemon = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Trainer t\n" +
                    "    JOIN CaughtPokemon c ON t.TrainerID == c.TrainerID\n" +
                    "        WHERE t.TrainerID == " + trainerID);
            while(rs.next()) {
                pokemon.add(new CaughtPokemon(
                        rs.getInt("CaughtPokemonID"),
                        rs.getInt("TrainerID"),
                        rs.getInt("SpeciesID"),
                        rs.getString("CaughtPokemonSex"),
                        rs.getInt("CaughtPokemonLevel"),
                        rs.getString("CaughtPokemonNickname"),
                        rs.getInt("CaughtPokemonMoveID1"),
                        rs.getInt("CaughtPokemonMoveID2"),
                        rs.getInt("CaughtPokemonMoveID3"),
                        rs.getInt("CaughtPokemonMoveID4")
                ));//FIX ME: RS.GETS
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return pokemon;
    }

    public List<PokemonSpecies> getCaughtSpecies(int trainerID){
        List<PokemonSpecies> species = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT"); //FIX ME: QUERY JOIN TABLES
            while(rs.next()) {
                species.add(null);//FIX ME: RS.GETS
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return species;
    }
}
