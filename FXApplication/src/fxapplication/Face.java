
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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Face {
    Stage s1;
    
    Button arr[][];
    int human_count,grid_hight,grid_width,count_mine,count_easy_player,count_hard_player;

    Label l1;
    
    public static boolean endThread = false;
    public static boolean isLocked = false;
    
    static double ii = 0;
    
    public Face() {
        human_count = 1;
        grid_hight = 8;
        grid_width = 8;
        count_mine = 8;
        count_easy_player = 0;
        count_hard_player = 0;

        if(!Advance_option.isInit) {
            Advance_option.isInit = true;
            Advance_option.correctMark = 5;
            Advance_option.correctUnMark = 1;
            Advance_option.wrongMark = -5;
            Advance_option.wrongUnMark = -1;
        }
    }

    void get_from_third_page(int grid_hight,int grid_width,int count_mine,int human_count,int count_easy_player,int count_hard_player, ArrayList<String> ls){
        this.human_count = human_count;
        this.grid_hight = grid_hight;
        this.grid_width = grid_width;
        this.count_mine = count_mine;
        this.count_easy_player = count_easy_player;
        this.count_hard_player = count_hard_player;
    }
    
    public void start(Game game) {
        /*Project.main(new String[20]);
        if(true)
            return;
        */
        
        Stage primaryStage = new Stage();
        Face.endThread = false;
        
        Group grp = new Group();
        s1 = primaryStage;
        BorderPane pane_package = new BorderPane();
        pane_package.setStyle("-fx-background-image: url('fxapplction.jpg');");
        pane_package.setStyle(pane_package.getStyle()
                + "-fx-background-size: cover;"
                + "-fx-background-repeat: no-repeat;"
                + "-fx-background-position: center;"
                + "-fx-border-color: black;");
        
        ImageView img1 = new ImageView("save.png");
        ImageView img2 = new ImageView("logout1.png");
        ImageView img3 = new ImageView("settings-work-tool1.png");
        ImageView img4 = new ImageView("logout1.png");

        VBox vb = new VBox(50);
        vb.setPadding(new Insets(50, 0, 0, 0));

        Button save_game = new Button("Save", img1);
        save_game.setPrefSize(120,40);
        save_game.setFont(Font.font("Tahoma",FontWeight.BOLD,16));
        save_game.setStyle("-fx-border-color: rgb(255,8,3); -fx-color: rgb(255,8,3);-fx-text-fill: rgb(255,255,255);");
        save_game.setOnAction(e -> {
            s1.hide();
            (new SaveGame()).display(game);
            s1.show();
        });

        save_game.setId("saveGameId");
        
        Button exitGame = new Button("Exit",img2);
        
        exitGame.setPrefSize(120,40);
        exitGame.setFont(Font.font("Tahoma",FontWeight.BOLD,16));
        exitGame.setStyle("-fx-border-color: rgb(255,8,3); -fx-color: rgb(255,8,3);-fx-text-fill: rgb(255,255,255);");
        exitGame.setOnAction(e -> {
            primaryStage.hide();
            CorrectExit.display(primaryStage);
        });

        exitGame.setId("exitId");
        
        Button option_game = new Button("Back",img3);
        option_game.setPrefSize(120,40);
        option_game.setFont(Font.font("Tahoma",FontWeight.BOLD,16));
        option_game.setStyle("-fx-border-color: rgb(255,8,3); -fx-color: rgb(255,8,3);-fx-text-fill: rgb(255,255,255);");
        option_game.setOnAction(e -> {
            FXApplication c2 = new FXApplication();
            s1.close();
            c2.start(new Stage()); 
        });
        
        option_game.setId("backId");
       
//        System.out.println("<Players>");
//        for(Player x : pls) {
//            System.out.println(x.getName());
//        }
//        System.out.println("</Players>");

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
                
                btn.setOnMouseClicked(e -> {
                    if(isLocked)
                        return;
                
                    int r = GridPane.getRowIndex(btn);
                    int c = GridPane.getColumnIndex(btn);
                    GUIPlayer.r = r;
                    GUIPlayer.c = c;

                    MouseButton button = e.getButton();
                    if(button == MouseButton.PRIMARY){
                        GUIPlayer.type = MoveType.Reveal;
                    }
                    else if(button == MouseButton.SECONDARY) {
                        Square sqr = game.getGameGrid().getSquare(r + 1, c + 1);

                        if(sqr.getState() == SquareStatus.MarkedEmpty || sqr.getState() == SquareStatus.MarkedMine)
                            GUIPlayer.type = MoveType.UnMark;
                        else
                            GUIPlayer.type = MoveType.Mark;
                    }
                    
                    Player p = game.getPlayers().get(game.getIndexOfCurrnetPlayer());
                    Moves move = p.getNextMove(game.getGameGrid());
                    
                    handleMove(game, move, l25);
                
                    if(game.getGameState() == GameState.Over) {
                        System.out.print("\n\nScores are Here : ");
                        for(Player x : game.getPlayers())
                            System.out.print(x.getScore().getResult() + " ");
                        System.out.println();
                        FinishGame.finish(game);
                        primaryStage.close();                        
                    }
                });
            }
        }

        vb.getChildren().addAll(option_game, save_game,exitGame);
        pane_package.setCenter(grid);
        pane_package.setLeft(vb);
        VBox vb1 = new VBox(50);
        vb1.setPadding(new Insets(90, 0, 0, 0));
        l1 = new Label("Player Name");
        l1.setPrefSize(120,40);
        l1.setFont(Font.font("Tahoma",FontWeight.BOLD,16));
        l1.setStyle("-fx-border-color: rgb(151,42,213); -fx-color: rgb(151,42,213);-fx-text-fill: rgb(255,255,255); -fx-background-color: rgb(151,42,213);");
        l1.setFont(Font.font("Tahoma",FontWeight.BOLD,18));
        
        vb1.getChildren().add(l1);
        ProgressBar pb = new ProgressBar();
        
        new Thread(new Runnable() {
            @Override
            public synchronized void run() {                
                try {
                    while(game.getGameState() != GameState.Over){
                        ii = 0;
                        Game.moveCurrentPlayer = false;
                        
                        if(endThread)
                            return;
                        
                        for (int i = 0; i < 20; i++) {
                            if(Game.moveCurrentPlayer)
                                break;
                            if(endThread)
                                return;
                            
                            ii += 0.05;
                            
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    pb.setProgress(ii);
                                }
                            });
                            
                            Thread.sleep(999);
                        }
                        
                        if(!Game.moveCurrentPlayer) {
                            game.moveTurn();
                            moveTurn(game, l25);
                        }
                    }
		}
                catch (InterruptedException ex) {}
           }
        }).start();
        
        
        pb.setLayoutX(-1150);
        pb.setLayoutY(525);
        pane_package.setBottom(pb);
        
        l25.setPrefSize(120,40);
        l25.setFont(Font.font("Tahoma",FontWeight.BOLD,16));
        l25.setStyle("-fx-border-color: rgb(151,42,213); -fx-color: rgb(151,42,213);-fx-text-fill: rgb(255,255,255); -fx-background-color: rgb(151,42,213);");
        l25.setFont(Font.font("Tahoma",FontWeight.BOLD,18));
        
        vb1.getChildren().addAll (l25);
        pane_package.setRight(vb1);
 
        primaryStage.setTitle("Minesweeper");
       
        Scene ss = new Scene(pane_package);
        ss.getStylesheets().add("FaceStyle.css");

        primaryStage.setScene(ss);
 
        Screen screen = Screen.getPrimary();
        apply(game);

        Rectangle2D bounds = screen.getVisualBounds();

        primaryStage.setWidth(1200);
        primaryStage.setHeight(600);
        primaryStage.showAndWait();    
    }
    
    public void moveTurn(Game game, Label l25) {
        Player p = game.getPlayers().get(game.getIndexOfCurrnetPlayer());
        final int pp = p.getNumberOfCurrentSheilds();
        final String s = p.getName();

        if(p instanceof GUIPlayer) {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    l25.setText("shield:  " +Integer.toString(pp));
                }
            });
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    l1.setText(s);
                }
            });
        }
        else {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    l25.setText("shield:  " + Integer.toString(pp));
                }
            });
            Moves newMove = p.getNextMove(game.getGameGrid());
            isLocked = true;
            
            new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        handleMove(game, newMove, l25);
                        isLocked = false;
                    }
                }, 
                2000
            );
        }
    }
    
    public boolean apply(Game game) {
        ArrayList<Moves> moves = new ArrayList<>();
        moves = game.getMoves();
        
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
                    arr[nr][nc].setStyle(arr[nr][nc].getStyle() + "-fx-background-image: url('ssss.PNG');"); break;
                case Finish:
                    arr[nr][nc].setStyle(arr[nr][nc].getStyle() + "-fx-background-image: url('bomb.png'); -fx-background-color: rgb(248,90,50);"); break;
            }
        }
        
//        moves.clear();
        
        return game.getGameState() == GameState.Over;
    }
    
    public void handleMove(Game game, Moves move, Label l25) {
        Player p = game.getPlayers().get(game.getIndexOfCurrnetPlayer());
        game.ApplyMove(move);

//        System.out.println(p.getScore().getResult());
//        System.out.println(game.getGameState());

        if(apply(game))
            return;

        moveTurn(game, l25);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
