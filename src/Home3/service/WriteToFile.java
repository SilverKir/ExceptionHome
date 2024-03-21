package Home3.service;

import Home3.model.Human;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
    public void writeToFile(Human human){
        String fileName= human.getLastName()+".txt";
        try (FileWriter fileWriter=new FileWriter(fileName,true);){
            fileWriter.write(human.toString()+"\n");
            fileWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
