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

        testAjouterLivre(dao, DataService.getLivre());
        testGetLivreParTitre(dao, "La petite");
        testGetLivreParCategorie(dao, BookCategory.ROMAN);
        testGetLivreParIsbn(dao, "4723974");
        testModifierLivre(dao, dao.getLivreParIsbn("4723974"));
        testSupprimerLivre(dao, "432483023");

        System.out.println("Affichage des livres en stock :");
        System.out.println(dao.getLivres());
        System.out.println(" ");

        System.out.println("Fin des tests sur la classe BookDao en cours d'utilisation ");
        System.out.println(" ");
    }

    public static void testGetLivreParTitre(BookDaoInterface dao, String titre){
        List<Book> books = dao.getLivreParTitre(titre);
        System.out.println("Affichage des livres dont les titres contiennent " + titre + " :");
        for(Book b : books){
            System.out.println(b);
        }
        System.out.println(" ");
    }

    public static void testGetLivreParIsbn(BookDaoInterface dao, String isbn){
        Book book = dao.getLivreParIsbn(isbn);
        System.out.println("Affichage du livre à l'isbn " + isbn);
        System.out.println(book);
        System.out.println(" ");
    }

    public static void testGetLivreParCategorie(BookDaoInterface dao, BookCategory category){
        List<Book> books = dao.getLivreParCategorie(category);
        System.out.println("Affichage des livres de la catégorie " + category + " :");
        for(Book b : books){
            System.out.println(b);
        }
        System.out.println(" ");
    }

    public static void testAjouterLivre(BookDaoInterface dao, Book book) {
        if (dao.ajouterLivre(book)) {
            System.out.println("Le livre « " + book.getTitre() + " » a été ajouté.");
        } else {
            System.out.println("Le livre « " + book.getTitre() + " » n'a pas pu être ajouté.");
        }
        System.out.println(" ");
    }

    public static void testModifierLivre(BookDaoInterface dao, Book book) {
        book.setTitre("La petite Maison dans la prairie 2 : Le retour");
        if(dao.modifierLivre(book)){
            System.out.println("Le livre à l'isbn « " + book.getIsbn() + " » a été modifié.");
        }else{
            System.out.println("Le livre à l'isbn « " + book.getIsbn() + " » n'a pas été modifié correctement.");
        }
        System.out.println(" ");
    }

        public static void testSupprimerLivre(BookDaoInterface dao, String isbn){
        if(dao.suprimerLivre(isbn)){
            System.out.println("Suppression du livre « " + isbn + " » effectuée.");
        } else{
            System.out.println("La suppression du livre « " + isbn + " » a échouée.");
        }
        System.out.println(" ");
    }

}
