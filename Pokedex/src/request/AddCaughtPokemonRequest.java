package request;

public class AddCaughtPokemonRequest {
    private int speciesID;
    private String pokemonSex;
    private String pokemonNickname;
    private int pokemonLevel;
    private int moveID1;
    private int moveID2;
    private int moveID3;
    private int moveID4;

    public AddCaughtPokemonRequest(int speciesID, String pokemonSex, String pokemonNickname,
                                   int pokemonLevel, int moveID1, int moveID2, int moveID3, int moveID4) {
        this.speciesID = speciesID;
        this.pokemonSex = pokemonSex;
        this.pokemonNickname = pokemonNickname;
        this.pokemonLevel = pokemonLevel;
        this.moveID1 = moveID1;
        this.moveID2 = moveID2;
        this.moveID3 = moveID3;
        this.moveID4 = moveID4;
    }

    public int getSpeciesID() { return speciesID; }
    public String getPokemonSex() { return pokemonSex; }
    public String getPokemonNickname() { return pokemonNickname; }
    public int getPokemonLevel() { return pokemonLevel; }
    public int getMoveID1() { return moveID1; }
    public int getMoveID2() { return moveID2; }
    public int getMoveID3() { return moveID3; }
    public int getMoveID4() { return moveID4; }

    public void setSpeciesID(int speciesID) { this.speciesID = speciesID; }
    public void setPokemonSex(String pokemonSex) { this.pokemonSex = pokemonSex; }
    public void setPokemonNickname(String pokemonNickname) { this.pokemonNickname = pokemonNickname; }
    public void setPokemonLevel(int pokemonLevel) { this.pokemonLevel = pokemonLevel; }
    public void setMoveID1(int moveID1) { this.moveID1 = moveID1; }
    public void setMoveID2(int moveID2) { this.moveID2 = moveID2; }
    public void setMoveID3(int moveID3) { this.moveID3 = moveID3; }
    public void setMoveID4(int moveID4) { this.moveID4 = moveID4; }
}
