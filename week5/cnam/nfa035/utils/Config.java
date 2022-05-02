package cnam.nfa035.utils;

import cnam.nfa035.App;
import cnam.nfa035.log.Log;

import java.io.IOException;
import java.io.InputStream;
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
}
