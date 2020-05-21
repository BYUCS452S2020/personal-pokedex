package model;

import java.util.List;

public class PokemonSpecies {
    int id;
    String name;
    String speciesName;
    String imgUrl;
    String type1;
    String type2;
    String height;
    String weight;
    String text;
    int hp;
    int attack;
    int defense;
    int special;
    int speed;

    List<Move> moves;
    List<String> requirements;
}
