package ataberkkilavuzcu;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveTextFile {

    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    
    public SaveTextFile(String nameFile, String text){
        createTxtFile(nameFile);
        writeTxtFile(text);

    }
    public void createTxtFile(String nameFile){
            try {
                fileWriter = new FileWriter("seleniumproject/articles/"+nameFile);
            } catch (IOException e) {
                e.printStackTrace();
            }

    }
    public void writeTxtFile(String text){     
        try {
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    
}
