package cnam.nfa035.bookDao;

import java.util.ArrayList;
import java.util.List;

import cnam.nfa035.book.Book;
import cnam.nfa035.book.BookCategory;
import cnam.nfa035.DataService;


/*
* Class to CRUD Books stored as List in RAM
* */
public class BookDaoImplListInMemory implements BookDaoInterface {
    private final List<Book> listeLivres;

    public BookDaoImplListInMemory(){
        listeLivres = DataService.getLivres();
    }

    public String getLivres(){
        String result = "";
        for(Book b : this.listeLivres){
            result = result.concat(b.toString()).concat("\n");
        }
        return result;
    }

    public Book getLivreParIsbn(String isbn){
        Book result = null;
        for(Book b : this.listeLivres){
            if(isbn.equals(b.getIsbn())){
                result = b;
            }
        }
        return result;
    }

    public List<Book> getLivreParCategorie(BookCategory categorie){
        List<Book> result = new ArrayList<>();
        for(Book b : this.listeLivres){
            if(categorie == b.getCategorie()){
                result.add(b);
            }
        }
        return result;
    }

    public List<Book> getLivreParTitre(String titre){
        List<Book> result = new ArrayList<>();
        for(Book b : this.listeLivres){
            if(b.getTitre().contains(titre)){
                result.add(b);
            }
        }
        return result;
    }

    public boolean ajouterLivre(Book livre){
        boolean result = true;
        for(Book b : this.listeLivres){
            if (livre.getIsbn().equals(b.getIsbn())) {
                result = false;
                break;
            }
        }
        if(result){
            this.listeLivres.add(livre);
        }
        return result;
    }

    public boolean modifierLivre(Book livre){
        boolean result = false;
        for(Book b : this.listeLivres){
            if(livre.getIsbn().equals(b.getIsbn())){
                b.setTitre(livre.getTitre());
                b.setCategorie(livre.getCategorie());
                b.setPrix(livre.getPrix());
                b.setQuantiteDisponible(livre.getQuantiteDisponible());
                b.setDateParution(livre.getDateParution());
                result = true;
            }
        }
        return result;
    }

    public boolean modifierLivre(String isbn, int quantite){
        boolean result = false;
        for(Book b : this.listeLivres){
            if(isbn.equals(b.getIsbn())){
                b.setQuantiteDisponible(quantite);
                result = true;
            }
        }
        return result;
    }

    public boolean suprimerLivre(String isbn){
        boolean result = false;
        for(Book b : this.listeLivres){
            if(isbn.equals(b.getIsbn())){
                this.listeLivres.remove(b);
                result = true;
            }
        }
        return result;
    }

    @Override
    public void close(){
    }
}
