package cnam.nfa035.bookDao;


import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cnam.nfa035.book.Book;
import cnam.nfa035.book.BookCategory;
import cnam.nfa035.Config;
import cnam.nfa035.DataService;

/*
* Class to CRUD Books stored in a file
* */
public class BookDaoImplInFile implements BookDaoInterface {

    private final List<Book> listeLivres;
    private final String SEPARATOR = ";;;";

    public BookDaoImplInFile(){
        this.listeLivres = new ArrayList<>();
        getLivresFromFile();
        if(this.listeLivres.size() == 0){
            System.out.println("Rien n'a été écrit en mémoire depuis le fichier." +
                    " Récupération des livres depuis DataService.");
            this.listeLivres.addAll(DataService.getLivres());
        }
    }

    private void getLivresFromFile() {
        File f = null;
        try {
            Path path = Paths.get("cnam", "nfa035", Config.getProperties().getProperty("bookStorageFile"));
            f = Config.getFile(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (FileReader fr = new FileReader(f)) {
            try (BufferedReader br = new BufferedReader(fr)) {
                String line = "";
                String isbn = "";
                String titre = "";
                String categorie = "";
                String prix = "";
                String quantite = "";
                String dateParution = "";

                while ((line = br.readLine()) != null) {
                    if(line.length() > 0){
                        String[] values = line.split(this.SEPARATOR);
                        System.out.println(Arrays.toString(values));
                        isbn = values[0];
                        titre = values[1];
                        categorie = values[2];
                        prix = values[3];
                        quantite = values[4];
                        dateParution = values[5];
                        Book tempBook = new Book(
                            isbn,
                            titre,
                            BookCategory.toEnum(categorie),
                            Float.parseFloat(prix),
                            Integer.parseInt(quantite),
                            dateParution
                        );
                        ajouterLivre(tempBook);
                    }
                }
            } catch (EOFException e) {
                // EOF is always reached : this is normal flow
                System.out.println("EOF reached");
                // System.out.println("ois EOFException : " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Erreur : " + e.getMessage());
                e.printStackTrace();
            }
        } catch (Exception e){
            System.out.println("Erreur : " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void saveLivresInFile(){
        File f = null;
        try{
            Path path = Paths.get("cnam", "nfa035", Config.getProperties().getProperty("bookStorageFile"));
            f = Config.getFile(path);
        } catch(Exception e){
            e.printStackTrace();
        }
        try (FileWriter fw = new FileWriter(f)) {
            try(BufferedWriter bw = new BufferedWriter(fw)){
                for (Book b : this.listeLivres){
                    bw.write(
                        b.getIsbn() + this.SEPARATOR +
                        b.getTitre() + this.SEPARATOR +
                        b.getCategorie().toString() + this.SEPARATOR +
                        Float.toString(b.getPrix()) + this.SEPARATOR +
                        Integer.toString(b.getQuantiteDisponible()) + this.SEPARATOR +
                        b.getDateParution()
                    );
                    bw.newLine();
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
        saveLivresInFile();
    }

}
