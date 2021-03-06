package cnam.nfa035.bookDao;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import cnam.nfa035.book.Book;
import cnam.nfa035.book.BookCategory;
import cnam.nfa035.Config;
import cnam.nfa035.DataService;

/*
* Class to CRUD Books serialized in a file
* */
public class BookDaoImplInFileSerializer implements BookDaoInterface {

    private final List<Book> listeLivres;

    public BookDaoImplInFileSerializer(){
        this.listeLivres = new ArrayList<>();
        deserializeBooks();
        if(this.listeLivres.size() == 0){
            System.out.println("Rien n'a été écrit en mémoire depuis le fichier." +
                    " Récupération des livres depuis DataService.");
            this.listeLivres.addAll(DataService.getLivres());
        }
    }

    private void deserializeBooks() {
        File f = null;
        try{
            Path path = Paths.get("cnam", "nfa035", Config.getProperties().getProperty("bookStorageSerialFile"));
            f = Config.getFile(path);
        } catch(Exception e){
            e.printStackTrace();
        }
        try (InputStream fis = new FileInputStream(f)) {
            try (ObjectInputStream ois = new ObjectInputStream(fis)) {
                Object tempObj;
                while ((tempObj = ois.readObject()) != null){
                    Book tempBook = (Book) tempObj;
                    ajouterLivre(tempBook);
                }
            } catch (EOFException e) {
                // EOF is always reached : this is normal flow
//                System.out.println("EOF reached");
                // System.out.println("ois EOFException : " + e.getMessage());
            } catch (Exception e) {
                System.out.println("ois Exception : " + e.getMessage());
                e.printStackTrace();
            }
        } catch (IOException e){
            System.out.println("fis IOException : " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void serializeBooks(){
        File f = null;
        try{
            Path path = Paths.get("cnam", "nfa035", Config.getProperties().getProperty("bookStorageSerialFile"));
            f = Config.getFile(path);
        } catch(Exception e){
            e.printStackTrace();
        }
        try (OutputStream fos = new FileOutputStream(f)) {
            try(ObjectOutputStream oos = new ObjectOutputStream(fos)){
                for (Book b : this.listeLivres){
                    oos.writeObject(b);
                }
            } catch(Exception e){
                System.out.println("Erreur : " + e.getMessage());
                e.printStackTrace();
            }
        } catch (Exception e){
            System.out.println("Erreur : " + e.getMessage());
            e.printStackTrace();
        }
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

//    @Override
//    protected void finalize(){
//        System.out.println("BookDaoImplInFile.finalise() method is called ");
//        saveLivresInFile();
//    }

    @Override
    public void close(){
        serializeBooks();
    }

}
