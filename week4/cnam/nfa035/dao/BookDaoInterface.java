package cnam.nfa035.dao;

import java.util.List;
import cnam.nfa035.book.Book;
import cnam.nfa035.book.BookCategory;


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
