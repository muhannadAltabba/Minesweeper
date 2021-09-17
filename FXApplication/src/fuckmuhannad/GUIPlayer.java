package fuckmuhannad;

import java.io.Serializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class GUIPlayer extends Player implements Serializable {
    public static int r;
    public static int c;
    public static MoveType type;
    
    public class nc {
        int r, c;

        public int getR() {
            return r;
        }

        public void setR(int r) {
            this.r = r;
        }

        public int getC() {
            return c;
        }

        public void setC(int c) {
            this.c = c;
        }        
    }
    
    @Override
    public Moves getNextMove(Game.Grid grid) {
        return new Moves(this, new Square(r + 1, c + 1), type);
    }
}
