package dao;

import model.*;

import java.sql.*;

public class CaughtPokemonDAO {
    Connection connection;
    public CaughtPokemonDAO(Connection con) { connection = con; }

    public boolean add(CaughtPokemon pokemon){
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

    public CaughtPokemon get(int trainerID, int caughtPokemonID){
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT"); //FIX ME: QUERY
            if(rs.next()) {
                return new CaughtPokemon(
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
                        );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
