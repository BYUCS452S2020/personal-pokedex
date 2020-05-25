package request;

import model.Trainer;

public class AddTrainerRequest {
    Trainer trainer;

    public AddTrainerRequest(Trainer trainer) { this.trainer = trainer; }

    public Trainer getTrainer() { return trainer; }

    public void setTrainer(Trainer trainer) { this.trainer = trainer; }
}
