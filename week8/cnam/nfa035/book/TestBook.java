package cnam.nfa035.book;

public class TestBook {
    public static void test(Book livre){
        System.out.println(" ");
        System.out.println("Début des tests sur la classe Book : ");
        System.out.println("Le livre testé est : " + livre);
        System.out.println("Tentative d'emprunt du livre.");
        if(livre.emprunter()){
            System.out.println("Vous pouvez emprunter.");
        } else{
            System.out.println("Emprunt impossible. Pas de chance.");
        }

        int nb = -3;
        System.out.println("Ajout de " + nb + " exemplaires du livre livre.");
        livre.ajouter(-3);

        System.out.println("Restitution d'un exemplaire du livre.");
        livre.restituer();

        System.out.println("État du livre testé : " + livre);
        System.out.println("Fin des tests sur la classe Book.");
        System.out.println(" ");
    }
}
