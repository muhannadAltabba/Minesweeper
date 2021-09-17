package fuckmuhannad;

import java.io.Serializable;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FlyingShield extends Shield implements Serializable {
    public static boolean stopMoving = false;
    
    FlyingShield(Square sq) {square = sq;}
    
    public void Move(Game.Grid grid) {
        new Thread(new Runnable() {
            @Override
            public synchronized void run() {
                while(true) {
                    if(FlyingShield.stopMoving)
                        return;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {}
                    
                    int r = square.getR();
                    int c = square.getC();
                    
                    ArrayList<Square> list = new ArrayList<>();
                    for(int i = 0; i < 8; i++) {
                        int nr = r + Game.ar[i];
                        int nc = c + Game.ac[i];

                        if(grid.ok(nr, nc)) {
                            Square sq = grid.getSquare(nr, nc);
                            if(sq.getState() == SquareStatus.MarkedEmpty || sq.getState() == SquareStatus.ClosedEmpty)
                                if(!sq.isHasFlyingShield())
                                    list.add(sq);
                        }
                    }
                    
                    if(square.getState() == SquareStatus.OpenedEmpty)
                        return;
                    
                    if(!list.isEmpty()) {
                        Random rand = new Random();
                        int idx = rand.nextInt(list.size());
                        square.setHasFlyingShield(false);
                        square = list.get(idx);
                        square.setHasFlyingShield(true);
                    }
                    
                    System.out.println(square.getR() + " " + square.getC());
                }
            }
        }).start();        
    }
}
