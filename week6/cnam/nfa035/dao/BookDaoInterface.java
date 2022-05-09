package cnam.nfa035.dao;

import cnam.nfa035.book.Book;
import cnam.nfa035.book.BookCategory;

import java.util.List;


public interface BookDaoInterface extends AutoCloseable {
    String getLivres();
    Book getLivreParIsbn(String isbn);
    List<Book> getLivreParCategorie(BookCategory categorie);
    List<Book> getLivreParTitre(String titre);
    boolean ajouterLivre(Book livre);
    boolean modifierLivre(Book livre);
    boolean modifierLivre(String isbn, int quantite);
    boolean suprimerLivre(String isbn);
}
