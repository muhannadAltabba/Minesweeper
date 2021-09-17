package fxapplication;

import fuckmuhannad.EasyAIPlayer;
import fuckmuhannad.GUIGame;
import fuckmuhannad.GUIPlayer;
import fuckmuhannad.Game;
import fuckmuhannad.GameState;
import fuckmuhannad.MediumAIPlayer;
import fuckmuhannad.MoveType;
import fuckmuhannad.Moves;
import fuckmuhannad.Player;
import fuckmuhannad.Save;
import fuckmuhannad.Square;
import fuckmuhannad.SquareStatus;
import static fxapplication.ThirdGui.grid_shield;
import static fxapplication.ThirdGui.move_shield;
import static fxapplication.ThirdGui.player_shield;
import static java.awt.SystemColor.window;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ReplayFace {
    Stage s1;
    Button arr[][];
    
    public void apply(ArrayList<Moves> movesArray) {
        ArrayList<Moves> moves = new ArrayList<>();
        moves = movesArray;
        
        for(Moves move : moves) {
            Square sqr = move.getSquare();

            char val = sqr.getValue();
            int nr = sqr.getR() - 1;
            int nc = sqr.getC() - 1;

            switch (move.getType()) {
                case Reveal:
                    switch (sqr.getState()) {
                        case OpenedMine:
                            arr[nr][nc].setStyle(arr[nr][nc].getStyle() + "-fx-background-image: url('bomb.png'); -fx-background-color: rgb(248,90,50);");
                            break;
                        case OpenedEmpty:
                            switch(val) {
                                case '0':
                                    arr[nr][nc].setStyle(arr[nr][nc].getStyle() + "-fx-background-image: url('0.png');");
                                    arr[nr][nc].setStyle(arr[nr][nc].getStyle() + "-fx-background-color: rgb(248,90,50);");
                                    break;
                                case '1':
                                    arr[nr][nc].setStyle(arr[nr][nc].getStyle() + "-fx-background-image: url('1.png'); -fx-background-color: rgb(248,90,50);");                                     
                                    break;
                                case '2':
                                    arr[nr][nc].setStyle(arr[nr][nc].getStyle() + "-fx-background-image: url('2.png'); -fx-background-color: rgb(248,90,50);"); break;
                                case '3':
                                    arr[nr][nc].setStyle(arr[nr][nc].getStyle() + "-fx-background-image: url('3.png'); -fx-background-color: rgb(248,90,50);"); break;
                                case '4':
                                    arr[nr][nc].setStyle(arr[nr][nc].getStyle() + "-fx-background-image: url('4.png'); -fx-background-color: rgb(248,90,50);"); break;
                                case '5':
                                    arr[nr][nc].setStyle(arr[nr][nc].getStyle() + "-fx-background-image: url('5.png'); -fx-background-color: rgb(248,90,50);"); break;
                                case '6':
                                    arr[nr][nc].setStyle(arr[nr][nc].getStyle() + "-fx-background-image: url('6.png'); -fx-background-color: rgb(248,90,50);"); break;
                                case '7':
                                    arr[nr][nc].setStyle(arr[nr][nc].getStyle() + "-fx-background-image: url('7.png'); -fx-background-color: rgb(248,90,50);"); break;
                                case '8':
                                    arr[nr][nc].setStyle(arr[nr][nc].getStyle() + "-fx-background-image: url('8.png'); -fx-background-color: rgb(248,90,50);"); break;
                            }
                            break;
                    }
                    break;

                case Flood:
                    switch(val) {
                        case '0':
                            arr[nr][nc].setStyle(arr[nr][nc].getStyle() + "-fx-background-image: url('0.png');");
                            arr[nr][nc].setStyle(arr[nr][nc].getStyle() + "-fx-background-color: rgb(248,90,50);");
                            break;
                        case '1':
                            arr[nr][nc].setStyle(arr[nr][nc].getStyle() + "-fx-background-image: url('1.png'); -fx-background-color: rgb(248,90,50);"); break;
                        case '2':
                            arr[nr][nc].setStyle(arr[nr][nc].getStyle() + "-fx-background-image: url('2.png'); -fx-background-color: rgb(248,90,50);"); break;
                        case '3':
                            arr[nr][nc].setStyle(arr[nr][nc].getStyle() + "-fx-background-image: url('3.png'); -fx-background-color: rgb(248,90,50);"); break;
                        case '4':
                            arr[nr][nc].setStyle(arr[nr][nc].getStyle() + "-fx-background-image: url('4.png'); -fx-background-color: rgb(248,90,50);"); break;
                        case '5':
                            arr[nr][nc].setStyle(arr[nr][nc].getStyle() + "-fx-background-image: url('5.png'); -fx-background-color: rgb(248,90,50);"); break;
                        case '6':
                            arr[nr][nc].setStyle(arr[nr][nc].getStyle() + "-fx-background-image: url('6.png'); -fx-background-color: rgb(248,90,50);"); break;
                        case '7':    
                            arr[nr][nc].setStyle(arr[nr][nc].getStyle() + "-fx-background-image: url('7.png'); -fx-background-color: rgb(248,90,50);"); break;
                        case '8':    
                            arr[nr][nc].setStyle(arr[nr][nc].getStyle() + "-fx-background-image: url('8.png'); -fx-background-color: rgb(248,90,50);"); break;
                    }
                    break;
                case Mark:
                    arr[nr][nc].setStyle(arr[nr][nc].getStyle() + "-fx-background-image: url('flagged.png'); -fx-background-color: rgb(248,90,50);"); break;
                case UnMark:
                    System.out.println("UnMarked");
                    arr[nr][nc].setStyle(arr[nr][nc].getStyle() + "-fx-background-image: url('ssss.PNG');"); break;
                case Finish:
                    arr[nr][nc].setStyle(arr[nr][nc].getStyle() + "-fx-background-image: url('bomb.png'); -fx-background-color: rgb(248,90,50);"); break;
            }
        }
    }

    public Game initializeGame(Game game) {
        Game newGame  = new GUIGame();
        
        for(Player player : game.getPlayers()) {
            if(player instanceof GUIPlayer)
                newGame.getPlayers().add(new GUIPlayer());
            if(player instanceof EasyAIPlayer)
                newGame.getPlayers().add(new EasyAIPlayer());
            if(player instanceof MediumAIPlayer)
                newGame.getPlayers().add(new MediumAIPlayer());
        }
        
        newGame.getGameGrid().setN(game.getGameGrid().getN());
        newGame.getGameGrid().setM(game.getGameGrid().getM());
        newGame.getGameGrid().setK(game.getGameGrid().getK());

        for(int i = 1; i <= game.getGameGrid().getN(); i++) {
            for(int j = 1; j <= game.getGameGrid().getM(); j++) {
                Square square = game.getGameGrid().getSquare(i, j);
                square.setState(SquareStatus.ClosedEmpty);
                
                newGame.getGameGrid().setSquare(i, j, square);
            }
        }
        
        return newGame;
    }
    
    public void start(Game game) {

        Stage primaryStage = new Stage();
        
        Group grp = new Group();
        s1 = primaryStage;
        BorderPane pane_package = new BorderPane();
        pane_package.setStyle("-fx-background-image: url('fxapplction.jpg');");
        pane_package.setStyle(pane_package.getStyle()
                + "-fx-background-size: cover;"
                + "-fx-background-repeat: no-repeat;"
                + "-fx-background-position: center;"
                + "-fx-border-color: black;");
        
        ImageView img3 = new ImageView("settings-work-tool1.png");
        ImageView img4 = new ImageView("logout1.png");

        VBox vb = new VBox(50);
        vb.setPadding(new Insets(50, 0, 0, 0));
        
        Button option_game = new Button("Back",img3);
        option_game.setPrefSize(120,40);
        option_game.setFont(Font.font("Tahoma",FontWeight.BOLD,16));
        option_game.setStyle("-fx-border-color: rgb(255,8,3); -fx-color: rgb(255,8,3);-fx-text-fill: rgb(255,255,255);");
        option_game.setOnAction(e -> {
            //TODO
            FXApplication c2 = new FXApplication();
            s1.close();
            c2.start(new Stage()); 
        });
        
        option_game.setId("backId");
       
        ImageView img5 = new ImageView("shield.png");
        Label l25 = new Label("shield:  " + Integer.toString(player_shield),img5);
        
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(75));
        grid.setAlignment(Pos.CENTER);
        
        int n = game.getGameGrid().getN();
        int m = game.getGameGrid().getM();
        int k = game.getGameGrid().getK();
        
        arr = new Button[n + 2][m + 2];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr[i][j] = new Button();
                Button btn = arr[i][j];
                btn.setStyle("-fx-border-color: black;"
                        + "-fx-background-image: url('ssss.PNG');"
                        + "-fx-background-position: center;"
                        + "-fx-background-size: cover;"
                        + "-fx-background-repeat: no-repeat;");
                
                btn.setPrefSize(40, 40);
                grid.add(btn, j, i);
            }
        }

        vb.getChildren().addAll(option_game);
        pane_package.setCenter(grid);
        pane_package.setLeft(vb);
        VBox vb1 = new VBox(50);
        vb1.setPadding(new Insets(90, 0, 0, 0));
        Label l1 = new Label("Zaher");
        l1.setPrefSize(120,40);
        l1.setFont(Font.font("Tahoma",FontWeight.BOLD,16));
        l1.setStyle("-fx-border-color: rgb(151,42,213); -fx-color: rgb(151,42,213);-fx-text-fill: rgb(255,255,255); -fx-background-color: rgb(151,42,213);");
        l1.setFont(Font.font("Tahoma",FontWeight.BOLD,18));
        
        vb1.getChildren().add(l1);
        
        l25.setPrefSize(120,40);
        l25.setFont(Font.font("Tahoma",FontWeight.BOLD,16));
        l25.setStyle("-fx-border-color: rgb(151,42,213); -fx-color: rgb(151,42,213);-fx-text-fill: rgb(255,255,255); -fx-background-color: rgb(151,42,213);");
        l25.setFont(Font.font("Tahoma",FontWeight.BOLD,18));
        vb1.getChildren().addAll (l25);
        
        //TODO
        Label l26 = new Label("   Score:  " + Integer.toString(player_shield));
        l26.setPrefSize(120,40);
        l26.setFont(Font.font("Tahoma",FontWeight.BOLD,16));
        l26.setStyle("-fx-border-color: rgb(151,42,213); -fx-color: rgb(151,42,213);-fx-text-fill: rgb(255,255,255); -fx-background-color: rgb(151,42,213);");
        l26.setFont(Font.font("Tahoma",FontWeight.BOLD,18));
        vb1.getChildren().addAll(l26);
        
        pane_package.setRight(vb1);
        
        Button nextMove = new Button("Get Next Move");
        nextMove.setFont(Font.font("Tahoma",FontWeight.BOLD,16));
        nextMove.setLayoutX(-1150);
        nextMove.setLayoutY(525);
        
        nextMove.setPadding(new Insets(10, 20, 10, 20));
        
        HBox hb = new HBox();
        hb.getChildren().add(nextMove);
        HBox.setMargin(nextMove, new Insets(0, 0, 50, 0));
        
        nextMove.setId("nextId");
        
        hb.setAlignment(Pos.CENTER);
        pane_package.setBottom(hb);
        
        int nn = game.getGameGrid().getN();
        int mm = game.getGameGrid().getM();
        int kk = game.getGameGrid().getK();
        
        Game replayGame = initializeGame(game);
        
        nextMove.setOnAction(e -> {
            if(replayGame.getGameState() == GameState.Over || replayGame.getMoves().size() >= game.getMoves().size()) {
                s1.close();
                (new FXApplication()).start(new Stage());
            }
            else {
                game.getMoves().get(replayGame.getMoves().size()).printMove();
                replayGame.ApplyMove(game.getMoves().get(replayGame.getMoves().size()));
                apply(replayGame.getMoves());
                
                if(replayGame.getGameState() != GameState.Over && replayGame.getMoves().size() < game.getMoves().size()) {
                    Player p = replayGame.getPlayers().get(game.getIndexOfCurrnetPlayer());
                    int score = p.getScore().getResult();
                    int shield = p.getNumberOfCurrentSheilds();
                    String name = p.getName();
                    
                    l1.setText(name);
                    l26.setText(Integer.toString(score));
                    l25.setText(Integer.toString(shield));
                }
                else {
                    l1.setText("Game Over");
                    l26.setText("Game Over");
                    l25.setText("Game Over");
                    nextMove.setText("Go to Main Menu");
                }
            }
        });
        
        primaryStage.setTitle("Minesweeper");
       
        Scene ss = new Scene(pane_package);
        ss.getStylesheets().add("ReplayStyle.css");
 
        primaryStage.setScene(ss);
 
        Screen screen = Screen.getPrimary();
    
        Rectangle2D bounds = screen.getVisualBounds();

        primaryStage.setWidth(1200);
        primaryStage.setHeight(600);
        primaryStage.showAndWait();    
    }
}