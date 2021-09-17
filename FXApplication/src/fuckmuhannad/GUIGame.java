package fuckmuhannad;

import java.io.Serializable;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class GUIGame extends Game implements Serializable {
    public GUIGame(ArrayList<Player> pl, int n, int m, int k) {
        players = pl;
        indexOfCurrnetPlayer = 0;
        moves = new ArrayList<Moves>();
        gameGrid = new Grid(n, m, k);
        rules = new GameRules(5, 1, 1, 5, 10, 1, 250, 100);
        numberOfRevealedSquares = 0;
        gameState = GameState.Running;
    }
    
    public GUIGame() {
        players = new ArrayList<>();
        indexOfCurrnetPlayer = 0;
        moves = new ArrayList<>();
        gameGrid = new Grid(10, 10, 10);
        rules = new GameRules(5, 1, 1, 5, 10, 1, 250, 100);
        numberOfRevealedSquares = 0;
        gameState = GameState.Running;
    }
}
