package fuckmuhannad;

import java.io.Serializable;
import java.util.*;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public abstract class Game implements Serializable {
    protected ArrayList<Player> players;
    protected int indexOfCurrnetPlayer;
    protected ArrayList<Moves> moves;
    protected Grid gameGrid;
    protected GameRules rules;
    protected GameState gameState;
    protected int numberOfRevealedSquares;
    protected ArrayList<FlyingShield> flyingShields = new ArrayList<>();
    
    public static boolean moveCurrentPlayer = false;

    public static int ar[] = {1, -1, 0, 0, 1, 1, -1, -1};
    public static int ac[] = {0, 0, 1, -1, 1, -1, 1, -1};
    
    public class Grid implements Serializable {
        protected int n, m, k;
        protected int numberOfNormalShields;
        protected int numberOfFlyingShields;
        protected Square[][] square;
        protected boolean vis[][];

        public Grid(int a, int b, int c) {
            n = a;
            m = b;
            k = c;
            numberOfNormalShields = 1;
            numberOfFlyingShields = 1;
            square = new Square[n + 2][m + 2];
            vis = new boolean[n + 2][m + 2];
            
            for(int i = 0; i <= n; i++)
                for(int j = 0; j <= m; j++)
                    square[i][j] = new Square(i, j);
        }

        public int getN() {return n;}
        public void setN(int n) {this.n = n;}
        public int getM() {return m;}
        public void setM(int m) {this.m = m;}
        public Square[][] getSquare() {return square;}
        public void setSquare(Square[][] square) {this.square = square;}
        public void setSquareStatus(int r, int c, SquareStatus st) {square[r][c].setSquare(st);}
        public Square getSquare(int r, int c) {return square[r][c];}
        public int getK() {return k;}
        public void setK(int k) {this.k = k;}
        public void setSquare(int r, int c, Square sq) {square[r][c] = sq;}

        public boolean ok(int r, int c) {return (r > 0 && c > 0 && r <= n && c <= m);}
        
        public void floodFill(int r, int c) {
            if(vis[r][c])
                return;
            vis[r][c] = true;
            
            numberOfRevealedSquares--;
                        
            for(int i = 0; i < 8; i++) {
                if(square[r][c].getValue() != '0')
                    break;
                
                int nr = r + ar[i];
                int nc = c + ac[i];
                
                if(ok(nr, nc)) {
                    if(square[nr][nc].getState() == SquareStatus.ClosedEmpty)
                        floodFill(nr, nc);
                }
            }
            
            Player p = players.get(indexOfCurrnetPlayer);
            Square sq = square[r][c];
            
            Moves move = new Moves(p, sq, MoveType.Flood);
            moves.add(move);
        }
    }
    
    public class GameRules implements Serializable {
        protected int markCorrect;
        protected int markWrong;
        protected int unMarkCorrect;
        protected int uNMarkWrong;
        protected int revealEmpty;
        protected int revealFlood;
        protected int revealMine;
        protected int finishMine;

        public GameRules(int markCorrect, int markWrong, int unMarkCorrect, int uNMarkWrong, int revealEmpty, int revealFlood, int revealMine, int finishMine) {
            this.markCorrect = markCorrect;
            this.markWrong = markWrong;
            this.unMarkCorrect = unMarkCorrect;
            this.uNMarkWrong = uNMarkWrong;
            this.revealEmpty = revealEmpty;
            this.revealFlood = revealFlood;
            this.revealMine = revealMine;
            this.finishMine = finishMine;
        }

        public int getMarkScore() {return markCorrect;}
        public void setMarkScore(int markScore) {this.markCorrect = markScore;}
        public int getUnMarkScore() {return markWrong;}
        public void setUnMarkScore(int unMarkScore) {this.markWrong = unMarkScore;}
        public int getRevealEmpty() {return revealEmpty;}

        public int getuNMarkWrong() {return uNMarkWrong;}
        public void setuNMarkWrong(int uNMarkWrong) {this.uNMarkWrong = uNMarkWrong;}
        public int getFinishMine() {return finishMine;}
        public void setFinishMine(int finishMine) {this.finishMine = finishMine;}
        public void setRevealEmpty(int revealEmpty) {this.revealEmpty = revealEmpty;}
        public int getRevealFlood() {return revealFlood;}
        public int getMarkCorrect() {return markCorrect;}
        public void setMarkCorrect(int markCorrect) {this.markCorrect = markCorrect;}
        public int getMarkWrong() {return markWrong;}
        public void setMarkWrong(int markWrong) {this.markWrong = markWrong;}
        public int getUnMarkCorrect() {return unMarkCorrect;}
        public void setUnMarkCorrect(int UnMarkCorrect) {this.unMarkCorrect = UnMarkCorrect;}
        public int getUNMarkWrong() {return uNMarkWrong;}
        public void setUNMarkWrong(int UNMarkWrong) {this.uNMarkWrong = UNMarkWrong;}
        public int getRevealMine() {return revealMine;}
        public void setRevealMine(int revealMine) {this.revealMine = revealMine;}
        public void setRevealFlood(int revealFlood) {this.revealFlood = revealFlood;}
    }

    public Game() {
        players = new ArrayList<Player>();
        indexOfCurrnetPlayer = 0;
        moves = new ArrayList<Moves>();
        gameGrid = new Grid(0, 0, 0);
        
//        players.add(new GUIPlayer());
        gameState = GameState.Running;
        numberOfRevealedSquares = 0;
    }
    public Game(int n, int m, int k) {
        players = new ArrayList<Player>();
        indexOfCurrnetPlayer = 0;
        moves = new ArrayList<Moves>();
        gameGrid = new Grid(n, m, k);
        gameState = GameState.Running;
        numberOfRevealedSquares = 0;
    }
    public Game(ArrayList<Player> pl, int n, int m, int k) {
        players = pl;
        indexOfCurrnetPlayer = 0;
        moves = new ArrayList<Moves>();
        gameGrid = new Grid(n, m, k);
        gameState = GameState.Running;
        numberOfRevealedSquares = 0;
    }
    public Game(ArrayList<Player> players, ArrayList<Moves> moves, Grid gameGrid, GameRules rules) {
        this.players = players;
        this.moves = moves;
        this.gameGrid = gameGrid;
        this.rules = rules;
        indexOfCurrnetPlayer = 0;
        gameState = GameState.Running;
        numberOfRevealedSquares = 0;
    }
    
    public void ApplyMove(Moves move) {
        Square sq = gameGrid.square[move.getSquare().getR()][move.getSquare().getC()];
        move.setSquare(sq);
        
        try {AcceptMove(move);}
        catch(IllegalMoveException  e) {return;}
        
        moveCurrentPlayer = false;
        
        ArrayList<Moves> arr = new ArrayList<>();
        for(Moves m : moves)
            arr.add(m);
        moves.clear();

        moves.add(move);
        
        if (move.getType() == MoveType.Reveal && move.getSquare().getState() == SquareStatus.ClosedEmpty) {
            gameGrid.floodFill(move.getSquare().getR(), move.getSquare().getC());
            moves.remove(moves.size() - 1);
        }
        
        for (Moves mv : moves) {
            SquareStatus newState = SquareStatus.OpenedEmpty;
            int score = 0;
            
            MoveType type = mv.getType();
            SquareStatus state = mv.getSquare().getState();
            
            if(type == MoveType.Mark) {
                if(state == SquareStatus.ClosedEmpty) {
                    score -= rules.markWrong;
                    newState = SquareStatus.MarkedEmpty;
                }
                if(state == SquareStatus.ClosedMine) {
                    score += rules.markCorrect;
                    newState = SquareStatus.MarkedMine;
                }
            }
            if(type == MoveType.UnMark) {
                if(state == SquareStatus.MarkedEmpty) {
                    score += rules.unMarkCorrect;
                    newState = SquareStatus.ClosedEmpty;
                }
                if(state == SquareStatus.MarkedMine) {
                    score -= rules.uNMarkWrong;
                    newState = SquareStatus.ClosedMine;
                }
            }
            if(type == MoveType.Reveal) {
                if(state == SquareStatus.ClosedEmpty) {
                    if(mv.getSquare().getValue() == '0')
                        score += rules.revealEmpty;
                    score += (int)(mv.getSquare().getValue() - '0');
                    newState = SquareStatus.OpenedEmpty;
                }
                if(state == SquareStatus.ClosedMine) {
                    if(mv.getPlayer().getNumberOfCurrentSheilds() > 0)
                        mv.getPlayer().editNumberOfShields(-1);
                    else
                        score -= rules.revealMine;
                    newState = SquareStatus.OpenedMine;
                }
            }
            if(type == MoveType.Flood) {
                score += rules.revealFlood;
                newState = SquareStatus.OpenedEmpty;
            }
            
            mv.setResult(new MoveResult(score, newState));
        }
        
        for(Moves mv : moves)
            mv.getSquare().setState(mv.getResult().getState());
        
        Player p = players.get(indexOfCurrnetPlayer);

        if(numberOfRevealedSquares == 0)
            gameState = GameState.Over;
        if(gameState == GameState.Over)
            addToScore(p);
        
        p.addScore(moves);

        if(p.getScore().getResult() < 0)
            p.setState(PlayerStatus.Lose);
        
        moveTurn();
        
        ArrayList<Moves> list = new ArrayList<>();
        
        for(Moves m : moves)
            list.add(m);
        
        moves.clear();
        
        for(Moves m : arr)
            moves.add(m);
        for(Moves m : list)
            moves.add(m);
    }
    
    public void moveTurn() {
        Player p = players.get(indexOfCurrnetPlayer);
        
        int cnt = 0;
        while(true) {
            indexOfCurrnetPlayer++;
            indexOfCurrnetPlayer %= players.size();
        
            Player pp = players.get(indexOfCurrnetPlayer);
            if(pp.getState() != PlayerStatus.Lose)
                break;
            
            cnt++;
            
            if(cnt > players.size()) {
                gameState = GameState.Over;
                break;
            }
        }
        
        if(gameState == GameState.Over) {
            FlyingShield.stopMoving = true;
            
            for(int i = 0; i < players.size(); i++)
                players.get(i).getScore().setResult(players.get(i).getScore().getResult() + 50 * players.get(i).getNumberOfCurrentSheilds());
        }
        
        moveCurrentPlayer = true;
    }
    
    public void addToScore(Player p) {
        for(int i = 1; i <= gameGrid.n; i++) {
            for(int j = 1; j <= gameGrid.m; j++) {
                Square squ = gameGrid.getSquare(i, j);

                if(squ.getState() == SquareStatus.ClosedMine) {
                    Moves newMove = new Moves(p, squ, MoveType.Finish);
                    newMove.setResult(new MoveResult(rules.finishMine, SquareStatus.MarkedMine));
                    moves.add(newMove);
                }
            }
        }
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
    public int getIndexOfCurrnetPlayer() {
        return indexOfCurrnetPlayer;
    }
    public void setIndexOfCurrnetPlayer(int indexOfCurrnetPlayer) {
        this.indexOfCurrnetPlayer = indexOfCurrnetPlayer;
    }
    public ArrayList<Moves> getMoves() {
        return moves;
    }
    public void setMoves(ArrayList<Moves> moves) {
        this.moves = moves;
    }
    public Grid getGameGrid() {
        return gameGrid;
    }
    public void setGameGrid(Grid gameGrid) {
        this.gameGrid = gameGrid;
    }
    public GameRules getRules() {
        return rules;
    }
    public void setRules(GameRules rules) {
        this.rules = rules;
    }
    public GameState getGameState() {
        return gameState;
    }
    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
    public int getNumberOfRevealedSquares() {
        return numberOfRevealedSquares;
    }
    public void setNumberOfRevealedSquares(int numberOfRevealedSquares) {
        this.numberOfRevealedSquares = numberOfRevealedSquares;
    }
    
    public void showGrid() {
        for(int i = 1; i <= gameGrid.n; i++) {
            System.out.print(i + "- ");
            for(int j = 1; j <= gameGrid.m; j++) {
                gameGrid.square[i][j].show();
            }

            System.out.println();
        }
    }
    
    public void initGame(int n, int m, int k, int x, int y) {
        gameGrid = new Grid(n, m, k);
        numberOfRevealedSquares = n * m - k;
        
        FlyingShield.stopMoving = false;
        ArrayList<Square> list = new ArrayList<>();
        
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= m; j++)
                list.add(new Square(i, j));
        
        Collections.shuffle(list);
        
        for(int i = 0; i < k; i++) {
            int r = list.get(i).getR();
            int c = list.get(i).getC();
            
            gameGrid.square[r][c].setState(SquareStatus.ClosedMine);
            gameGrid.square[r][c].setValue('*');
        }
        
        for(int r = 1; r <= n; r++) {
            for(int c = 1; c <= m; c++) {
                if(gameGrid.square[r][c].getState() == SquareStatus.ClosedMine) {
                    for(int i = 0; i < 8; i++) {
                        int nr = r + ar[i];
                        int nc = c + ac[i];
                        
                        if(gameGrid.ok(nr, nc) && gameGrid.square[nr][nc].getState() == SquareStatus.ClosedEmpty)
                            gameGrid.square[nr][nc].setValue((char)(gameGrid.square[nr][nc].getValue() + 1));
                    }
                }
            }
        }
        
        list.clear();
        for(int r = 1; r <= n; r++) {
            for(int c = 1; c <= m; c++) {
                if(gameGrid.square[r][c].getState() == SquareStatus.ClosedEmpty)
                    list.add(gameGrid.square[r][c]);
            }
        }
        
        Collections.shuffle(list);
        
        for(int i = 0; i < x; i++) {
            int r = list.get(i).getR();
            int c = list.get(i).getC();
            
            System.out.println(r + " " + c);
            gameGrid.square[r][c].setHasNormalShield(true);
        }
        for(int i = x; i < x + y; i++) {
            int r = list.get(i).getR();
            int c = list.get(i).getC();
            
            flyingShields.add(new FlyingShield(gameGrid.square[r][c]));
            
            gameGrid.square[r][c].setHasFlyingShield(true);
        }
        
        for(FlyingShield fsh: flyingShields) {fsh.Move(gameGrid);}
    }
    public void AcceptMove(Moves m) throws IllegalMoveException {
        try {
           m.isAcceptable();
        }
        catch(IllegalMoveException e) {
            throw new IllegalMoveException(e.getMessage());
        }
    }
}
