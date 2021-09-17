package fxapplication;


import fuckmuhannad.GUIGame;
import fuckmuhannad.GUIPlayer;
import fuckmuhannad.Game;
import fuckmuhannad.GameState;
import fuckmuhannad.MoveType;
import fuckmuhannad.Moves;
import fuckmuhannad.Player;
import fuckmuhannad.Square;
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
import javafx.scene.control.TextField;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Advance_option {
    public static int correctMark, correctUnMark, wrongMark, wrongUnMark;
    public static boolean isInit = false;
    
    Stage s1;
    
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        Group grp = new Group();
        
        Label l1 = new Label("Score For Correct Mark");
        l1.setLayoutX(80);
        l1.setLayoutY(50);
        l1.setFont(Font.font("Tahoma",FontWeight.BOLD,16));
       // l1.setStyle("-fx-text-fill: orange");
        TextField correct_mark = new TextField();
        correct_mark.setLayoutX(300);
        correct_mark.setLayoutY(48);
        grp.getChildren().addAll(l1,correct_mark);
        
        
        Label l2 = new Label("Score For Correct UnMark");
        l2.setLayoutX(80);
        l2.setLayoutY(100);
        l2.setFont(Font.font("Tahoma",FontWeight.BOLD,16));
        
       // l1.setStyle("-fx-text-fill: orange");
        TextField correct_unmark = new TextField();
        correct_unmark.setLayoutX(300);
        correct_unmark.setLayoutY(98);
        grp.getChildren().addAll(l2,correct_unmark);
        
        
        Label l3 = new Label("Score For Wrong Mark");
        l3.setLayoutX(80);
        l3.setLayoutY(150);
        l3.setFont(Font.font("Tahoma",FontWeight.BOLD,16));
       // l1.setStyle("-fx-text-fill: orange");
        TextField false_mark = new TextField();
        false_mark.setLayoutX(300);
        false_mark.setLayoutY(148);
        grp.getChildren().addAll(l3,false_mark);
        
        
        Label l4 = new Label("Score For Wrong UnMark");
        l4.setLayoutX(80);
        l4.setLayoutY(200);
        l4.setFont(Font.font("Tahoma",FontWeight.BOLD,16));
       // l1.setStyle("-fx-text-fill: orange");
        TextField false_unmark = new TextField();
        false_unmark.setLayoutX(300);
        false_unmark.setLayoutY(198);
        grp.getChildren().addAll(l4,false_unmark);
        
        Button finish = new Button("Next");
        finish.setLayoutX(220);
        finish.setLayoutY(250);
        finish.setPrefSize(150,30);
        //finish.setStyle("-fx-background-color: blue");
        grp.getChildren().addAll(finish);
        
        finish.setOnAction(e -> {
            boolean b = true;
            try {
                int x = Integer.parseInt(correct_mark.getText());
            } catch(Exception ex) {
                correct_mark.clear();
                b = false;
            }
            
            try {
                int x = Integer.parseInt(correct_unmark.getText());
            } catch(Exception ex) {
                correct_unmark.clear();
                b = false;
            }
            
            try {
                int x = Integer.parseInt(false_mark.getText());
            } catch(Exception ex) {
                false_mark.clear();
                b = false;
            }
            
            try {
                int x = Integer.parseInt(false_unmark.getText());
            } catch(Exception ex) {
                false_unmark.clear();
                b = false;
            }
            
            if(b) {
                Advance_option.correctMark = Integer.parseInt(correct_mark.getText());
                Advance_option.correctUnMark = Integer.parseInt(correct_unmark.getText());
                Advance_option.wrongMark = Integer.parseInt(false_mark.getText());
                Advance_option.wrongUnMark = Integer.parseInt(false_unmark.getText());                
                s1.close();
            }
        });
        
        Scene ss = new Scene(pane);
        pane.setCenter(grp);
        pane.setStyle("-fx-background-image: url('500_F_197433096_yB6QhglipwiDLp8QoWIhsMGrqzzZKQS8.jpg')");
        primaryStage.setScene(ss);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Advance Option");
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.show();
        s1 = primaryStage;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
