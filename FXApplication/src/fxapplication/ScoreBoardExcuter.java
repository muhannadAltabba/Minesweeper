package fxapplication;

import fuckmuhannad.Game;
import fuckmuhannad.SaveR;
import java.io.IOException;
import java.util.ArrayList;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ScoreBoardExcuter {
    TableView<Product> table;
    ArrayList<Product> list;

    public ScoreBoardExcuter() {
        list = new ArrayList<>();
    }

    public ArrayList<Product> getList() {
        return list;
    }

    public void setList(ArrayList<Product> list) {
        this.list = list;
    }
       
    public void start(Stage primaryStage) throws Exception {
        Stage window;
        window = primaryStage;
        TableColumn<Product,String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Product,Integer> scoreColumn = new TableColumn<>("Score");
        scoreColumn.setMinWidth(100);
        scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));

        TableColumn<Product,Integer> idColumn = new TableColumn<>("ID");
        idColumn.setMinWidth(200);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Product, Button> repColumn = new TableColumn<>("Replay");
        repColumn.setMinWidth(200);
        repColumn.setCellValueFactory(new PropertyValueFactory<>("replay"));

        table = new TableView<>();
        table.setItems(getProducts());
        table.getColumns().addAll(nameColumn,scoreColumn,idColumn,repColumn);
        
        for(int i = 0; i < list.size(); i++) {
            int idReplay = list.get(i).getIdReplay();
            
            if(idReplay != -1) {
                repColumn.getCellData(i).setOnAction(e -> {
                    window.close();
                    try {
                        SaveR saveR = new SaveR();
                        saveR.readToFile(idReplay);
                        Game game = saveR.getGame();

                        (new ReplayFace()).start(game);                    
                    } catch (IOException ex) {} catch (ClassNotFoundException ex) {}
                });
            }
        }

        VBox vbox = new VBox();
        vbox.getChildren().addAll(table);
        Scene scene = new Scene(vbox);
        scene.getStylesheets().add("style.css");
        window.setScene(scene);
        window.show();
    }

    public ObservableList<Product> getProducts(){
        ObservableList<Product> products = FXCollections.observableArrayList();

        for(Product product : list)
            products.add(product);

        return products;
    }

    public ArrayList<Product> toArrayList(ObservableList<Product> obs) {
        ArrayList<Product> arr = new ArrayList<>();

        for(Product product : obs)
            arr.add(product);

        return arr;
    }
}
