package request;

public class GetCaughtSpeciesRequest {
    private int trainerID;

    public GetCaughtSpeciesRequest(int trainerID) { this.trainerID = trainerID; }

    public int getTrainerID() { return trainerID; }

    public void setTrainerID(int trainerID) { this.trainerID = trainerID; }
}
