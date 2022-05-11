package cnam.nfa035.bookDao;

import cnam.nfa035.Config;
import java.lang.reflect.*;

/*
* Factory Class to get a Data Access Object
* */
public abstract class FactoryBookDao {
    public static BookDaoInterface getDao(){
        String daoToUse = Config.getProperties().getProperty("dao");
        BookDaoInterface dao = null;
        Class<?> daoClass = null;
        Constructor<?> daoCon = null;
        System.out.println("dao to use : " + daoToUse);
        try {
            daoClass = Class.forName(daoToUse);
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } try {
            daoCon = daoClass.getConstructor(null);
        } catch (NoSuchMethodException e){
            e.printStackTrace();
        } try {
            dao = (cnam.nfa035.bookDao.BookDaoInterface) daoCon.newInstance();
            System.out.println("dao object : " + dao);
        } catch(InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return dao;
    }

}
