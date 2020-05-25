package handler;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import dao.CaughtPokemonDAO;
import dao.Database;
import dao.TrainerDAO;
import model.Trainer;
import request.AddTrainerRequest;
import response.AddTrainerResponse;
import response.GetSpeciesMovesResponse;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.sql.Connection;

public class AddTrainerHandler extends WriteHandler{
    /**
     * Adds Trainer Model to table
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
                AddTrainerRequest request = gson.fromJson(reqData, AddTrainerRequest.class);

                Connection con = new Database().getConn();
                TrainerDAO trainerDAO = new TrainerDAO(con);
                trainerDAO.add(request.getTrainer());
                //ADD TO RESPONSE

                writeString(new Gson().toJson(new AddTrainerResponse(trainerDAO.size()), AddTrainerResponse.class), exchange.getResponseBody());

                exchange.sendResponseHeaders(HttpURLConnection.HTTP_ACCEPTED, 0);
                reqBody.close();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
