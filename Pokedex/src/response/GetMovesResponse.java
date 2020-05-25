package response;

import model.Move;

public class GetMovesResponse {
    Move move1;
    Move move2;
    Move move3;
    Move move4;

    public GetMovesResponse(Move move1, Move move2, Move move3, Move move4) {
        this.move1 = move1;
        this.move2 = move2;
        this.move3 = move3;
        this.move4 = move4;
    }

    public void setMove1(Move move1) { this.move1 = move1; }
    public void setMove2(Move move2) { this.move2 = move2; }
    public void setMove3(Move move3) { this.move3 = move3; }
    public void setMove4(Move move4) { this.move4 = move4; }

    public Move getMove1() { return move1; }
    public Move getMove2() { return move2; }
    public Move getMove3() { return move3; }
    public Move getMove4() { return move4; }

}
