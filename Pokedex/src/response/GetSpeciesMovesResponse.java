package response;

import model.Move;

public class GetSpeciesMovesResponse {
    Move moves[];
    String requirements[];

    public GetSpeciesMovesResponse(Move[] moves, String[] requirements) {
        this.moves = moves;
        this.requirements = requirements;
    }

    public Move[] getMoves() { return moves; }
    public String[] getRequirements() { return requirements; }

    public void setMoves(Move[] moves) { this.moves = moves; }
    public void setRequirements(String[] requirements) { this.requirements = requirements; }


}
