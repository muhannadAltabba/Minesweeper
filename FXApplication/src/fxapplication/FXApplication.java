package fxapplication;

import fuckmuhannad.*;
import static fuckmuhannad.Game.moveCurrentPlayer;
import static fxapplication.ThirdGui.grid_shield;
import static fxapplication.ThirdGui.move_shield;
import static fxapplication.ThirdGui.player_shield;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class FXApplication extends Application  {
    @SuppressWarnings("empty-statement")
 
    Stage s1;
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        Group grp = new Group();
        pane.setStyle("-fx-background-image: url('keyArt_large.jpg');");
        s1 = primaryStage;
        
        ArrayList<Player> pls = new ArrayList<>();
        
        if(ThirdGui.player_count == 0) {
            ThirdGui sdsdsd = new ThirdGui(false);
        }
        
        int cnt = ThirdGui.player_count;
        for(int i = 0; i < cnt; i++) {
            pls.add(new GUIPlayer());
            pls.get(i).setName(ThirdGui.playerList.get(i));
        }
        
        cnt = ThirdGui.count_easy_player;
        for(int i = 0; i < cnt; i++)
            pls.add(new EasyAIPlayer());
        
        cnt = ThirdGui.count_hard_player;
        for(int i = 0; i < cnt; i++)
            pls.add(new MediumAIPlayer());
        
        Game game = new GUIGame(pls, 5, 5, 5);
        int n = ThirdGui.grid_hight, m = ThirdGui.grid_width, k = ThirdGui.count_mine;
        
        game.getRules().setMarkCorrect(Advance_option.correctMark);
        game.getRules().setUnMarkCorrect(Advance_option.correctUnMark);
        game.getRules().setMarkWrong(Advance_option.wrongMark);
        game.getRules().setUNMarkWrong(Advance_option.wrongUnMark);
        
        game.initGame(n, m, k, grid_shield, move_shield);
        
        for(Player p : game.getPlayers()) {
            if(!(p instanceof EasyAIPlayer))
                p.setNumberOfCurrentSheilds(player_shield);
        }        
        
        //ImageView img4 = new ImageView("balloon.png");
        Button btn1 = new Button("New Game");
        btn1.setLayoutX(500);
        btn1.setLayoutY(320);
        btn1.setPrefSize(150,40);
        btn1.setFont(Font.font("Tahoma",FontWeight.BOLD,16));
        btn1.setOnAction(e -> {
            Face c2 = new Face();
            primaryStage.close();
            c2.start(game);
        });
        
        btn1.setId("newGameId");
        
        ImageView img1 = new ImageView("folder-refresh.png");
        Button btn2 = new Button("Load Game",img1);
        btn2.setLayoutX(500);
        btn2.setLayoutY(375);
        btn2.setPrefSize(150,40);
        btn2.setFont(Font.font("Tahoma",FontWeight.BOLD,16));
        btn2.setOnAction(e -> {
            s1.close();
            (new LoadGame()).display();
        });

        btn2.setId("loadGameId");
        
        //ImageView img1 = new ImageView("folder-refresh.png");
        Button btnn = new Button("Load Replay");
        btnn.setLayoutX(500);
        btnn.setLayoutY(430);
        btnn.setPrefSize(150,40);
        btnn.setFont(Font.font("Tahoma",FontWeight.BOLD,16));
        btnn.setOnAction(e -> {
            s1.close();
            (new LoadReplay()).display();
        });
        
        btnn.setId("loadReplayId");
        
        Button btnn1 = new Button("Score Board");
        btnn1.setLayoutX(1100);
        btnn1.setLayoutY(320);
        btnn1.setPrefSize(150,40);
        btnn1.setFont(Font.font("Tahoma",FontWeight.BOLD,16));
        btnn1.setOnAction(e -> {
            s1.close();
            (new ScoreBoard()).display();
        });

        btnn1.setId("scoreBoardId");
        
        ImageView img2 = new ImageView("logout.png");
        Button btn3 = new Button("Exit",img2);
        btn3.setLayoutX(1100);
        btn3.setLayoutY(430);
        btn3.setPrefSize(150,40);
        btn3.setFont(Font.font("Tahoma",FontWeight.BOLD,16));
        
        btn3.setOnAction(e -> {
           System.exit(0);
        });

        btn3.setId("exitId");

        ImageView img3 = new ImageView("settings-work-tool.png");
        Button btn4 = new Button("Options",img3);
        
        btn4.setLayoutX(1100);
        btn4.setLayoutY(375);
        btn4.setPrefSize(150,40);
        btn4.setFont(Font.font("Tahoma",FontWeight.BOLD,16));
        btn4.setOnAction(e -> {
            second c2 = new second();
            primaryStage.close();
             c2.start(new Stage()); 
        });
        
        btn4.setId("optionsId");
        
        grp.getChildren().addAll(btn1,btn2,btn3,btn4,btnn,btnn1);
        pane.setCenter(grp);
        
        Scene ss = new Scene(pane);
        ss.getStylesheets().add("FXStyle.css");
        
        primaryStage.setScene(ss);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Minesweeper");
        primaryStage.setWidth(960);
        primaryStage.setHeight(415);    
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }    
}
