package fuckmuhannad;

import java.io.Serializable;

public class MoveResult implements Serializable {
    int scoreChange;
    SquareStatus state;
    
    public MoveResult() {
        state = SquareStatus.ClosedEmpty;
        scoreChange = 0;
    }

    MoveResult(int score, SquareStatus newState) {
        state = newState;
        scoreChange = score;
    }
    
//    public MoveResult(boolean b) {
//        state = new SquareStatus(b);
//        scoreChange = 0;
//    }

    public SquareStatus getState() {return state;}
    public int getScoreChange() {return scoreChange;}
    public void setState(SquareStatus state) {this.state = state;}
    public void setScoreChange(int scoreChange) {this.scoreChange = scoreChange;}
}
