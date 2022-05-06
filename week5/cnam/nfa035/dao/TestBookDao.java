package cnam.nfa035.dao;

import cnam.nfa035.book.Book;
import cnam.nfa035.book.BookCategory;

import java.time.LocalDate;
import java.util.List;

/*
 * Class to test BookDao currently in usage
 **/
public class TestBookDao {
    public static void test(BookDaoInterface dao){
        System.out.println("Début des tests sur la classe BookDao en cours d'utilisation :");

        System.out.println("Affichage des livres en stock :");
        System.out.println(dao.getLivres());
        System.out.println(" ");

        Book livreCaptaine = new Book("482492384", "Le Capitaine Fracasse", BookCategory.ROMAN, 19.9f, 2, LocalDate.of(1892, 7, 10));
        if(dao.ajouterLivre(livreCaptaine)){
            System.out.println("Le livre « " + livreCaptaine.getTitre() + " » a été ajouté.");
        } else{
            System.out.println("Le livre « " + livreCaptaine.getTitre() + " » n'a pas pu être ajouté.");
        }

        System.out.println("Affichage des livres en stock :");
        System.out.println(dao.getLivres());
        System.out.println(" ");

        List<Book> listRomans = dao.getLivreParCategorie(BookCategory.ROMAN);
        System.out.println("Affichage des livres de type Roman :");
        System.out.println(listRomans);

        Book livreCorrige = new Book("4723974", "La petite Maison dans la prairie 2 : Le retour", BookCategory.ROMAN, 19.9f, 3,
                LocalDate.of(1946, 5, 2));
        if(dao.modifierLivre(livreCorrige)){
            System.out.println("Le livre à l'isbn « " + livreCorrige.getIsbn() + " » a été modifié.");
        }else{
            System.out.println("Le livre à l'isbn « " + livreCorrige.getIsbn() + " » n'a pas pu été modifié correctement.");
        }

        System.out.println("Affichage des livres en stock :");
        System.out.println(dao.getLivres());
        System.out.println(" ");

        String isbnLivreToDelete = "432483023";
        if(dao.suprimerLivre(isbnLivreToDelete)){
            System.out.println("Suppression du livre « " + isbnLivreToDelete + " » effectuée.");
        } else{
            System.out.println("La suppression du livre « " + isbnLivreToDelete + " » a échouée.");
        }

        System.out.println("Affichage des livres en stock :");
        System.out.println(dao.getLivres());
        System.out.println(" ");

        System.out.println("Fin des tests sur la classe BookDao en cours d'utilisation ");
        System.out.println(" ");
    }
}
