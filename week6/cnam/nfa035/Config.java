package cnam.nfa035;

import cnam.nfa035.log.Log;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Properties;

public class Config {

    public static Properties getProperties(){
        Properties props = new Properties();
        try( InputStream in = Config.class.getResourceAsStream("config.properties") ){
            props.load(in);
        } catch (IOException ioE){
            Log.getInstance().addErrorLog("Chargement du fichier properties impossible : " + ioE.getMessage());
        } catch(NullPointerException npE){
            Log.getInstance().addErrorLog(npE.getMessage());
        }
        return props;
    }

    public static File getFile(Path p){
        File f = null;
        try {
            f = new File(p.toString());
            if(! f.isFile()){
                System.out.println("Le fichier n'existe pas");
//                f.createNewFile();
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return f;
    }

}
