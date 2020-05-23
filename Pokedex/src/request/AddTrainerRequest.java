package request;

public class AddTrainerRequest {
    private String TrainerName;
    private String TrainerHometown;
    private String TrainerSex;

    public AddTrainerRequest(String trainerName, String trainerHometown, String trainerSex) {
        TrainerName = trainerName;
        TrainerHometown = trainerHometown;
        TrainerSex = trainerSex;
    }

    public String getTrainerName() { return TrainerName; }
    public String getTrainerHometown() { return TrainerHometown; }
    public String getTrainerSex() { return TrainerSex; }

    public void setTrainerHometown(String trainerHometown) { TrainerHometown = trainerHometown; }
    public void setTrainerSex(String trainerSex) { TrainerSex = trainerSex; }
    public void setTrainerName(String trainerName) { TrainerName = trainerName; }
}
