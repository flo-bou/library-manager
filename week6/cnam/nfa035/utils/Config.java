package cnam.nfa035.utils;

import cnam.nfa035.App;
import cnam.nfa035.log.Log;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class Config {

    public static Properties getProperties(){
        Properties props = new Properties();
        InputStream in = App.class.getResourceAsStream("config.properties");
        try {
            props.load(in);
            assert in != null;
            in.close();
        } catch (IOException ioE){
            Log.getInstance().addErrorLog("Chargement du fichier properties impossible : " + ioE.getMessage());
        } catch(NullPointerException npE){
            Log.getInstance().addErrorLog(npE.getMessage());
        }
        return props;
    }

    public static File getBooksDbFile(){
        File f = null;
        try {
            Path p = Paths.get("C:\\Users\\Admin\\Project\\NFA035\\week6\\cnam\\nfa035\\utils\\BooksDB.txt");
            f = new File(p.toString());
            if(f.isFile()){
                System.out.println("Le fichier existe");
            } else{
                System.out.println("Le fichier n'existe pas");
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return f;
    }
}
