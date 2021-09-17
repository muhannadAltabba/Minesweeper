package fuckmuhannad;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Save implements Serializable {
    private Game game;
    
    public Save(Game game) {this.game = game;}
    public Save() {}
    
    public Game getGame() {return game;}
    public void setGame(Game game) {this.game = game;}
    
    public int getNextFile() {
        int last = 1;
        
        while(checkFile(last))
            last++;
        
        return last;
    }
    
//    public void writeToFile(Game game) throws IOException {
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Game1.bin"));
//        objectOutputStream.writeObject(game);
//    }
    
    public void writeToFile(Game game, int fileNum) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Game" + Integer.toString(fileNum) + ".bin"));
        objectOutputStream.writeObject(game);
    }

    public void readToFile(int fileNum) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Game" + Integer.toString(fileNum) + ".bin"));
        Game p = (Game)objectInputStream.readObject();
        game = p;
    }
    
    public boolean checkFile(int fileNum) {
        try {ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Game" + Integer.toString(fileNum) + ".bin"));}
        catch (IOException ex) {return false;}
        return true;
    }    
}