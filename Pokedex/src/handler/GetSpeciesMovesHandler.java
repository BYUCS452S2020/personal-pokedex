package handler;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import request.AddTrainerRequest;
import request.GetSpeciesMovesRequest;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

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
            if(exchange.getRequestMethod().toUpperCase().equals("POST")) {
                InputStream reqBody = exchange.getRequestBody();
                String reqData = readString(reqBody);
                Gson gson = new Gson();
                GetSpeciesMovesRequest request = gson.fromJson(reqData, GetSpeciesMovesRequest.class);

                //Database db = Database.getInstance();
                //Connection con = db.openConnection();
                //Get moves from table

                //DO STUFF
                exchange.sendResponseHeaders(HttpURLConnection.HTTP_ACCEPTED, 0);
                reqBody.close();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
