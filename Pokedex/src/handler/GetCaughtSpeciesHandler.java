package handler;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import dao.CaughtPokemonDAO;
import dao.Database;
import dao.TrainerDAO;
import model.CaughtPokemon;
import model.PokemonSpecies;
import model.Trainer;
import request.AddTrainerRequest;
import request.GetCaughtSpeciesRequest;
import response.GetCaughtSpeciesResponse;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.sql.Connection;

public class GetCaughtSpeciesHandler extends WriteHandler{
    /**
     * Gets Caught Species + Pokemon array from table
     * @param exchange Http crap with request body
     * @throws IOException
     */
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        super.handle(exchange);
        System.out.println("[" + exchange.getRequestMethod().toUpperCase() + "] - " + exchange.getRequestURI().toString());
        try{
            if(exchange.getRequestMethod().toUpperCase().equals("POST")) {
                InputStream reqBody = exchange.getRequestBody();
                String reqData = readString(reqBody);
                Gson gson = new Gson();
                GetCaughtSpeciesRequest request = gson.fromJson(reqData, GetCaughtSpeciesRequest.class);

                Connection con = new Database().getConn();
                TrainerDAO trainerDAO = new TrainerDAO(con);
                GetCaughtSpeciesResponse response = new GetCaughtSpeciesResponse(
                        (CaughtPokemon[]) trainerDAO.getCaughtPokemon(request.getTrainerID()).toArray(),
                        (PokemonSpecies[]) trainerDAO.getCaughtPokemon(request.getTrainerID()).toArray());


                //ADD TO RESPONSEs
                exchange.sendResponseHeaders(HttpURLConnection.HTTP_ACCEPTED, 0);
                reqBody.close();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
