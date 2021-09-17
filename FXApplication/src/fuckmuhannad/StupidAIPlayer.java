package fuckmuhannad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class StupidAIPlayer extends AutoPlayer implements Serializable {
    @Override
    public Moves getNextMove(Game.Grid grid) {
        int n = grid.getN();
        int m = grid.getM();
        
        ArrayList<Square> list = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                Square sq = grid.getSquare(i, j);
                
                if(sq.getState() == SquareStatus.ClosedEmpty || sq.getState() == SquareStatus.ClosedMine)
                    list.add(sq);
            }
        }
        
        if(list.isEmpty()) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= m; j++) {
                    Square sq = grid.getSquare(i, j);
                
                    if(sq.getState() == SquareStatus.MarkedEmpty || sq.getState() == SquareStatus.MarkedMine)
                        list.add(sq);
                }
            }
            
            Random rand = new Random();
            int x = ((rand.nextInt() % list.size()) + list.size()) % list.size();            
            
            return new Moves(this, list.get(x), MoveType.UnMark);
        }
        
        Random rand = new Random();
        int x = ((rand.nextInt() % list.size()) + list.size()) % list.size();
        
        return new Moves(this, new Square(list.get(x).getR(), list.get(x).getC()), MoveType.Reveal);
    }
}
