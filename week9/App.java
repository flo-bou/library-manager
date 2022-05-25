import cnam.nfa035.ihm.BiblioFrame;
import cnam.nfa035.log.*;


public class App {
    public static void main(String[] args) {
        BiblioFrame fenetre = new BiblioFrame();
//        TestBook.test(DataService.getLivre());
//        try (BookDaoInterface dao = FactoryBookDao.getDao()){
//            TestBookDao.test(dao);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        printLog();
    }

    public static void printLog(){
        System.out.println("Log de l'application : ");
        System.out.println(Log.getInstance().getMessages());
        System.out.println(Log.getInstance().getMessages(LogLevel.ERROR));
        System.out.println(" ");
    }

}
