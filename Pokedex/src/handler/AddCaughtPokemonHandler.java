package handler;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import dao.CaughtPokemonDAO;
import dao.Database;
import request.AddCaughtPokemonRequest;
import request.AddTrainerRequest;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.sql.Connection;

public class AddCaughtPokemonHandler extends WriteHandler{
    /**
     * Adds CaughtPokemon Model to table for specified TrainerId
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
                AddCaughtPokemonRequest request = gson.fromJson(reqData, AddCaughtPokemonRequest.class);

                Connection con = new Database().getConn();
                CaughtPokemonDAO caughtPokemonDAO = new CaughtPokemonDAO(con);
                caughtPokemonDAO.add(request.getCaughtPokemon());

                exchange.sendResponseHeaders(HttpURLConnection.HTTP_ACCEPTED, 0);
                reqBody.close();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
