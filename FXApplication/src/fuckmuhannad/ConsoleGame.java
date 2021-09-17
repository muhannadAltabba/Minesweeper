package fuckmuhannad;

import java.io.Serializable;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class ConsoleGame extends NormalGame implements Serializable {
        
        public ConsoleGame() {
        players = new ArrayList<Player>();
        indexOfCurrnetPlayer = 0;
        moves = new ArrayList<Moves>();
        gameGrid = new Grid(0, 0, 0);
        numberOfRevealedSquares = 0;
        gameState = GameState.Running;
    }

    public ConsoleGame(int n, int m, int k) {
        players = new ArrayList<Player>();
        indexOfCurrnetPlayer = 0;
        moves = new ArrayList<Moves>();
        gameGrid = new Grid(n, m, k);
        rules = new GameRules(1, 1, 1, 1, 1, 1, 1, 100);
        numberOfRevealedSquares = 0;
        gameState = GameState.Running;
    }
    
    public ConsoleGame(ArrayList<Player> pl, int n, int m, int k) {
        players = pl;
        indexOfCurrnetPlayer = 0;
        moves = new ArrayList<Moves>();
        gameGrid = new Grid(n, m, k);
        rules = new GameRules(5, 1, 1, 5, 10, 1, 250, 100);
        numberOfRevealedSquares = 0;
        gameState = GameState.Running;
    }

    public ConsoleGame(ArrayList<Player> players, ArrayList<Moves> moves, Grid gameGrid, GameRules rules) {super(players, moves, gameGrid, rules);}

    public int getNumberOfRevealedSquares() {return numberOfRevealedSquares;}
    public void setNumberOfRevealedSquares(int numberOfRevealedSquares) {this.numberOfRevealedSquares = numberOfRevealedSquares;}
    public GameRules getRules() {return rules;}
    public void setRules(GameRules rules) {this.rules = rules;}
    public GameState getGameState() {return gameState;}
    public void setGameState(GameState gameState) {this.gameState = gameState;}    
    public ArrayList<Player> getPlayers() {return players;}
    public void setPlayers(ArrayList<Player> players) {this.players = players;}
    public int getIndexOfCurrnetPlayer() {return indexOfCurrnetPlayer;}
    public void setIndexOfCurrnetPlayer(int indexOfCurrnetPlayer) {this.indexOfCurrnetPlayer = indexOfCurrnetPlayer;}
    public ArrayList<Moves> getMoves() {return moves;}
    public void setMoves(ArrayList<Moves> moves) {this.moves = moves;}
    public Grid getGameGrid() {return super.gameGrid;}
    public void setGameGrid(Grid gameGrid) {this.gameGrid = gameGrid;}
    
//    
//    public void ApplyMove(Moves move) {
//        moves.clear();
//        Square sq = gameGrid.square[move.getSquare().getR()][move.getSquare().getC()];
//        move.setSquare(sq);
//        
//        try {
//            AcceptMove(move);
//        }
//        catch(IllegalMoveException  e) {
//            System.out.println(e.getMessage());
//            return;
//        }
//        
//        if (move.getType() == MoveType.Reveal && move.getSquare().getState() == SquareStatus.ClosedEmpty) {
//            gameGrid.floodFill(move.getSquare().getR(), move.getSquare().getC());
//            moves.remove(moves.size() - 1);
//        }
//
//        moves.add(move);
//        
////        System.out.println(move.getSquare().getState());
////        System.out.println(gameGrid.square[1][1].getState());
//        
//        for (Moves mv : moves) {
//            SquareStatus newState = SquareStatus.OpenedEmpty;
//            int score = 0;
//            
//            MoveType type = mv.getType();
//            SquareStatus state = mv.getSquare().getState();
//            
//            if(type == MoveType.Mark) {
//                if(state == SquareStatus.ClosedEmpty) {
//                    score -= rules.markWrong;
//                    newState = SquareStatus.MarkedEmpty;
//                }
//                if(state == SquareStatus.ClosedMine) {
//                    score += rules.markCorrect;
//                    newState = SquareStatus.MarkedMine;
//                }
//            }
//            if(type == MoveType.UnMark) {
//                if(state == SquareStatus.MarkedEmpty) {
//                    score += rules.unMarkCorrect;
//                    newState = SquareStatus.ClosedEmpty;
//                }
//                if(state == SquareStatus.MarkedMine) {
//                    score -= rules.uNMarkWrong;
//                    newState = SquareStatus.ClosedMine;
//                }
//            }
//            if(type == MoveType.Reveal) {
//                if(state == SquareStatus.ClosedEmpty) {
//                    if(mv.getSquare().getValue() == '0')
//                        score += rules.revealEmpty;
//                    score += (int)(mv.getSquare().getValue() - '0');
//                    newState = SquareStatus.OpenedEmpty;
//                }
//                if(state == SquareStatus.ClosedMine) {
//                    score -= rules.revealMine;
//                    newState = SquareStatus.OpenedMine;
//                }
//            }
//            if(type == MoveType.Flood) {
//                score += rules.revealFlood;
//                newState = SquareStatus.OpenedEmpty;
//            }
//            
//            mv.setResult(new MoveResult(score, newState));
//        }
//        
//        Player p = players.get(indexOfCurrnetPlayer);
//        
//        if(numberOfRevealedSquares == 0)
//            gameState = GameState.Over;
//        
//        if(gameState == GameState.Over) {
//            for(int i = 1; i <= gameGrid.n; i++) {
//                for(int j = 1; j <= gameGrid.m; j++) {
//                    Square squ = gameGrid.getSquare(i, j);
//                    
//                    if(squ.getState() == SquareStatus.ClosedMine) {
//                        Moves newMove = new Moves(p, squ, MoveType.Finish);
//                        newMove.setResult(new MoveResult(rules.finishMine, SquareStatus.MarkedMine));
//                        moves.add(newMove);
//                    }
//                }
//            }
//        }
//        
//        p.addScore(moves);
//        
//        for(Moves mv : moves) {
//            mv.getSquare().setState(mv.getResult().getState());
//        }
//        
//        if(p.getScore().getResult() < 0)
//            p.setState(PlayerStatus.Lose);
//
//        int cnt = 0;
//        while(true) {
//            indexOfCurrnetPlayer++;
//            indexOfCurrnetPlayer %= players.size();
//        
//            Player pp = players.get(indexOfCurrnetPlayer);
//            if(pp.getState() != PlayerStatus.Lose)
//                break;
//            
//            cnt++;
//            
//            if(cnt > players.size()) {
//                gameState = gameState.Over;
//                break;
//            }
//        }
//    }

    
}
