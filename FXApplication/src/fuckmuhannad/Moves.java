package fuckmuhannad;

import java.io.Serializable;

public class Moves implements Serializable {
    Player player;
    MoveType type;
    Square square;
    MoveResult result;

    public Moves() {
        type = MoveType.Mark;
        result = new MoveResult();
        square = new Square(0, 0);
        player = new GUIPlayer();
    }
    
    public Moves(MoveType tp) {
        type = tp;
        result = new MoveResult();
        square = new Square(0, 0);
        player = new GUIPlayer();
    }
    
    public Moves(Player p, Square sq, MoveType mt) {player = p; square = sq; type = mt;}    
    
    public Square getSquare() {return square;}
    public MoveResult getResult() {return result;}
    public MoveType getType() {return type;}
    public Player getPlayer() {return player;}
    public void setPlayer(Player player) {this.player = player;}
    public void setType(MoveType type) {this.type = type;}
    public void setSquare(Square square) {this.square = square;}
    public void setResult(MoveResult result) {this.result = result;}
    
    public boolean isAcceptable() throws IllegalMoveException {
        SquareStatus st = square.getState();
        
//        System.out.println(st + " " + type);
        
        if(type == MoveType.Reveal) {
            if(st != SquareStatus.ClosedEmpty && st != SquareStatus.ClosedMine)
                throw new IllegalMoveException("Can't Open Opened Square");
        }
        if(type == MoveType.Mark) {
            if(st != SquareStatus.ClosedEmpty && st != SquareStatus.ClosedMine)
                throw new IllegalMoveException("Can't Mark Closed Square");
        }
        if(type == MoveType.UnMark) {
            if(st != SquareStatus.MarkedEmpty && st != SquareStatus.MarkedMine)
                throw new IllegalMoveException("Can't UnMark Closed Square");
        }
        
        return true;
    }
    
    public void printMove() {
        System.out.println("Move Type: " + type);
        System.out.println("Square(" + square.getR() + "," + square.getC() + ")");
    }
}
