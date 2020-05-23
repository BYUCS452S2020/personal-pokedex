package server;

import com.sun.net.httpserver.HttpServer;
import handlers.*;
import model.Spell;
import model.Weapon;

import java.io.IOException;
import java.net.InetSocketAddress;

public class DungeonsServer {
    public static void main(String[] args) throws IOException {
        new DungeonsServer().startServer(8020);
    }


    private void startServer(int port) throws IOException {
        InetSocketAddress serverAddress = new InetSocketAddress(port);
        HttpServer server = HttpServer.create(serverAddress, 10);
        registerHandlers(server);
        server.start();
        System.out.println("FamilyMapServer listening on port " + port);
    }

    private void registerHandlers(HttpServer server) {
        server.createContext("/new/monster", new NewMonsterHandler());
        server.createContext("/user/login", new LoginHandler());
        server.createContext("/weapon", new WeaponHandler());
        server.createContext("/item", new ItemHandler());
        server.createContext("/spell", new SpellHandler());
        server.createContext("/metal/edit", new MetalEditHandler());
        server.createContext("/get/characters", new GetCharactersHandler());
        server.createContext("/get/monsters", new GetMonstersHandler());
        server.createContext("/get/goals", new GetAllGoalsHandler());
        server.createContext("/get/tasks", new GetCharacterTasksHandler());
        server.createContext("/get/logs", new GetAllLogsHandler());
        server.createContext("/get/log/monsters", new GetLogMonstersHandler());
        server.createContext("/get/prepared/spells", new GetPreparedSpells());
        server.createContext("/get/checks", new GetChecksHandler());
        server.createContext("/delete/monster", new DeleteMonsterHandler());
        server.createContext("/delete/task", new DeleteTaskHandler());
        server.createContext("/all/monsters", new GetAllMonstersHandler());
        server.createContext("/add/monsters", new AddBattleMonsterHandler());
        server.createContext("/delete/item", new DeleteItemHandler());
        server.createContext("/edit/itemQuantity", new EditItemQuantityHandler());
        server.createContext("/character/experience/edit", new CharacterEditExperienceHandler());
        server.createContext("/all/items", new GetAllItemsHandler());
        server.createContext("/new/item", new NewItemHandler());
        server.createContext("/edit/hp/character", new EditHPCharacter());
        server.createContext("/edit/hp/monster", new EditHPMonster());
        server.createContext("/edit/task", new EditTaskHandler());
        server.createContext("/edit/goal/visibility", new EditGoalVisibilityHandler());
        server.createContext("/add/to/item", new AddItemToCharacterHandler());
        server.createContext("/add/task", new AddTaskHandler());
        server.createContext("/add/goal", new AddGoalHandler());

    }
}
