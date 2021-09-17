package fuckmuhannad;

import java.io.Serializable;
import java.util.*;

public class ConsolePlayer extends Player implements Serializable {
    @Override
    public Moves getNextMove(Game.Grid grid) {
        Scanner sc = new Scanner(System.in);
        
        int r, c;
        
        while(true) {
            try {
                System.out.println("Enter Number of Row: ");
                r = Integer.parseInt(sc.next());
            } catch(Exception ex) {
                continue;
            }
            
            try {
                if(r > grid.getN())
                    throw new IllegalSqaureNameException();
                break;
            } catch(IllegalSqaureNameException ex) {}
        }
        while(true) {
            try {
                System.out.println("Enter Number of Column: ");
                c = Integer.parseInt(sc.next());
            } catch(Exception ex) {
                continue;
            }
            
            try {
                if(c > grid.getM())
                    throw new IllegalSqaureNameException();
                break;
            } catch(IllegalSqaureNameException ex) {}
        }

        String s = "Reveal";
        while(true) {
            try {
                System.out.println("Enter Move Type: ");
                System.out.println("1- Reveal, 2- Mark, 3- UnMark");
                
                int x = Integer.parseInt(sc.next());
                if(x < 1 || x > 3)
                    throw new Exception();
                
                if(x == 2)
                    s = "Mark";
                if(x == 3)
                    s = "UnMark";
                
                break;
            } catch(Exception ex) {}
        }
        
        MoveType type = MoveType.Reveal;
        
        if(s.equals("Mark"))
            type = MoveType.Mark;
        if(s.equals("UnMark"))
            type = MoveType.UnMark;
    
        System.out.println(type);
        return new Moves(this, new Square(r, c), type);
    }
}















