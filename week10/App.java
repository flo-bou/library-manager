import cnam.nfa035.bookDao.BookDaoInterface;
import cnam.nfa035.bookDao.FactoryBookDao;
import cnam.nfa035.ihm.BiblioGui;
import cnam.nfa035.log.*;


public class App {
    public static void main(String[] args) {
        try (BookDaoInterface dao = FactoryBookDao.getDao()){
//            TestBookDao.test(dao);
            System.out.println(dao.getLivres());
            BiblioGui gui = new BiblioGui(dao);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printLog(){
        System.out.println("Log de l'application : ");
        System.out.println(Log.getInstance().getMessages());
        System.out.println(Log.getInstance().getMessages(LogLevel.ERROR));
        System.out.println(" ");
    }

}
