package fxapplication;


import java.util.ArrayList;
import javafx.application.Application;
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
import javafx.scene.image.ImageView;
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

public class ThirdGui extends Application{
    public static int player_count,grid_hight,grid_width,count_mine,count_easy_player,count_hard_player,player_shield,grid_shield,move_shield;
    public static ArrayList<String> playerList = new ArrayList<>();
    
    public ThirdGui() {ThirdGui.playerList.clear(); ThirdGui.playerList.add("Zaher");}
    public ThirdGui(boolean x) {
        ThirdGui.player_count = 1;
        ThirdGui.grid_hight = 8;
        ThirdGui.grid_width = 8;
        ThirdGui.count_mine = 8;
        ThirdGui.count_easy_player = 0;
        ThirdGui.count_hard_player = 0;
        ThirdGui.player_shield = 0;
        ThirdGui.grid_shield = 0;
        ThirdGui.move_shield = 0;
        ThirdGui.playerList.clear();
        ThirdGui.playerList.add("Zaher");
    }

    void get_from_secound_page(int grid_hight,int grid_width,int count_mine,int player_count,int count_easy_player,int count_hard_player,int player_shield,int grid_shield,int move_shield) {
        ThirdGui.player_count = player_count;
        ThirdGui.grid_hight = grid_hight;
        ThirdGui.grid_width = grid_width;
        ThirdGui.count_mine = count_mine;
        ThirdGui.count_easy_player = count_easy_player;
        ThirdGui.count_hard_player = count_hard_player;
        ThirdGui.player_shield = player_shield;
        ThirdGui.grid_shield = grid_shield;
        ThirdGui.move_shield = move_shield;
        ThirdGui.playerList.clear();
    }
    
    
    
    Stage s3;
    
    @Override
    public void start(Stage stage) {
        Group player_op = new Group();
        BorderPane pane = new BorderPane();
        pane.setStyle("-fx-background-image: url('CC.jpg')");
        
        Label l10 = new Label("Player Option");
        l10.setLayoutX(165);
        l10.setLayoutY(70);
        l10.setStyle("-fx-text-fill: white");
        
        l10.setFont(Font.font("Tahoma",FontWeight.BOLD,18));

        ThirdGui.playerList.clear();
        int tot = ThirdGui.player_count + ThirdGui.count_easy_player + ThirdGui.count_hard_player;
        
        ArrayList<TextField> list = new ArrayList<>();
         for(int i = 0; i < tot; i++){
            Label l = new Label("Player " + (i+1) + " name");
            l.setLayoutX(5);
            l.setLayoutY(110 + (40*i));
            l.setFont(Font.font("Tahoma",16));
            l.setStyle("-fx-text-fill: white");
            TextField player_name = new TextField();
            player_name.setLayoutX(110);
            player_name.setLayoutY(108 + (40*i));
            list.add(player_name);
            
            Label label_color = new Label("Color");
            label_color.setLayoutX(320);
            label_color.setLayoutY(110 + (40*i));
            label_color.setFont(Font.font("Tahoma",16));
            label_color.setStyle("-fx-text-fill: white");
        
            ComboBox player_color = new ComboBox();
            player_color.getItems().addAll("Red", "Green", "Blue", "Black", "White", "Grey", "Pink", "Cyan", "Purple","Yellow");
            player_color.setLayoutX(360);
            player_color.setLayoutY(108 + (40*i));
           
            player_op.getChildren().addAll(l,player_name,label_color,player_color);            
        }
        
        Button go = new Button("Start");
        go.setLayoutX(165);
        go.setLayoutY(398);
        go.setPrefSize(150,30);
        
        go.setOnAction(e -> {
            FXApplication c1 = new FXApplication();
            
            int tott = list.size();
            for(int i = 0; i < tott; i++)
                playerList.add(list.get(i).getText());

            s3.close();
            c1.start(new Stage());
        });
        
        player_op.getChildren().addAll(l10, go);

        pane.setCenter(player_op);
        
        Scene third_page = new Scene(pane);
        stage.setScene(third_page);
        stage.setTitle("Player Option");
        stage.setResizable(false);
        stage.setWidth(500);
        stage.setHeight(500);
        stage.show();
        
        s3 = stage;
    }
}
  
  
    

