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
        for(Book l : this.listeLivres){
            result = result.concat(l.toString()).concat("\n");
        }
        return result;
    }

    public Book getLivreParIsbn(String isbn){
        Book result = null;
        for(Book l : this.listeLivres){
            if(isbn.equals(l.getIsbn())){
                result = l;
            }
        }
        return result;
    }

    public List<Book> getLivreParCategorie(BookCategory categorie){
        List<Book> result = new ArrayList<>();
        for(Book l : this.listeLivres){
            if(categorie == l.getCategorie()){
                result.add(l);
            }
        }
        return result;
    }

    public List<Book> getLivreParTitre(String titre){
        List<Book> result = new ArrayList<>();
        for(Book l : this.listeLivres){
            if(titre.equals(l.getTitre())){
                result.add(l);
            }
        }
        return result;
    }

    public boolean ajouterLivre(Book livre){
        boolean result = true;
        for(Book l : this.listeLivres){
            if (livre.getIsbn().equals(l.getIsbn())) {
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
        for(Book l : this.listeLivres){
            if(livre.getIsbn().equals(l.getIsbn())){
                l.setTitre(livre.getTitre());
                l.setCategorie(livre.getCategorie());
                l.setPrix(livre.getPrix());
                l.setQuantiteDisponible(livre.getQuantiteDisponible());
                l.setDateParution(livre.getDateParution());
                result = true;
            }
        }
        return result;
    }

    public boolean modifierLivre(String isbn, int quantite){
        boolean result = false;
        for(Book l : this.listeLivres){
            if(isbn.equals(l.getIsbn())){
                l.setQuantiteDisponible(quantite);
                result = true;
            }
        }
        return result;
    }

    public boolean suprimerLivre(String isbn){
        boolean result = false;
        for(Book l : this.listeLivres){
            if(isbn.equals(l.getIsbn())){
                this.listeLivres.remove(l);
                result = true;
            }
        }
        return result;
    }

    @Override
    public void close(){
    }
}
