package fxapplication;

import fuckmuhannad.Game;
import fuckmuhannad.SaveR;
import java.io.IOException;
import javafx.scene.control.Button;

public class Product {
    private String name;
    private int score;
    private int id;
    private Button replay;
    private int idReplay = -1;

    public Product(){
        this.name = "";
        this.score = 0;
        this.id = -1;
        this.replay = new Button("");
        this.idReplay = -1;
    }
    public Product(String name, int score,int id, Button replay ){
        this.name = name;
        this.score = score;
        this.id = id;
        this.replay = replay;
        idReplay = -1;
    }    
    public Product(String name, int score, int id, Button replay, int idReplay) {
        this.name = name;
        this.score = score;
        this.id = id;
        this.replay = replay;
        this.idReplay = idReplay;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getIdReplay() {
        return idReplay;
    }
    public void setIdReplay(int idReplay) {
        this.idReplay = idReplay;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public Button getReplay() {
        return replay;
    }
    public void setReplay(Button replay) {
        this.replay = replay;
    }
}

