package model;

import java.util.List;

public class CaughtPokemon {
    private int id;
    private int trainerId;
    private int speciesId;
    private String sex;
    private int level;
    private String nickname;
    private int move1;
    private int move2;
    private int move3;
    private int move4;

    public CaughtPokemon(int id, int trainerId, int speciesId, String sex, int level, String nickname, int move1, int move2, int move3, int move4) {
        this.id = id;
        this.trainerId = trainerId;
        this.speciesId = speciesId;
        this.sex = sex;
        this.level = level;
        this.nickname = nickname;
        this.move1 = move1;
        this.move2 = move2;
        this.move3 = move3;
        this.move4 = move4;
    }

    public int getId() { return id; }
    public int getTrainerId() { return trainerId; }
    public int getSpeciesId() { return speciesId; }
    public String getSex() { return sex; }
    public int getLevel() { return level; }
    public String getNickname() { return nickname; }
    public int getMove1() { return move1; }
    public int getMove2() { return move2; }
    public int getMove3() { return move3; }
    public int getMove4() { return move4; }

    public void setId(int id) { this.id = id; }
    public void setTrainerId(int trainerId) { this.trainerId = trainerId; }
    public void setSpeciesId(int speciesId) { this.speciesId = speciesId; }
    public void setSex(String sex) { this.sex = sex; }
    public void setLevel(int level) { this.level = level; }
    public void setNickname(String nickname) { this.nickname = nickname; }

    public void setMove1(int move1) { this.move1 = move1; }
    public void setMove2(int move2) { this.move2 = move2; }
    public void setMove3(int move3) { this.move3 = move3; }
    public void setMove4(int move4) { this.move4 = move4; }
}
