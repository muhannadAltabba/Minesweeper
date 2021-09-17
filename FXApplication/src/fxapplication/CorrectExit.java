package fxapplication;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CorrectExit {
    public static void display(Stage primaryStage) {
        Stage window = new Stage();
        
        BorderPane pane = new BorderPane();
        Group grp = new Group();
        pane.setStyle("-fx-background-color: rgb(214, 214, 194)");
        
        Button btn1 = new Button("Save");
        btn1.setLayoutX(80);
        btn1.setLayoutY(130);
        btn1.setPrefSize(120,30);

        Button btn2 = new Button("Don't Save");
            btn2.setLayoutX(210);
            btn2.setLayoutY(130);
            btn2.setPrefSize(120,30);
            btn2.setOnAction(e -> {
                System.exit(0);
            });

        Button btn3 = new Button("Cancel");
            btn3.setLayoutX(340);
            btn3.setLayoutY(130);
            btn3.setPrefSize(120,30);
            btn3.setOnAction(e -> {
            FXApplication c2 = new FXApplication();
            window.close();
            primaryStage.show();
        });

        Label l = new Label("What do you want to do with the game in progress?");
        l.setLayoutX(40);
        l.setLayoutY(60);
        l.setFont(Font.font("Tahoma",18));
        //l.setStyle("-fx-text-fill: red");
        
        grp.getChildren().addAll(btn1,btn2,btn3,l);
        
        
        pane.setCenter(grp);
        Scene ss = new Scene(pane);
       
        window.setScene(ss);
        window.setResizable(false);
        window.setTitle("Exit");
        window.setWidth(500);
        window.setHeight(200);
        window.showAndWait();
    } 
}
