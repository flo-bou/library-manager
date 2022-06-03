package cnam.nfa035.log;

import java.time.LocalDate;
import java.util.ArrayList;

public class Log {
    private String messages;
    private final ArrayList<String> messagesList;

    private Log(){
        this.messages = "";
        this.messagesList = new ArrayList<>();
    }

    private static class Holder{
        private final static Log instance = new Log();
    }

    public static Log getInstance(){
        return Holder.instance;
    }

    public void addInfoLog(String message){
        this.messages = String.join("", this.messages, LogLevel.INFO + " (", LocalDate.now().toString(), ") : ", message, "\n");
        this.messagesList.add(LogLevel.INFO + " (" + LocalDate.now() + ") : " + message);
    }

    public void addErrorLog(String message){
        this.messages = String.join("", this.messages, LogLevel.ERROR + " (", LocalDate.now().toString(), ") : ", message, "\n");
        this.messagesList.add(LogLevel.ERROR + " (" + LocalDate.now() + ") : " + message);
    }

    public void addWarningLog(String message){
        this.messages = String.join("", this.messages, LogLevel.WARNING + " (", LocalDate.now().toString(), ") : ", message, "\n");
        this.messagesList.add(LogLevel.WARNING + " (" + LocalDate.now() + ") : " + message);
    }

    public String getMessages(){
        return this.messages;
    }

    public String getMessages(LogLevel level){
        String result = "";
        for(String m : this.messagesList){
            if(m.startsWith(level.toString())){
                result = result.concat(m);
            }
        }
        return result;
    }

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
