package fuckmuhannad;

import java.util.*;

public class Project {
    public static void main(String[] args) {
        ArrayList<Player> pls = new ArrayList<Player>();
//        pls.add(new ConsolePlayer());
//        pls.add(new EasyAIPlayer());
        

        Scanner sc = new Scanner(System.in);
        int n, m, k;
        
        while(true) {
            try {
                System.out.println("Enter Grid Width: ");
                int x = Integer.parseInt(sc.next());

                if(x < 3 || x > 20)
                    throw new Exception();

                n = x;
                break;
            } catch(Exception e) {}
        }
        
        while(true) {
            try {
                System.out.println("Enter Grid Height: ");
                int x = Integer.parseInt(sc.next());

                if(x < 3 || x > 20)
                    throw new Exception();

                m = x;
                break;
            } catch(Exception e) {}
        }
        
        while(true) {
            try {
                System.out.println("Enter Number of Mines: ");
                int x = Integer.parseInt(sc.next());

                if(x < 2 || x > n * m / 3)
                    throw new Exception();

                k = x;
                break;
            } catch(Exception e) {}
        }
        
        int consoleNum, easyNum, mediumNum;
        
        while(true) {
            try {
                System.out.println("Enter Number of Console Players: ");
                int x = Integer.parseInt(sc.next());

                if(x < 1 || x > 4)
                    throw new Exception();

                consoleNum = x;
                break;
            } catch(Exception e) {}
        }

        while(true) {
            try {
                System.out.println("Enter Number of Easy Players: ");
                int x = Integer.parseInt(sc.next());

                if(x < 0 || x > 5)
                    throw new Exception();

                easyNum = x;
                break;
            } catch(Exception e) {}
        }

        while(true) {
            try {
                System.out.println("Enter Number of Medium Players: ");
                int x = Integer.parseInt(sc.next());

                if(x < 0 || x > 5)
                    throw new Exception();

                mediumNum = x;
                break;
            } catch(Exception e) {}
        }
        
        int ns, fs;
        
        while(true) {
            try {
                System.out.println("Enter Number of Normal Shields: ");
                int x = Integer.parseInt(sc.next());

                if(x < 0 || x > n * m - k - 1)
                    throw new Exception();

                ns = x;
                break;
            } catch(Exception e) {}
        }

        while(true) {
            try {
                System.out.println("Enter Number of Flying Shields: ");
                int x = Integer.parseInt(sc.next());

                if(x < 0 || x > n * m - k - ns - 1)
                    throw new Exception();

                fs = x;
                break;
            } catch(Exception e) {}
        }

        for(int i = 0; i < consoleNum; i++)
            pls.add(new ConsolePlayer());
        for(int i = 0; i < easyNum; i++)
            pls.add(new EasyAIPlayer());
        for(int i = 0; i < mediumNum; i++)
            pls.add(new MediumAIPlayer());
        
        Game g = new NormalGame(pls, n, m, k);
        g.initGame(n, m, k, ns, fs);
        
        while(g.getGameState() == GameState.Running) {
            g.showGrid();
            System.out.println(g.getPlayers().get(g.getIndexOfCurrnetPlayer()).getNumberOfCurrentSheilds());
            g.ApplyMove(g.getPlayers().get(g.getIndexOfCurrnetPlayer()).getNextMove(g.gameGrid));
            System.out.println("");
            g.getMoves().clear();
//            System.out.println(g.getPlayers().get(g.getIndexOfCurrnetPlayer()).getScore());
        }
        
        g.showGrid();
        
        System.out.print("\n\nScores are Here : ");
        for(Player x : g.getPlayers())
            System.out.print(x.getScore().getResult() + " ");
        System.out.println();
    }
}
