package request;

public class GetSpeciesMovesRequest {
    private int speciesID;

    public GetSpeciesMovesRequest(int speciesID) { this.speciesID = speciesID; }

    public int getSpeciesID() { return speciesID; }

    public void setSpeciesID(int speciesID) { this.speciesID = speciesID; }
}
