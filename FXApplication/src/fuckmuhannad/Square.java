package fuckmuhannad;

import java.io.Serializable;
import java.util.*;

enum Color {
    Red, Green, Blue, Black, White, Grey, Pink, Cyan, Purple, Yellow;
}

public class Square implements Serializable {
    private int r, c;
    private char value;
    private SquareStatus state;
    private Color col;
    private boolean hasNormalShield = false;
    private boolean hasFlyingShield = false;
    
    public Square(int a, int b) {
        r = a; c = b;
        value = '0';
        state = SquareStatus.ClosedEmpty;
        col = Color.Red;
    }

    public char getValue() {return value;}
    public void setValue(char value) {this.value = value;}
    public int getR() {return r;}
    public void setR(int r) {this.r = r;}
    public int getC() {return c;}
    public void setC(int c) {this.c = c;}
    public SquareStatus getState() {return state;}
    public void setState(SquareStatus state) {this.state = state;}
    public Color getCol() {return col;}
    public void setCol(Color col) {this.col = col;}
    public void setSquare(SquareStatus st) {state = st;}
    public boolean isHasNormalShield() {return hasNormalShield;}
    public void setHasNormalShield(boolean hasNormalShield) {this.hasNormalShield = hasNormalShield;}
    public boolean isHasFlyingShield() {return hasFlyingShield;}
    public void setHasFlyingShield(boolean hasFlyingShield) {this.hasFlyingShield = hasFlyingShield;}

    public void show() {
        if(state == SquareStatus.ClosedEmpty)
            System.out.print('Q');
        else if(state == SquareStatus.ClosedMine)
            System.out.print('Q');
        else if(state == SquareStatus.OpenedMine)
            System.out.print('*');
        else if(state == SquareStatus.MarkedMine || state == SquareStatus.MarkedEmpty)
            System.out.print('!');
        else
            System.out.print(value);
//        else if(state == SquareStatus.OpenedEmpty)
//            value = 'E';
        
        System.out.print("  ");
    }
}
