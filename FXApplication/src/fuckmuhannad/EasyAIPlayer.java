package fuckmuhannad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EasyAIPlayer extends AutoPlayer implements Serializable {

    public boolean fullMine(Game.Grid grid, Square sq) {
        int r = sq.getR();
        int c = sq.getC();
        
        int cnt = 0;
        for(int i = 0; i < 8; i++) {
            int nr = r + Game.ar[i];
            int nc = c + Game.ac[i];
        
            if(!grid.ok(nr, nc))
                continue;
            
            Square nsq = grid.getSquare(nr, nc);
            
            if(nsq.getState() == SquareStatus.MarkedMine || nsq.getState() == SquareStatus.MarkedEmpty || nsq.getState() == SquareStatus.OpenedMine)
                cnt++;
        }
        
        if(cnt == (int)(sq.getValue() - '0'))
            return true;
        return false;
    }
    
    public boolean canRevealed(Game.Grid grid, Square sq) {
        int r = sq.getR();
        int c = sq.getC();
        
        for(int i = 0; i < 8; i++) {
            int nr = r + Game.ar[i];
            int nc = c + Game.ac[i];
            
            if(!grid.ok(nr, nc))
                continue;
            
            Square nsq = grid.getSquare(nr, nc);
            
            if(nsq.getState() != SquareStatus.OpenedEmpty)
                continue;
            
            if(fullMine(grid, nsq))
                return true;
        }
        
        return false;
    }
    
    public boolean fullEmpty(Game.Grid grid, Square sq) {        
        int r = sq.getR();
        int c = sq.getC();
        
        int cnt = 0;
        for(int i = 0; i < 8; i++) {
            int nr = r + Game.ar[i];
            int nc = c + Game.ac[i];

            if(!grid.ok(nr, nc)) {
                cnt++;
                continue;
            }
            
            Square nsq = grid.getSquare(nr, nc);
            
            if(nsq.getState() == SquareStatus.OpenedEmpty)
                cnt++;
        }
        
        int val = sq.getValue() - '0';

        return (val + cnt) == 8;
    }
    
    public boolean canMarked(Game.Grid grid, Square sq) {
        int r = sq.getR();
        int c = sq.getC();
                
        for(int i = 0; i < 8; i++) {
            int nr = r + Game.ar[i];
            int nc = c + Game.ac[i];
            
            if(!grid.ok(nr, nc))
                continue;
            
            Square nsq = grid.getSquare(nr, nc);
            
            if(nsq.getState() != SquareStatus.OpenedEmpty)
                continue;
        
            if(fullEmpty(grid, nsq))
                return true;
        }
        
        return false;
    }
    
    @Override
    public Moves getNextMove(Game.Grid grid) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(3000);
//                    Thread.currentThread().notifyAll();
//                } catch (InterruptedException ex) {}
//            }
//        });
                        
//        try {
//            Thread.currentThread().join(5000);
//        } catch (InterruptedException ex) {
//            System.out.println("Interrupted");
//          Logger.getLogger(FXApplication.class.getName()).log(Level.SEVERE, null, ex);
//        }


//        try {Thread.sleep(2000);} 
//        catch (InterruptedException ex) {System.out.println("sdsdds");}
        
//        if(true)
//            System.exit(0);
        
        int n = grid.getN();
        int m = grid.getM();
        
        ArrayList<Square> list = new ArrayList<>();

        Random rand = new Random();
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                Square sq = grid.getSquare(i, j);
                
                if(sq.getState() != SquareStatus.ClosedEmpty && sq.getState() != SquareStatus.ClosedMine)
                    continue;
                if(canRevealed(grid, sq))
                    list.add(sq);
            }
        }
        
        if(list.isEmpty()) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= m; j++) {
                    Square sq = grid.getSquare(i, j);
                    
                    if(sq.getState() == SquareStatus.ClosedEmpty || sq.getState() == SquareStatus.ClosedMine) {
                        if(canMarked(grid, sq))
                            list.add(sq);
                    }
                }
            }
            
            if(list.isEmpty()) {
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
                    
                    int x = rand.nextInt(list.size());
                    return new Moves(this, list.get(x), MoveType.UnMark);
                }
                
                int x = rand.nextInt(list.size());
                return new Moves(this, list.get(x), MoveType.Reveal);
            }
            
            int x = rand.nextInt(list.size());
            return new Moves(this, list.get(x), MoveType.Mark);
        }
        
        int x = rand.nextInt(list.size());
        return new Moves(this, list.get(x), MoveType.Reveal);
    }
}
