package cnam.nfa035.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cnam.nfa035.book.Book;
import cnam.nfa035.book.BookCategory;
import cnam.nfa035.utils.Config;
import cnam.nfa035.utils.DataService;


/*
* Class to CRUD Books stored in a File
* */

//va chercher les livres à partir d’un fichier et va sauvegarder les livres dans le fichier
//        - La lecture dans le fichier des livres doit se faire depuis le constructeur (appel d’une
//        méthode GetLivresDansFichier qui récupère les livres dans un fichier et les stocke dans
//        une liste en mémoire).
//        - La sauvegarde des livres doit se faire dans la méthode finalize (appel d’une méthode
//        SauverLivreDansFichier qui écrit la liste des livres dans un fichier).
//        - Les différents traitements sur la gestion des livres se font toujours sur la liste

public class BookDaoImplInFile implements BookDaoInterface {

    private final List<Book> listeLivres;

    public BookDaoImplInFile(){
        this.listeLivres = DataService.getLivres();
        getLivresFromFile();
    }

    private void getLivresFromFile(){
        File f = Config.getBooksDbFile();

    }
//    saveLivresInFile(){}

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
        // parcours de la liste pour savoir si un livre avec un isbn similaire est déjà présent
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
                // réaffecter chaque champs
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

}
