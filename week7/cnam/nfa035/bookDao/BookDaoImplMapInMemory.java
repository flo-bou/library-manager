package cnam.nfa035.bookDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cnam.nfa035.book.Book;
import cnam.nfa035.book.BookCategory;
import cnam.nfa035.DataService;


/*
* Class to CRUD Books stored as Map in RAM
* */
public class BookDaoImplMapInMemory implements BookDaoInterface {
    private final HashMap<String, Book> listeLivres;

    public BookDaoImplMapInMemory(){
        this.listeLivres = new HashMap<>();
        for(Book b : DataService.getLivres()){
            this.listeLivres.put(b.getIsbn(), b);
        }
    }

    public String getLivres(){
        String result = "";
        for(Book b : this.listeLivres.values()){
            result = result.concat(b.toString()).concat("\n");
        }
        return result;
    }

    public Book getLivreParIsbn(String isbn){
        Book result = null;
        if(this.listeLivres.containsKey(isbn)){
            result = this.listeLivres.get(isbn);
        }
        return result;
    }

    public List<Book> getLivreParCategorie(BookCategory categorie){
        List<Book> result = new ArrayList<>();
        for(Book b : this.listeLivres.values()){
            if(categorie == b.getCategorie()){
                result.add(b);
            }
        }
        return result;
    }

    public List<Book> getLivreParTitre(String titre){
        List<Book> result = new ArrayList<>();
        for(Book b : this.listeLivres.values()){
            if(titre.equals(b.getTitre())){
                result.add(b);
                break;
            }
        }
        return result;
    }

    public boolean ajouterLivre(Book livre){
        boolean result = false;
        if(! this.listeLivres.containsKey(livre.getIsbn())){
            this.listeLivres.put(livre.getIsbn(), livre);
            result = true;
        }
        return result;
    }

    public boolean modifierLivre(Book livre){
        boolean result = false;
        if(this.listeLivres.containsValue(livre)){
            Book b = this.listeLivres.get(livre.getIsbn());
            // réaffecter chaque champs
            b.setTitre(livre.getTitre());
            b.setCategorie(livre.getCategorie());
            b.setPrix(livre.getPrix());
            b.setQuantiteDisponible(livre.getQuantiteDisponible());
            b.setDateParution(livre.getDateParution());
            result = true;
        }
        return result;
    }

    public boolean modifierLivre(String isbn, int quantite){
        boolean result = false;
        if(this.listeLivres.containsKey(isbn)){
            this.listeLivres.get(isbn).setQuantiteDisponible(quantite);
            result = true;
        }
        return result;
    }

    public boolean suprimerLivre(String isbn){
        boolean result = false;
        if(this.listeLivres.containsKey(isbn)){
            this.listeLivres.remove(isbn);
            result = true;
        }
        return result;
    }

    @Override
    public void close(){
    }
}
