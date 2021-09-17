package fuckmuhannad;

import java.io.Serializable;
import java.util.*;

public class NormalGame extends Game implements Serializable {
    public NormalGame() {
        players = new ArrayList<Player>();
        indexOfCurrnetPlayer = 0;
        moves = new ArrayList<Moves>();
        gameGrid = new Grid(0, 0, 0);
        numberOfRevealedSquares = 0;
        gameState = GameState.Running;
    }

    public NormalGame(int n, int m, int k) {
        players = new ArrayList<Player>();
        indexOfCurrnetPlayer = 0;
        moves = new ArrayList<Moves>();
        gameGrid = new Grid(n, m, k);
        rules = new GameRules(1, 1, 1, 1, 1, 1, 1, 100);
        numberOfRevealedSquares = 0;
        gameState = GameState.Running;
    }
    
    public NormalGame(ArrayList<Player> pl, int n, int m, int k) {
        players = pl;
        indexOfCurrnetPlayer = 0;
        moves = new ArrayList<Moves>();
        gameGrid = new Grid(n, m, k);
        rules = new GameRules(5, 1, 1, 5, 10, 1, 250, 100);
        numberOfRevealedSquares = 0;
        gameState = GameState.Running;
    }

    public NormalGame(ArrayList<Player> players, ArrayList<Moves> moves, Grid gameGrid, GameRules rules) {super(players, moves, gameGrid, rules);}

    public int getNumberOfRevealedSquares() {return numberOfRevealedSquares;}
    public void setNumberOfRevealedSquares(int numberOfRevealedSquares) {this.numberOfRevealedSquares = numberOfRevealedSquares;}
    public GameRules getRules() {return rules;}
    public void setRules(GameRules rules) {this.rules = rules;}
    public GameState getGameState() {return gameState;}
    public void setGameState(GameState gameState) {this.gameState = gameState;}    
    public ArrayList<Player> getPlayers() {return players;}
    public void setPlayers(ArrayList<Player> players) {this.players = players;}
    public int getIndexOfCurrnetPlayer() {return indexOfCurrnetPlayer;}
    public void setIndexOfCurrnetPlayer(int indexOfCurrnetPlayer) {this.indexOfCurrnetPlayer = indexOfCurrnetPlayer;}
    public ArrayList<Moves> getMoves() {return moves;}
    public void setMoves(ArrayList<Moves> moves) {this.moves = moves;}
    public Grid getGameGrid() {return super.gameGrid;}
    public void setGameGrid(Grid gameGrid) {this.gameGrid = gameGrid;}

    public class DefaultRules extends GameRules {
        public DefaultRules(int markCorrect, int markWrong, int unMarkCorrect, int uNMarkWrong, int revealEmpty, int revealFlood, int revealMine, int finishMine) {
            super(markCorrect, markWrong, unMarkCorrect, uNMarkWrong, revealEmpty, revealFlood, revealMine, finishMine);
        }
        
       
    }
}
