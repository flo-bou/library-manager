package week3;

import java.time.LocalDate;
import java.util.List;

public class App {
    public static void main(String[] args) {
        LivreDaoInterface dao = FactoryDao.getDao();
        System.out.println("Affichage des livres en stock :");
        System.out.println(dao.getLivres());

        Livre livreCaptaine = new Livre("482492384", "Le Capitaine Fracasse", TCategorie.ROMAN, 19.9f, 2, LocalDate.of(1892, 7, 10));
        if(dao.ajouterLivre(livreCaptaine)){
            System.out.println("Le livre « Le Capitaine Fracasse » a été ajouté.");
        } else{
            System.out.println("Le livre « Le Capitaine Fracasse » n'a pas pu être ajouté.");
        }

        System.out.println("Affichage des livres en stock :");
        System.out.println(dao.getLivres());

        List<Livre> listRomans = dao.getLivreParCategorie(TCategorie.ROMAN);
        System.out.println("Affichage des livres de type Roman :");
        System.out.println(listRomans);

        Livre livreCorrige = new Livre("4723974", "La petite Maison dans la prairie 2 : Le retour", TCategorie.ROMAN, 19.9f, 3,
                LocalDate.of(1946, 5, 2));
        if(dao.modifierLivre(livreCorrige)){
            System.out.println("Le livre à l'isbn « 4723974 » a été modifié.");
        }else{
            System.out.println("Le livre à l'isbn « 4723974 » n'a pas pu été modifié correctement.");
        }

        System.out.println("Affichage des livres en stock :");
        System.out.println(dao.getLivres());

        String isbnLivreToDelete = "432483023";
        if(dao.suprimerLivre(isbnLivreToDelete)){
            System.out.println("Suppression du livre « " + isbnLivreToDelete + " » effectuée.");
        } else{
            System.out.println("La suppression du livre « " + isbnLivreToDelete + " » a échouée.");
        }

        System.out.println("Affichage des livres en stock :");
        System.out.println(dao.getLivres());

        System.out.println("----------------------------------------------");
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
