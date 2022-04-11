package week3;

public class App {
    public static void main(String[] args) {
        LivreDaoInterface dao = FactoryDao.getDao();
        System.out.println(dao.getLivres());

        System.out.println("Log de l'application : ");
        System.out.println(Journal.getInstance());
    }

    public static void testLivre(Livre livre){
        if(livre.emprunter()){
            System.out.println("Vous pouvez emprunter.");
        } else{
            System.out.println("Emprunt impossible. Pas de chance.");
        }
        livre.ajouter(-3);
        livre.restituer();

        System.out.println("État du livre à la fin des tests :" + livre);
    }
}
