package fuckmuhannad;

import java.io.Serializable;
import java.util.*;

enum PlayerStatus {
    Win, Lose, Play; 
}

public abstract class Player implements Serializable {
    protected PlayerStatus state;
    protected Color col;
    protected Score score;
    protected String name;
    protected int numberOfCurrentSheilds = 0;
    
    public Player() {
        state = PlayerStatus.Play;
        col = Color.Red;
        score = new Score();
        name = "Zaher";
    }
    public Player(PlayerStatus state, Color col, Score score) {
        this.state = state;
        this.col = col;
        this.score = score;
        name = "Zaher";
    }

    public Player(PlayerStatus state, Color col, Score score, String name) {
        this.state = state;
        this.col = col;
        this.score = score;
        this.name = name;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public int getNumberOfCurrentSheilds() {return numberOfCurrentSheilds;}
    public void setNumberOfCurrentSheilds(int numberOfCurrentSheilds) {this.numberOfCurrentSheilds = numberOfCurrentSheilds;}
    public PlayerStatus getState() {return state;}
    public Color getCol() {return col;}
    public void setCol(Color col) {this.col = col;}
    public void setState(PlayerStatus state) {this.state = state;}
    public Score getScore() {return score;}
    public void setScore(Score score) {this.score = score;}
    
    public void editNumberOfShields(int x) {numberOfCurrentSheilds += x;}
    public void addScore(ArrayList<Moves> list) {
        for(Moves move : list) {
            Square sq = move.getSquare();
            
            if(!(this instanceof EasyAIPlayer)) {
                if(sq.isHasNormalShield())
                    numberOfCurrentSheilds++;
                if(sq.isHasFlyingShield()) {
                    numberOfCurrentSheilds += 2;
                    
                    if(move.getType() == MoveType.Flood)
                        numberOfCurrentSheilds--;
                }
            }
        }
        score.addScore(list);
    }
    public abstract Moves getNextMove(Game.Grid grid);
}
