package week4;

import java.time.LocalDate;
import java.util.ArrayList;

public class Log {
    private String messages;
    private ArrayList<String> messagesList;
    public static Log instance;

    private Log(){
        messages = "";
        messagesList = new ArrayList<>();
    }

    public static synchronized Log getInstance(){
        if (instance == null) {
            instance = new Log();
        }
        return instance;
    }


    public void addInfoLog(String message){
        this.messages = String.join("", this.messages, "INFO (", LocalDate.now().toString(), ") : ", message, "\n");
        this.messagesList.add("INFO (" + LocalDate.now().toString() + ") : " + message);
    }

    public void addErrorLog(String message){
        this.messages = String.join("", this.messages, "ERROR (", LocalDate.now().toString(), ") : ", message, "\n");
        this.messagesList.add("ERROR (" + LocalDate.now().toString() + ") : " + message);

    }

    public void addWarningLog(String message){
        this.messages = String.join("", this.messages, "WARNING (", LocalDate.now().toString(), ") : ", message, "\n");
        this.messagesList.add("WARNING (" + LocalDate.now().toString() + ") : " + message);
    }

    public ArrayList<String> getMessagesList(){
        return messagesList;
    }

    public String getMessages(){
        return messages;
    }

//    // get message of specified level of dangerosity
//    public String getMessages(T: level){
//        return messages;
//    }

    public String toString(){
        // from an ArrayList version of log
//        String strConcat = "";
//        for(String message : messagesList){
//            strConcat = String.join("", strConcat, message, "\n");
//        }
//        return strConcat;

        // from a String version of log
        return getMessages();
    }
}
