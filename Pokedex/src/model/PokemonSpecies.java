package model;

import javafx.util.Pair;

import java.util.List;

public class PokemonSpecies {
    private int id;
    private String name;
    private String speciesName;
    private String imgUrl;
    private String type1;
    private String type2;
    private String height;
    private String weight;
    private String text;
    private int hp;
    private int attack;
    private int defense;
    private int special;
    private int speed;
    private List<Pair<String,Move>> moves;

    public PokemonSpecies(int id,
                          String name, String speciesName, String imgUrl, String type1, String type2, String height, String weight, String text,
                          int hp, int attack, int defense, int special, int speed, List<Pair<String, Move>> moves) {
        this.id = id;
        this.name = name;
        this.speciesName = speciesName;
        this.imgUrl = imgUrl;
        this.type1 = type1;
        this.type2 = type2;
        this.height = height;
        this.weight = weight;
        this.text = text;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.special = special;
        this.speed = speed;
        this.moves = moves;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getSpeciesName() { return speciesName; }
    public String getImgUrl() { return imgUrl; }
    public String getType1() { return type1; }
    public String getType2() { return type2; }
    public String getHeight() { return height; }
    public String getWeight() { return weight; }
    public String getText() { return text; }
    public int getHp() { return hp; }
    public int getAttack() { return attack; }
    public int getDefense() { return defense; }
    public int getSpecial() { return special; }
    public int getSpeed() { return speed; }
    public List<Pair<String, Move>> getMoves() { return moves; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setSpeciesName(String speciesName) { this.speciesName = speciesName; }
    public void setImgUrl(String imgUrl) { this.imgUrl = imgUrl; }
    public void setType1(String type1) { this.type1 = type1; }
    public void setType2(String type2) { this.type2 = type2; }
    public void setHeight(String height) { this.height = height; }
    public void setWeight(String weight) { this.weight = weight; }
    public void setText(String text) { this.text = text; }
    public void setHp(int hp) { this.hp = hp; }
    public void setAttack(int attack) { this.attack = attack; }
    public void setDefense(int defense) { this.defense = defense; }
    public void setSpecial(int special) { this.special = special; }
    public void setSpeed(int speed) { this.speed = speed; }
    public void setMoves(List<Pair<String, Move>> moves) { this.moves = moves; }
}
