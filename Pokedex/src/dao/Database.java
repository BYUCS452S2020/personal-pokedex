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
            conn = DriverManager.getConnection("jdbc:mysql://localhost/test?" + "user=minty&password=greatsqldb");

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
                        "\ttrainerID text not null,\n" +
                        "\ttrainerName text not null,\n" +
                        "\ttrainerSex text not null,\n" +
                        "\ttrainerHometown text not null,\n" +
                        ");\n";
                String sql2 = "create table if not exists PokemonSpecie\n" +
                        "(\n" +
                        "\t text not null,\n" +
                        "\ttrainerName text not null,\n" +
                        "\ttrainerSex text not null,\n" +
                        "\ttrainerHometown text not null,\n" +
                        ");\n";
                String sql3 = "create table if not exists CaughtPokemon\n" +
                        "(\n" +
                        "\tpokemonID text not null,\n" +
                        "\ttrainerID text not null,\n" +
                        "\tspecieID text not null,\n" +
                        "\tsex text,\n" +
                        "\tpokemonLevel text not null,\n" +
                        "\tpokemonNickname text not null,\n" +
                        ");\n";
                String sql4 = "create table if not exists Move\n" +
                        "(\n" +
                        "\ttrainerID text not null,\n" +
                        "\ttrainerName text not null,\n" +
                        "\ttrainerSex text not null,\n" +
                        "\ttrainerHometown text not null,\n" +
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
