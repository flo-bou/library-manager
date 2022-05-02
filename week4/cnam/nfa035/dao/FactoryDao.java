package cnam.nfa035.dao;

import cnam.nfa035.utils.Config;

import java.lang.reflect.*;

/*
* Factory Class to get a Data Access Object
* */
public abstract class FactoryDao{
    public static BookDaoInterface getDao(){
        String daoToUse = Config.getProperties().getProperty("dao");
        BookDaoInterface dao = null;
        Class<?> daoClass = null;
        Constructor<?> daoCon = null;
        System.out.println("dao to use : " + daoToUse);
        try {
            daoClass = Class.forName("cnam.nfa035.dao." + daoToUse);
            System.out.println("dao class : " + daoClass);
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } try {
            daoCon = daoClass.getConstructor(null);
            System.out.println("dao constructor : " + daoCon);
        } catch (NoSuchMethodException e){
            e.printStackTrace();
        } try {
            dao = (BookDaoInterface) daoCon.newInstance();
            System.out.println("dao object : " + dao);
        } catch(InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return dao;
    }

}
