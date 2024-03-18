package hello;

import java.io.FileWriter;

public class Util {
    void salvaFileTesto (String nomeFile, String testoFile){
        try {
            FileWriter fw = new FileWriter(nomeFile + ".csv");
            fw.write(testoFile);
            fw.close();
        } catch (Exception Err) {
            System.out.println("impossibile creare il file");
        }
    }
    
}
