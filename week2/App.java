package week2;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Livre livre1 = new Livre("432483023", "Spirou", TCategorie.BD, 9.99f, 0, LocalDate.of(1992, 7, 12));
        testLivre(livre1);

        Livre livre2 = new Livre("4324834523", "Fables", TCategorie.ROMAN, -12f, 2, LocalDate.of(1792, 2, 23));
        testLivre(livre2);

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
