package fuckmuhannad;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaveBoard {
    private PlayerBoard player;
    
    public SaveBoard(PlayerBoard player) {this.player = player;}
    public SaveBoard() {}
    
    public PlayerBoard getPlayerBoard() {return player;}
    public void setPlayerBoard(PlayerBoard player) {this.player = player;}
    
    public int getNextFile() {
        int last = 1;
        
        while(checkFile(last))
            last++;
        
        return last;
    }
    
    public void writeToFile(PlayerBoard player, int fileNum) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Board" + Integer.toString(fileNum) + ".bin"));
        objectOutputStream.writeObject(player);
    }

    public void readToFile(int fileNum) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Board" + Integer.toString(fileNum) + ".bin"));
        PlayerBoard p = (PlayerBoard)objectInputStream.readObject();
        player = p;
    }
    
    public boolean checkFile(int fileNum) {
        try {ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Board" + Integer.toString(fileNum) + ".bin"));}
        catch (IOException ex) {return false;}
        return true;
    }
}
