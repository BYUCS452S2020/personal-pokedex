package handler;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import dao.Database;
import dao.MoveDAO;
import dao.TrainerDAO;
import request.AddTrainerRequest;
import request.GetMovesRequest;
import response.GetMovesResponse;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.sql.Connection;

public class GetMovesHandler extends WriteHandler{
    /**
     * Get Caught Pokemon Moves from table
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
                GetMovesRequest request = gson.fromJson(reqData, GetMovesRequest.class);

                Connection con = new Database().getConn();
                MoveDAO moveDAO = new MoveDAO(con);

                GetMovesResponse response = new GetMovesResponse(moveDAO.get(request.getMoveID1()),
                        moveDAO.get(request.getMoveID2()),
                        moveDAO.get(request.getMoveID3()),
                        moveDAO.get(request.getMoveID4()));

                //ADD TO RESPONSE
                exchange.sendResponseHeaders(HttpURLConnection.HTTP_ACCEPTED, 0);
                reqBody.close();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
