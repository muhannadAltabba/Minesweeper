package fxapplication;

import fuckmuhannad.GUIGame;
import fuckmuhannad.Game;
import fuckmuhannad.Save;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class LoadGame {
    public void display() {
        Stage window = new Stage();
        window.setTitle("Load Game");
        
        GridPane grid = new GridPane();
        
        for(int i = 0; i < 5; i++) {
            Button btn = new Button("Game #" + Integer.toString(i + 1));
            btn.setPadding(new Insets(30, 0, 30, 0));
            btn.setFont(Font.font("Tahoma",FontWeight.BOLD,16));
            btn.setPrefSize(710,40);
            grid.add(btn, 0, i);
            
            if(!(new Save()).checkFile(i))
                btn.setText("No Saved File");
            
            btn.setOnAction(e -> {
                int fileNum = GridPane.getRowIndex(btn);
                Save save = new Save();
                
                if(save.checkFile(fileNum)) {
                    try {
                        save.readToFile(fileNum);
                        Game game = save.getGame();
                        window.close();
                        (new Face()).start(game);
                   } catch (IOException ex) {} catch (ClassNotFoundException ex) {}
                }
            });
        }
        Button btn1 = new Button("Back");
        btn1.setPrefSize(710,40);
        btn1.setFont(Font.font("Tahoma",FontWeight.BOLD,16));
        
        btn1.setOnAction(e -> {
            window.close();
            (new FXApplication()).start(new Stage());
        });
        
        HBox hBox = new HBox();
        hBox.getChildren().add(btn1);
        HBox.setMargin(btn1, new Insets(25, 200, 25, 200));
        hBox.setId("backId");
        
        grid.add(hBox, 0, 5);
        
        Scene scene = new Scene(grid, 700, 475);
        scene.getStylesheets().add("LoadStyle.css");
        
        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }
}
