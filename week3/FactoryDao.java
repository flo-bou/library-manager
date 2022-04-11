package week3;

/*
* Factory Class to get a Data Access Object
* */
public abstract class FactoryDao{
    static LivreDaoInterface getDao(){
        return new LivreDaoInMemory();
    };
}
