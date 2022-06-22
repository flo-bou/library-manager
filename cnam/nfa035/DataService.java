package cnam.nfa035;

import cnam.nfa035.book.Book;
import cnam.nfa035.book.BookCategory;

import java.util.ArrayList;
import java.util.List;


public class DataService {
    // Cette méthode crée un livre
    public static Book getLivre(){
        return new Book(
                "482492384",
                "Le Capitaine Fracasse",
                BookCategory.ROMAN,
                19.9f,
                2,
                "1892-07-10"
        );
    }

    // Cette méthode crée une liste de livres
    public static List<Book> getLivres(){
        List<Book> listeLivres = new ArrayList<>();
        listeLivres.add(new Book(
                "4723974",
                "La petite Maison dans la prairie",
                BookCategory.ROMAN,
                19.9f,
                3,
                "1945-05-02"
        ));
        listeLivres.add(new Book(
                "4324834523",
                "Fables",
                BookCategory.ROMAN,
                -12f,
                2,
                "1792-02-23"
        ));
        listeLivres.add(new Book(
                "122092023",
                "Spirou",
                BookCategory.BD,
                9.99f,
                4,
                "1992-07-12"
        ));
        listeLivres.add(new Book(
                "132453493",
                "Spirou 2 : le retour",
                BookCategory.BD,
                19.99f,
                2,
                "1993-08-18"
        ));
        listeLivres.add(new Book(
                "623483053",
                "Le petit Prince",
                BookCategory.ROMAN,
                29.99f,
                3,
                "1954-07-09"
        ));

        return listeLivres;
    }

}
