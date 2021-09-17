
package fuckmuhannad;

import java.io.Serializable;
import java.util.ArrayList;


public class Score implements Serializable {
    private int result;

    public Score() {result = 0;}
    public Score(int result) {this.result = result;}
    
    public int getResult() {return result;}
    public void setResult(int result) {this.result = result;}
    
    public void addScore(ArrayList<Moves> list) {
        for(Moves move : list) 
            result += move.getResult().getScoreChange();
        for(Moves move : list) {
            if(move.getSquare().isHasFlyingShield() && move.getType() == MoveType.Flood)
                result += 1000;
        }
    }
}
