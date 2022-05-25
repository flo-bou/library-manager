package cnam.nfa035.bookDao;

import cnam.nfa035.DataService;
import cnam.nfa035.book.Book;
import cnam.nfa035.book.BookCategory;
import java.util.List;

/*
 * Class to test BookDao currently in usage
 **/
public class TestBookDao {
    public static void test(BookDaoInterface dao){
        System.out.println(" ");
        System.out.println("Début des tests sur la classe BookDao en cours d'utilisation :");

        System.out.println("Affichage des livres en stock :");
        System.out.println(dao.getLivres());
        System.out.println(" ");

        Book livreCaptaine = DataService.getLivre();
        if(dao.ajouterLivre(livreCaptaine)){
            System.out.println("Le livre « " + livreCaptaine.getTitre() + " » a été ajouté.");
        } else{
            System.out.println("Le livre « " + livreCaptaine.getTitre() + " » n'a pas pu être ajouté.");
        }


        List<Book> listRomans = dao.getLivreParCategorie(BookCategory.ROMAN);
        System.out.println("Affichage des livres de type Roman :");
        System.out.println(listRomans);
        System.out.println(" ");

        Book livreCorrige = dao.getLivreParIsbn("4723974");
        livreCorrige.setTitre("La petite Maison dans la prairie 2 : Le retour");
        if(dao.modifierLivre(livreCorrige)){
            System.out.println("Le livre à l'isbn « " + livreCorrige.getIsbn() + " » a été modifié.");
        }else{
            System.out.println("Le livre à l'isbn « " + livreCorrige.getIsbn() + " » n'a pas pu été modifié correctement.");
        }
        System.out.println(" ");


        String isbnLivreToDelete = "432483023";
        if(dao.suprimerLivre(isbnLivreToDelete)){
            System.out.println("Suppression du livre « " + isbnLivreToDelete + " » effectuée.");
        } else{
            System.out.println("La suppression du livre « " + isbnLivreToDelete + " » a échouée.");
        }
        System.out.println(" ");

        System.out.println("Affichage des livres en stock :");
        System.out.println(dao.getLivres());
        System.out.println(" ");

        System.out.println("Fin des tests sur la classe BookDao en cours d'utilisation ");
        System.out.println(" ");
    }
}
