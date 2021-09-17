package fuckmuhannad;

import java.io.Serializable;

public class PlayerBoard implements Serializable {
    String name;
    int idReplay;
    int score;
    int id;

    public PlayerBoard(String name, int idReplay, int score, int id) {
        this.name = name;
        this.idReplay = idReplay;
        this.score = score;
        this.id = id;
    }
    public PlayerBoard() {
        name = "Zaher";
        idReplay = -1;
        id = -1;
        score = 0;
    }
    public PlayerBoard(String name, int score, int id) {
        this.name = name;
        this.score = score;
        this.id = id;
    }
    public PlayerBoard(String name, int id) {
        this.name = name;
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
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
