package week4.dao;

/*
* Factory Class to get a Data Access Object
* */
public abstract class FactoryDao{
    public static BookDaoInterface getDao(){
        return new BookDaoImplnMemory();
    };
}
