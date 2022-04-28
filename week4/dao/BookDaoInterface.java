package week4.dao;

import java.util.List;
import week4.Book;
import week4.BookCategory;


public interface BookDaoInterface {
    String getLivres();
    Book getLivreParIsbn(String isbn);
    List<Book> getLivreParCategorie(BookCategory categorie);
    List<Book> getLivreParTitre(String titre);
    boolean ajouterLivre(Book livre);
    boolean modifierLivre(Book livre);
    boolean modifierLivre(String isbn, int quantite);
    boolean suprimerLivre(String isbn);
}
