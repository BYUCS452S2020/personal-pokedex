package dao;

import model.Move;

import java.sql.*;

public class Database {

    static {

        try {

            final String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
        }
        catch(ClassNotFoundException e) {

            e.printStackTrace();

        }

    }

    private Connection conn;
    public Connection getConn(){

        return conn;

    }

    public void openConnection(){

        try {

            conn=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/pokdex","guest","CS452");
            conn.setAutoCommit(false);

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

    }

    public void closeConnection(boolean commit){

        try{

            if(commit){

                conn.commit();
            }
            else{
                conn.rollback();
            }

        }catch (SQLException e) {

            System.out.println("connection failed");
        }

    }

    public void createTable(){

        try {
            PreparedStatement TrainerStmt = null;
            PreparedStatement PokemonSpeciesStmt = null;
            PreparedStatement CaughtPokemonStmt = null;
            PreparedStatement MoveStmt = null;
            try {
                String sql = "create table if not exists Trainer\n" +
                        "(\n" +
                        "\tTrainerID text not null,\n" +
                        "\tTrainerName text not null,\n" +
                        "\tTrainerSex text not null,\n" +
                        "\tTrainerHometown text not null,\n" +
                        ");\n";
                String sql2 = "create table if not exists PokemonSpecie\n" +
                        "(\n" +
                        "\tSpeciesName text not null,\n" +
                        "\tSpeciesPokemonName text not null,\n" +
                        "\tSpeciesImageUrl text not null,\n" +
                        "\tSpeciesType1 text not null,\n" +
                        "\tSpeciesType2 text not null,\n" +
                        "\tSpeciesHeight text not null,\n" +
                        "\tSpeciesWeight text not null,\n" +
                        "\tSpeciesText text not null,\n" +
                        "\tSpeciesBaseHP text not null,\n" +
                        "\tSpeciesBaseAttack text not null,\n" +
                        "\tSpeciesBaseDefense text not null,\n" +
                        "\tSpeciesBaseSpecial text not null,\n" +
                        "\tSpeciesBaseSpeed text not null,\n" +
                        ");\n";
                String sql3 = "create table if not exists CaughtPokemon\n" +
                        "(\n" +
                        "\tTrainerID text not null,\n" +
                        "\tSpeciesID text not null,\n" +
                        "\tCaughtPokemonSex text not null,\n" +
                        "\tCaughtPokemonLevel text,\n" +
                        "\tCaughtPokemonNickname text not null,\n" +
                        "\tCaughtPokemonMoveID1 text not null,\n" +
                        "\tCaughtPokemonMoveID2 text not null,\n" +
                        "\tCaughtPokemonMoveID3 text not null,\n" +
                        "\tCaughtPokemonMoveID4 text not null,\n" +
                        ");\n";
                String sql4 = "create table if not exists Move\n" +
                        "(\n" +
                        "\tMoveID text not null,\n" +
                        "\tMoveName text not null,\n" +
                        "\tMoveText text not null,\n" +
                        "\tMovePP text not null,\n" +
                        "\tMoveBase text not null,\n" +
                        "\tMoveAccuracy text not null,\n" +
                        ");\n";
                TrainerStmt = conn.prepareStatement(sql);
                PokemonSpeciesStmt = conn.prepareStatement(sql2);
                CaughtPokemonStmt = conn.prepareStatement(sql3);
                MoveStmt = conn.prepareStatement(sql4);

                TrainerStmt.executeUpdate();
                PokemonSpeciesStmt.executeUpdate();
                CaughtPokemonStmt.executeUpdate();
                MoveStmt.executeUpdate();

                TrainerStmt.close();
                PokemonSpeciesStmt.close();
                CaughtPokemonStmt.close();
                MoveStmt.close();
            } finally {
                if(TrainerStmt !=null){

                    TrainerStmt.close();
                    TrainerStmt = null;

                }
                if(PokemonSpeciesStmt !=null){

                    PokemonSpeciesStmt.close();
                    PokemonSpeciesStmt = null;

                }
                if(CaughtPokemonStmt !=null){

                    CaughtPokemonStmt.close();
                    CaughtPokemonStmt = null;

                }
                if(MoveStmt !=null){

                    MoveStmt.close();
                    MoveStmt = null;

                }
            }
            System.out.println("successfully created!!!");
        }
        catch (SQLException e){
            System.out.println("FAILED TO CREATE");
        }

    }


}