package fxapplication;

import fuckmuhannad.FlyingShield;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class second {
    Stage s2;
    public void start(Stage stage) {
        Face.endThread = true;
        FlyingShield.stopMoving = true;
        
        Group op = new Group();
        
        //op.setStyle("-fx-background-color: green");
        
        
        Label l5 = new Label("Grid Size");
        l5.setLayoutX(85);
        l5.setLayoutY(70);
        l5.setFont(Font.font("Tahoma",FontWeight.BOLD,18));
        //l5.setStyle("-fx-text-fill: orange");
        
        
        Label l2 = new Label("Grid Height");
        l2.setLayoutX(20);
        l2.setLayoutY(120);
        l2.setFont(Font.font("Tahoma",FontWeight.BOLD,16));
       // l2.setStyle("-fx-text-fill: orange");
        TextField grid_hight = new TextField();
        grid_hight.setLayoutX(130);
        grid_hight.setLayoutY(118);       
        grid_hight.setPrefSize(100,30);

        
        Label l3 = new Label("Grid Width");
        l3.setLayoutX(20);
        l3.setLayoutY(160);
        l3.setFont(Font.font("Tahoma",FontWeight.BOLD,16));
        //l3.setStyle("-fx-text-fill: orange");
        TextField grid_width = new TextField();
        grid_width.setLayoutX(130);
        grid_width.setLayoutY(158);
        grid_width.setPrefSize(100,30);

        Label l4 = new Label("Count Mine");
        l4.setLayoutX(20);
        l4.setLayoutY(200);
        l4.setFont(Font.font("Tahoma",FontWeight.BOLD,16));
        //l4.setStyle("-fx-text-fill: orange");
        TextField count_mine = new TextField();
        count_mine.setLayoutX(130);
        count_mine.setLayoutY(198);
        count_mine.setPrefSize(100,30);
        
        Label l20 = new Label("Shield");
        l20.setLayoutX(340);
        l20.setLayoutY(70);
        l20.setFont(Font.font("Tahoma",FontWeight.BOLD,18));
        l20.setStyle("-fx-text-fill: orange");
        op.getChildren().add(l20);
        
        Label l15 = new Label("Flying Shield");
        l15.setLayoutX(270);
        l15.setLayoutY(120);
        l15.setFont(Font.font("Tahoma",FontWeight.BOLD,16));
        l15.setStyle("-fx-text-fill: orange");
        TextField move_shield = new TextField();
        move_shield.setLayoutX(380);
        move_shield.setLayoutY(118);
        move_shield.setPrefSize(100,30);
        
        Label l21 = new Label("Player Shield");
        l21.setLayoutX(270);
        l21.setLayoutY(160);
        l21.setFont(Font.font("Tahoma",FontWeight.BOLD,16));
        l21.setStyle("-fx-text-fill: orange");
        TextField player_shield  = new TextField();
        player_shield.setLayoutX(380);
        player_shield.setLayoutY(158);
        player_shield.setPrefSize(100,30);
        op.getChildren().addAll(l21,player_shield);
        
        Label l22 = new Label("Normal Shield");
        l22.setLayoutX(270);
        l22.setLayoutY(200);
        l22.setFont(Font.font("Tahoma",FontWeight.BOLD,16));
        l22.setStyle("-fx-text-fill: orange");
        TextField grid_shield  = new TextField();
        grid_shield.setLayoutX(380);
        grid_shield.setLayoutY(198);
        grid_shield.setPrefSize(100,30);
        op.getChildren().addAll(l22,grid_shield);
        
        Label l6 = new Label("Player Count");
        l6.setLayoutX(185);
        l6.setLayoutY(270);
        l6.setFont(Font.font("Tahoma",FontWeight.BOLD,18));
        l6.setStyle("-fx-text-fill: orange");
        
        Label l7 = new Label("Count Real Player");
        l7.setStyle("-fx-text-fill: orange");
        l7.setLayoutX(100);
        l7.setLayoutY(320);
        l7.setFont(Font.font("Tahoma",16));
        TextField count_real_player = new TextField();
        count_real_player.setLayoutX(300);
        count_real_player.setLayoutY(318);
        
        Label l8 = new Label("Count Auto Easy Player");
        l8.setLayoutX(80);
        l8.setLayoutY(360);
        l8.setFont(Font.font("Tahoma",16));
        l8.setStyle("-fx-text-fill: orange");
        TextField count_easy_player = new TextField();
        count_easy_player.setLayoutX(300);
        count_easy_player.setLayoutY(358);
        
        
        Label l9 = new Label("Count Auto hard Player");
        l9.setStyle("-fx-text-fill: orange");
        l9.setLayoutX(80);
        l9.setLayoutY(400);
        l9.setFont(Font.font("Tahoma",16));
        TextField count_hard_player = new TextField();
        count_hard_player.setLayoutX(300);
        count_hard_player.setLayoutY(398);
        
        Button start = new Button("Next");
        start.setStyle("-fx-text-fill: Black");
        start.setLayoutX(335);
        start.setLayoutY(460);
        start.setPrefSize(150,30);
        start.setOnAction(e -> {
            boolean b = true;

            try {
                if(grid_hight.getText().equals(""))
                    throw new Exception();
                int x = Integer.parseInt(grid_hight.getText());
                if(x > 20) {
                    x = 20;
                    grid_hight.setText(Integer.toString(x));
                    throw new Exception();
                }
                if(x < 3) {
                    x = 3;
                    grid_hight.setText(Integer.toString(x));
                    throw new Exception();
                }
            } catch(Exception ex) {
                grid_hight.clear();
                b = false;
            }
            
            try {
                if(grid_width.getText().equals(""))
                    throw new Exception();
                int x = Integer.parseInt(grid_width.getText());
                if(x > 20) {
                    x = 20;
                    grid_width.setText(Integer.toString(x));
                    throw new Exception();
                }
                if(x < 3) {
                    x = 3;
                    grid_width.setText(Integer.toString(x));
                    throw new Exception();
                }
            } catch(Exception ex) {
                grid_width.clear();
                b = false;
            }
            
           try {
                if(count_mine.getText().equals(""))
                    throw new Exception();
                int x = Integer.parseInt(count_mine.getText());
                int n = Integer.parseInt(grid_width.getText());
                int m = Integer.parseInt(grid_hight.getText());
                
                int k = n * m / 3;
                
                if(x > k) {
                    x = k;
                    count_mine.setText(Integer.toString(x));
                    throw new Exception();
                }
                if(x < 3) {
                    x = 3;
                    count_mine.setText(Integer.toString(x));
                    throw new Exception();
                }
            } catch(Exception ex) {
                count_mine.clear();
                b = false;
            }
            try {
                if(count_real_player.getText().equals(""))
                    throw new Exception();
                int x = Integer.parseInt(count_real_player.getText());
                if(x > 7) {
                    x = 7;
                    count_real_player.setText(Integer.toString(x));
                    throw new Exception();
                }
                if(x < 1) {
                    x = 1;
                    count_real_player.setText(Integer.toString(x));
                    throw new Exception();
                }
            } catch(Exception ex) {
                count_real_player.clear();
                b = false;
            }
            
            try {
                if(count_easy_player.getText().equals(""))
                    throw new Exception();
                int x = Integer.parseInt(count_easy_player.getText());
                if(x > 7) {
                    x = 7;
                    count_easy_player.setText(Integer.toString(x));
                    throw new Exception();
                }
                if(x < 0) {
                    x = 0;
                    count_easy_player.setText(Integer.toString(x));
                    throw new Exception();
                }
            } catch(Exception ex) {
                count_easy_player.clear();
                b = false;
            }
            try {
                if(count_hard_player.getText().equals(""))
                    throw new Exception();
                int x = Integer.parseInt(count_hard_player.getText());
                if(x > 7) {
                    x = 7;
                    count_hard_player.setText(Integer.toString(x));
                    throw new Exception();
                }
                if(x < 0) {
                    x = 0;
                    count_hard_player.setText(Integer.toString(x));
                    throw new Exception();
                }
            } catch(Exception ex) {
                count_hard_player.clear();
                b = false;
            }
                    

            try {
                if(player_shield.getText().equals(""))
                    throw new Exception();
                int x7 = Integer.parseInt(player_shield.getText());
               if(x7 < 0) {
                    x7 = 0;
                    count_easy_player.setText(Integer.toString(x7));
                    throw new Exception();
                }
            } catch(Exception ex) {
                player_shield.clear();
                b = false;
            }
            
            try {
                if(grid_shield.getText().equals(""))
                    throw new Exception();
                int x8 = Integer.parseInt(grid_shield.getText());
               if(x8 < 0) {
                    x8 = 0;
                    count_easy_player.setText(Integer.toString(x8));
                    throw new Exception();
                }
            } catch(Exception ex) {
                grid_shield.clear();
                b = false;
            }
            
            try {
                if(move_shield.getText().equals(""))
                    throw new Exception();
                int x9 = Integer.parseInt(move_shield.getText());
               if(x9 < 0) {
                    x9 = 0;
                    count_easy_player.setText(Integer.toString(x9));
                    throw new Exception();
                }
            } catch(Exception ex) {
                move_shield.clear();
                b = false;
            }
            
            
            if(b) {
                int x1 = Integer.parseInt(grid_hight.getText());
                int x2 = Integer.parseInt(grid_width.getText());
                int x3 = Integer.parseInt(count_mine.getText());
                int x4 = Integer.parseInt(count_real_player.getText());
                int x5 = Integer.parseInt(count_easy_player.getText());
                int x6 = Integer.parseInt(count_hard_player.getText());
                int x7 = Integer.parseInt(player_shield.getText());
                int x8 = Integer.parseInt(grid_shield.getText());
                int x9 = Integer.parseInt(move_shield.getText());

                boolean t = true;
                if(x7 + x8 + x9 > (x1*x2)-x3) {
                    move_shield.clear();
                    grid_shield.clear();
                    player_shield.clear();
                    t = false;
                }
                
                if(x4 + x5 + x6 > 7) {
                    count_hard_player.clear();
                    count_easy_player.clear();
                    count_real_player.clear();            
                    t = false;
                }
                if(t) {
                    ThirdGui c3 = new ThirdGui();        
                    c3.get_from_secound_page(x1,x2,x3,x4,x5,x6,x7,x8,x9);
                    c3.start(new Stage());
                    s2.close();
                }
                
            }        
        });
        Button advance = new Button("Advanced Option");
        advance.setStyle("-fx-text-fill: Black");
        advance.setLayoutX(35);
        advance.setLayoutY(460);
        advance.setPrefSize(150,30);
        advance.setOnAction(e -> {
        Advance_option c3 = new Advance_option();        
        c3.start(new Stage()); 
       
        });
        op.getChildren().addAll(l2,grid_hight,l3,grid_width,l4,count_mine,l5,l6,l7,count_real_player,l8,count_easy_player,l9,count_hard_player,start,advance,l15,move_shield);
        
        
        BorderPane pane = new BorderPane();
        pane.setStyle("-fx-background-image: url('unnamed.png')");
        
  //      pane.setBackground(new Background(new BackgroundImage(new Image("unnamed.png", 768, 432, false, true),
  //      BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
//        BackgroundSize.DEFAULT)));
        
//        pane.setStyle("-fx-opacity: 0.5");
        
        pane.setCenter(op);
            
        Scene secound_page = new Scene(pane);
        
        stage.setScene(secound_page);
        
        stage.setTitle("Option");
        stage.setResizable(false);
        
        stage.setWidth(500);
        stage.setHeight(500);
        stage.show();
        
        s2 = stage;
        
}



//    public void handle(ActionEvent event) {
//        ThirdGui c3 = new ThirdGui();        
//        s2.close();
//        c3.start(new Stage()); 
//        
//    }

}
