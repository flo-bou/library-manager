package cnam.nfa035.utils;

import cnam.nfa035.book.Book;
import cnam.nfa035.book.BookCategory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class DataService {
    // Cette méthode crée un livre
    public static Book getLivre(){
        return new Book("482492384", "Le Capitaine Fracasse", BookCategory.ROMAN, 19.9f, 2, LocalDate.of(1892, 7, 10));
    }

    // Cette méthode crée une liste de livres
    public static List<Book> getLivres(){
        List<Book> listeLivres = new ArrayList<>();
        listeLivres.add(new Book("4723974", "La petite Maison dans la prairie", BookCategory.ROMAN, 19.9f, 3,
                LocalDate.of(1945, 5, 2)));
        listeLivres.add(new Book("4324834523", "Fables", BookCategory.ROMAN, -12f, 2, LocalDate.of(1792, 2, 23)));
        listeLivres.add(new Book("432483023", "Spirou", BookCategory.BD, 9.99f, 0, LocalDate.of(1992, 7, 12)));

        return listeLivres;
    }

}
