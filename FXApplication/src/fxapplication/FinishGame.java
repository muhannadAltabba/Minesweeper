package fxapplication;

import fuckmuhannad.GUIPlayer;
import fuckmuhannad.Game;
import fuckmuhannad.Player;
import fuckmuhannad.PlayerBoard;
import fuckmuhannad.Save;
import fuckmuhannad.SaveR;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class FinishGame {
    public static int cur = 0;
    
    public static void showScore(Game game) {
        Stage window = new Stage();
        BorderPane pane = new BorderPane();
        Group group = new Group();
        pane.setStyle("-fx-background-image: url('original.png');");
        for(int i = 0; i < game.getPlayers().size(); i++){
        Label label1 = new Label(game.getPlayers().get(i).getName());
        label1.setFont(Font.font("Tahoma",FontWeight.BOLD,16));
        label1.setLayoutX(25);
        label1.setLayoutY(10 + i*25);
            
        Label label2 = new Label(Integer.toString(game.getPlayers().get(i).getScore().getResult()));
        label2.setFont(Font.font("Tahoma",FontWeight.BOLD,16));
        label2.setLayoutX(160);
        label2.setLayoutY(10 + i*25);
            
        group.getChildren().addAll(label1, label2);
        
        }
        pane.setCenter(group);
        Scene scene = new Scene(pane);
        
        window.setTitle("Scores");
        window.setResizable(false);
        window.setScene(scene);
        window.setWidth(500);
        window.setHeight(250);
        window.showAndWait();
    }
    
    public static void finish(Game game) {
        cur = (new ScoreBoard()).getNextId(cur + 1);
        
        Stage window = new Stage();
        BorderPane pane = new BorderPane();
        pane.setStyle("-fx-background-image: url('41nKKuNMe6L.jpg');"
                + "-fx-background-size: cover;"
                + "-fx-background-position: center;"
                + "-fx-background-repeat: no-repeat;");
        
        Group group = new Group();
        
        VBox vb = new VBox();
        
        Button btn1 = new Button("Show Scores");
//        btn1.setLayoutX(250);
//        btn1.setLayoutY(100);
        btn1.setPrefSize(430,30);
        btn1.setFont(Font.font("Tahoma",FontWeight.BOLD,16));
//        btn1.setStyle("-fx-border-color: gray; -fx-color: gray;-fx-text-fill: white;");
        btn1.setOnAction(e -> {
            showScore(game);
        });
        
        Button btn2 = new Button("Play Again");
        btn2.setLayoutX(60);
        btn2.setLayoutY(100);
        btn2.setPrefSize(430,30);
        btn2.setFont(Font.font("Tahoma",FontWeight.BOLD,16));
//        btn2.setStyle("-fx-border-color: gray; -fx-color: gray;-fx-text-fill: white;");
        btn2.setOnAction(e -> {
            FXApplication c2 = new FXApplication();
            window.close();
            c2.start(new Stage());
        });
        
        Button btn3 = new Button("Exit Game");
        btn3.setLayoutX(250);
        btn3.setLayoutY(150);
        btn3.setPrefSize(430,30);
        btn3.setFont(Font.font("Tahoma",FontWeight.BOLD,16));
//        btn3.setStyle("-fx-border-color: gray; -fx-color: gray;-fx-text-fill: white;");
        btn3.setOnAction(e -> {
            window.close();
        });       
        
        Button btn4 = new Button("Save Replay");
        btn4.setLayoutX(60);
        btn4.setLayoutY(150);
        btn4.setPrefSize(430,30);
        btn4.setFont(Font.font("Tahoma",FontWeight.BOLD,16));
//        btn4.setStyle("-fx-border-color: gray; -fx-color: gray;-fx-text-fill: white;");

        btn4.setOnAction(e -> {
            int idReplay = (new SaveR()).getNextFile();
            int id = cur;
            
            (new ScoreBoard()).editReplay(id, idReplay);
            
            saveReplay(game);
        });
        
        int maxScore = -200000000;
        for(Player player : game.getPlayers()) {
            int score = player.getScore().getResult();
            maxScore = Math.max(score, maxScore);
        }
        
        Player player = new GUIPlayer();
        for(Player pl : game.getPlayers()) {
            if(pl.getScore().getResult() == maxScore) {
                player = pl;
                break;
            }
        }
        
        if(new ScoreBoard().isWritable(maxScore)) 
            (new ScoreBoard()).write(new PlayerBoard(player.getName(), -1, maxScore, cur));
        
        
        Label l = new Label("The Game Is Finished");
        l.setLayoutX(40);
        l.setLayoutY(40);
        l.setFont(Font.font("Tahoma",FontWeight.BOLD,32));
        l.setStyle("-fx-text-fill: red");
        
        vb.getChildren().add(0, l);

        HBox hBox1 = new HBox();
        hBox1.setLayoutY(100);
        hBox1.getChildren().addAll(btn1);
        HBox.setMargin(btn1, new Insets(60, 0, 0, 0));

        vb.getChildren().add(1, hBox1);
        
        HBox hBox2 = new HBox();
        hBox2.setLayoutY(150);
        hBox2.getChildren().addAll(btn4);
        HBox.setMargin(btn4, new Insets(13, 0, 0, 0));

        vb.getChildren().add(2, hBox2);
        
        HBox hBox3 = new HBox();
        hBox3.setLayoutY(200);
        hBox3.getChildren().addAll(btn2);
        HBox.setMargin(btn2, new Insets(13, 0, 0, 0));

        vb.getChildren().add(3, hBox3);
        
        HBox hBox4 = new HBox();
        hBox4.setLayoutY(250);
        hBox4.getChildren().addAll(btn3);
        HBox.setMargin(btn3, new Insets(13, 0, 0, 0));

        vb.getChildren().add(4, hBox4);
        
        vb.setAlignment(Pos.CENTER);
        group.getChildren().addAll(vb);
        
//        group.getChildren().addAll(btn2,btn3,l,btn4);
        pane.setCenter(group);
        Scene scene = new Scene(pane);
        scene.getStylesheets().add("FinishStyle.css");
        
        window.setScene(scene);
        window.setResizable(false);
        window.setTitle("The Game Is Finished");
        window.setWidth(600);
        window.setHeight(400);
//        window.setResizable(false); 
        window.showAndWait();
    }
    
    public static void saveReplay(Game game) {
        SaveR saveR = new SaveR();
        int fileNum = saveR.getNextFile();
        try {saveR.writeToFile(game, fileNum);} catch (IOException ex) {}
    }
}
