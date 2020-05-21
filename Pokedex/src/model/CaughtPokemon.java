package model;

import java.util.List;

public class CaughtPokemon {
    private int id;
    private int trainerId;
    private int speciesId;
    private String sex;
    private int level;
    private String nickname;
    private List<Move> moves;

    public CaughtPokemon(int id, int trainerId, int speciesId, String sex, int level, String nickname, List<Move> moves) {
        this.id = id;
        this.trainerId = trainerId;
        this.speciesId = speciesId;
        this.sex = sex;
        this.level = level;
        this.nickname = nickname;
        this.moves = moves;
    }

    public int getId() {
        return id;
    }

    public int getTrainerId() {
        return trainerId;
    }

    public int getSpeciesId() {
        return speciesId;
    }

    public String getSex() {
        return sex;
    }

    public int getLevel() {
        return level;
    }

    public String getNickname() {
        return nickname;
    }

    public List<Move> getMoves() {
        return moves;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    public void setSpeciesId(int speciesId) {
        this.speciesId = speciesId;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }
}
