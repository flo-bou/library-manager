import cnam.nfa035.bookDao.BookDaoInterface;
import cnam.nfa035.bookDao.FactoryBookDao;
import cnam.nfa035.bookDao.TestBookDao;
import cnam.nfa035.ihm.SearchFrame;
import cnam.nfa035.log.*;


public class App {
    public static void main(String[] args) {
        SearchFrame searchF = new SearchFrame();
//        TestBook.test(DataService.getLivre());
        try (BookDaoInterface dao = FactoryBookDao.getDao()){
//            TestBookDao.test(dao);
            System.out.println(dao.getLivres());
            searchF.setBookDao(dao);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        printLog();
    }

    public static void printLog(){
        System.out.println("Log de l'application : ");
        System.out.println(Log.getInstance().getMessages());
        System.out.println(Log.getInstance().getMessages(LogLevel.ERROR));
        System.out.println(" ");
    }

}
