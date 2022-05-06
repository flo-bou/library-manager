package cnam.nfa035;

import cnam.nfa035.book.TestBook;
import cnam.nfa035.dao.FactoryDao;
import cnam.nfa035.dao.TestBookDao;
import cnam.nfa035.log.Log;
import cnam.nfa035.log.LogLevel;
import cnam.nfa035.utils.Config;
import cnam.nfa035.utils.DataService;

import java.util.Properties;

public class App {
    public static void main(String[] args) {
        Properties props = Config.getProperties();
        String daoToUSe = props.getProperty("dao");
        System.out.println("Le dao spécifié dans le fichier config est : " + daoToUSe);
//        TestBook.test(DataService.getLivre());
        TestBookDao.test(FactoryDao.getDao());
//        printLog();
    }

    public static void printLog(){
        System.out.println("Log de l'application : ");
        System.out.println(Log.getInstance().getMessages());
        System.out.println(Log.getInstance().getMessages(LogLevel.ERROR));
        System.out.println(" ");
    }

}
