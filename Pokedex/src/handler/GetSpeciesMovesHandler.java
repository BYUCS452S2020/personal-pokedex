package handler;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import dao.Database;
import dao.MoveDAO;
import dao.PokemonSpeciesDAO;
import javafx.util.Pair;
import model.Move;
import model.PokemonSpecies;
import request.AddTrainerRequest;
import request.GetSpeciesMovesRequest;
import response.GetSpeciesMovesResponse;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class GetSpeciesMovesHandler extends WriteHandler{
    /**
     * Get all species moves from table
     * @param exchange Http crap with request body
     * @throws IOException
     */
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        super.handle(exchange);
        System.out.println("[" + exchange.getRequestMethod().toUpperCase() + "] - " + exchange.getRequestURI().toString());
        try{
            if(exchange.getRequestMethod().toUpperCase().equals("GET")) {
                InputStream reqBody = exchange.getRequestBody();
                String reqData = readString(reqBody);
                Gson gson = new Gson();
                GetSpeciesMovesRequest request = gson.fromJson(reqData, GetSpeciesMovesRequest.class);

                Connection con = new Database().getConn();
                PokemonSpeciesDAO pokemonSpeciesDAO = new PokemonSpeciesDAO(con);


                List<Pair<String, Move>> movePairs = pokemonSpeciesDAO.getMoves(request.getSpeciesID());
                List<String> requirements = new ArrayList<>();
                List<Move> moves = new ArrayList<>();
                for(Pair<String, Move> pair : movePairs){
                    requirements.add(pair.getKey());
                    moves.add(pair.getValue());
                }

                GetSpeciesMovesResponse response = new GetSpeciesMovesResponse((Move[]) moves.toArray(), (String[]) requirements.toArray());
                //ADD TO RESPONSE

                writeString(new Gson().toJson(response,GetSpeciesMovesResponse.class), exchange.getResponseBody());
                exchange.sendResponseHeaders(HttpURLConnection.HTTP_ACCEPTED, 0);
                reqBody.close();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
