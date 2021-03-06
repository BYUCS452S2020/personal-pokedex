package handler;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import request.AddTrainerRequest;
import request.GetTrainerRequest;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

public class GetTrainerHandler extends WriteHandler{
    /**
     * Get Trainer Model from table
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
                GetTrainerRequest request = gson.fromJson(reqData, GetTrainerRequest.class);

                //Database db = Database.getInstance();
                //Connection con = db.openConnection();
                //Get Trainer from table

                //DO STUFF
                exchange.sendResponseHeaders(HttpURLConnection.HTTP_ACCEPTED, 0);
                reqBody.close();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
