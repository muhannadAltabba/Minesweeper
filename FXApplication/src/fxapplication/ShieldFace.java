
package fxapplication;

import fuckmuhannad.GUIGame;
import fuckmuhannad.GUIPlayer;
import fuckmuhannad.Game;
import fuckmuhannad.GameState;
import fuckmuhannad.MoveType;
import fuckmuhannad.Moves;
import fuckmuhannad.Player;
import fuckmuhannad.Square;
import static java.awt.SystemColor.window;
import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ShieldFace extends Application {   
    Stage s1;
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        Group grp = new Group();
        //pane.setStyle("-fx-background-color: Red;");
        pane.setStyle("-fx-background-image: url('shliddd.jpg');");
        s1 = primaryStage;
        
        //ImageView img4 = new ImageView("balloon.png");
        HBox hb = new HBox();
        hb.setPadding(new Insets(0, 0, 5, 140));
        Button btn1 = new Button("Collect");
        btn1.setLayoutX(500);
        btn1.setLayoutY(350);
        btn1.setPrefSize(120,40);
        btn1.setFont(Font.font("Tahoma",FontWeight.BOLD,16));
        btn1.setStyle("-fx-border-color: rgb(254,177,36); -fx-color: rgb(254,177,36);-fx-text-fill: rgb(127,132,137);");
        btn1.setOnAction(e -> {
            primaryStage.close();
        });
        
       
        hb.getChildren().addAll(btn1);
        
        
        
        
        pane.setBottom(hb);
        Scene ss = new Scene(pane);
       
        primaryStage.setScene(ss);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Shield");
        primaryStage.setWidth(400);
        primaryStage.setHeight(225);    
        primaryStage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
