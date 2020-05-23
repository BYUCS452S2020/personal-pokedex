import com.sun.net.httpserver.HttpServer;
import handler.*;
import model.*;

import java.io.IOException;
import java.net.InetSocketAddress;

public class PokedexServer {
    public static void main(String[] args) throws IOException {
        new PokedexServer().startServer(8020);
    }


    private void startServer(int port) throws IOException {
        InetSocketAddress serverAddress = new InetSocketAddress(port);
        HttpServer server = HttpServer.create(serverAddress, 10);
        registerHandlers(server);
        server.start();
        System.out.println("FamilyMapServer listening on port " + port);
    }

    private void registerHandlers(HttpServer server) {
        server.createContext("/add/trainer/pokemon", new AddCaughtPokemonHandler());
        server.createContext("/add/trainer", new AddTrainerHandler());
        server.createContext("/get/trainer/pokemon", new GetCaughtSpeciesHandler());
        server.createContext("/get/trainer/pokemon/moves", new GetMovesHandler());
        server.createContext("/pokemon/moves", new GetSpeciesMovesHandler());
        server.createContext("/get/trainer", new GetTrainerHandler());

    }
}