package fxapplication;

import fuckmuhannad.PlayerBoard;
import fuckmuhannad.SaveBoard;
import fuckmuhannad.SaveR;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class ScoreBoard implements Serializable {
    ArrayList<PlayerBoard> list = new ArrayList<>();
    
    public void reset() {
        for(int i = 1; i <= 5; i++) {
            PlayerBoard plb = new PlayerBoard("No Name", -1, 0, -1);
            try {
                (new SaveBoard()).writeToFile(plb, i);
            } catch (IOException ex) {}
        }
    }
    
    public void init() {
        list.clear();
        for(int i = 1; i <= 5; i++) {
            SaveBoard save = new SaveBoard();
            try {
                save.readToFile(i);
            } catch (IOException ex) {} catch (ClassNotFoundException ex) {}
        
            list.add(save.getPlayerBoard());
        }
    }
    
    public boolean isExist(int id) {
        for(PlayerBoard plb : list)
            if(plb.getId() == id)
                return true;
        
        return false;
    }
    
    public int getNextId(int idBegin) {
        int id = idBegin;
        while(isExist(id))
            id++;
        
        return id;
    }
    
    public boolean isWritable(int score) {
        init();
        
        for(PlayerBoard plb : list) {
            if(plb.getScore() < score)
                return true;
        }
        
        return false;
    }
    
    public void write(PlayerBoard newPlb) {
        init();
        
        int minScore = 20000000;
        for(PlayerBoard plb : list)
            minScore = Math.min(minScore, plb.getScore());
        
        for(int i = 0; i < 5; i++) {
            PlayerBoard plb = list.get(i);
            
            if(plb.getScore() == minScore) {
                try {
                    (new SaveBoard()).writeToFile(newPlb, i + 1);
                } catch (IOException ex) {}
                break;
            }
        }
    }
    
    public void editReplay(int id, int idReplay) {
        init();
        
        for(int i = 0; i < 5; i++) {
            PlayerBoard plb = list.get(i);
            
            if(plb.getId() == id) {
                list.get(i).setIdReplay(idReplay);
                try {
                    (new SaveBoard()).writeToFile(list.get(i), i + 1);
                } catch (IOException ex) {}
                break;
            }
        }
    }
    
    public void display() {
        Stage window = new Stage();
        window.setTitle("Score Board");
        
        BorderPane pane = new BorderPane();
        pane.setStyle(""
                + "-fx-background-size: cover;"
                + "-fx-background-position: center;"
                + "-fx-background-repeat: no-repeat;");
        
        Group group = new Group();
        
        HBox hb = new HBox();
        Button reset = new Button("Reset");
        Button show = new Button("Show Score Board");
        Button back = new Button("Back");
        
        reset.setFont(Font.font("Tahoma",FontWeight.BOLD,16));
        show.setFont(Font.font("Tahoma",FontWeight.BOLD,16));
        back.setFont(Font.font("Tahoma",FontWeight.BOLD,16));

        reset.setPrefSize(100,40);
        show.setPrefSize(200,40);
        back.setPrefSize(100,40);
        
        reset.setOnAction(e -> {
            reset();
        });
        
        back.setOnAction(e-> {
            window.close();
            (new FXApplication()).start(new Stage());
        });
        
        show.setOnAction(e -> {
            window.close();
            init();
            ScoreBoardExcuter sbe = new ScoreBoardExcuter();
            ArrayList<Product> products = new ArrayList<>();

            int cur = 0;
            for(PlayerBoard plb : list) {
                cur++;

                Product product = new Product();
                product.setId(plb.getId());
                product.setName(plb.getName());
                product.setScore(plb.getScore());
                product.setIdReplay(plb.getIdReplay());

                Button btn = new Button("Replay #" + Integer.toString(cur));
                if(plb.getIdReplay() == -1)
                    btn.setDisable(true);

                product.setReplay(btn);

                products.add(product);
            }

            sbe.setList(products);

            try {
                sbe.start(new Stage());
            } catch (Exception ex) {
                Logger.getLogger(ScoreBoard.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        HBox hbReset = new HBox();
        hbReset.setLayoutY(150);
        hbReset.getChildren().addAll(reset);
        HBox.setMargin(reset, new Insets(0, 13, 0, 0));
        
        hb.getChildren().addAll(hbReset);
        
        HBox hbShow = new HBox();
        hbShow.setLayoutY(150);
        hbShow.getChildren().addAll(show);
        HBox.setMargin(show, new Insets(0, 13, 0, 0));
        
        hb.getChildren().addAll(hbShow);
        
        HBox hbBack = new HBox();
        hbBack.setLayoutY(150);
        hbBack.getChildren().addAll(back);
        HBox.setMargin(back, new Insets(0, 13, 0, 0));
        
        hb.getChildren().addAll(hbBack);
        
        hb.setAlignment(Pos.CENTER);
        group.getChildren().add(hb);
        pane.setCenter(group);
        
        Scene scene = new Scene(pane, 500, 200);
        scene.getStylesheets().add("ScoreBoardStyle.css");
        
        window.setScene(scene);
        window.show();
    }
}

