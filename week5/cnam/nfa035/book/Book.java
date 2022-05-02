package cnam.nfa035.book;

import cnam.nfa035.log.Log;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Livre est une classe représentant une référence de livre dans une bibliothèque
 */
public class Book {
    private final String isbn;
    private String titre;
    private BookCategory categorie;
    private float prix = 0.0f;
    private int quantiteDisponible;
    private LocalDate dateParution;
    private final Log journal = Log.getInstance();

    public String getIsbn() {
        return this.isbn;
    }
    public String getTitre() {
        return this.titre;
    }
    public BookCategory getCategorie() {
        return this.categorie;
    }
    public float getPrix() {
        return this.prix;
    }
    public int getQuantiteDisponible(){
        return this.quantiteDisponible;
    }
    public LocalDate getDateParution() {
        return this.dateParution;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
    public void setCategorie(BookCategory categorie) {
        this.categorie = categorie;
    }
    public void setPrix(float prix) {
        if(prix < 0.0f){
            this.journal.addErrorLog("Le prix demandé pour le livre « " + getTitre() + " » est impossible car négatif. Le prix " +
                    "reste alors inchangé :" + this.getPrix());
        }else{
            this.prix = prix;
            this.journal.addInfoLog("Le prix du livre « " + getTitre() + " » vient d'être modifié. Le prix est désormais " +
                    "de " + getPrix());
        }
    }
    public void setQuantiteDisponible(int quantiteDisponible) {
        if(quantiteDisponible < 0){
            this.journal.addErrorLog("La quantité demandée pour le livre « " + getTitre() + " » est impossible car négative. La" +
                    " quantité reste alors inchangée :" + this.getQuantiteDisponible());
        } else {
            this.quantiteDisponible = quantiteDisponible;
            this.journal.addInfoLog("La quantité en stock du livre « " + getTitre() + " » vient d'être modifiée. Le stock est " +
                    "désormais de " + getQuantiteDisponible());
        }
    }
    public void setDateParution(LocalDate dateParution) {
        this.dateParution = dateParution;
    }

    public Book(String isbn, String titre, BookCategory categorie, float prix, int quantiteDisponible, LocalDate dateParution){
        this.isbn = isbn;
        this.titre = titre;
        this.categorie = categorie;
        setPrix(prix);
        setQuantiteDisponible(quantiteDisponible);
        this.dateParution = dateParution;
        this.journal.addInfoLog("Un livre vient d'être crée. " + this);
    }

    /**
     * permet ou non de diminuer la quantité de un
     */
    public boolean emprunter(){
        boolean response = false;
        if(this.quantiteDisponible > 0){
            this.quantiteDisponible--;
            this.journal.addInfoLog("1 exemplaire du livre « " + getTitre() + " » vient d'être emprunté. Il en reste " + getQuantiteDisponible() + " exemplaires en stock.");
            response = true;
        } else{
            this.journal.addWarningLog("Le livre « " + getTitre() + " » n'a pas pu être emprunté car il n'y a plus " +
                    "d'exemplaires en stock.");
        }
        return response;
    }

    /**
     *  permet d’augmenter la quantité d’un nombre donné
     */
    public void ajouter(int nbr){
        if(nbr < 0){
            this.journal.addErrorLog("Il est impossible d'ajouter un quantité négative au stock du livre « " + getTitre() +
                    " ». La quantité reste alors inchangée : " + getQuantiteDisponible());
        } else{
            setQuantiteDisponible(getQuantiteDisponible() + nbr);
            this.journal.addInfoLog(nbr + " exemplaire(s) du livre « " + getTitre() + " » viennent d'être ajoutés en stock. Le " +
                    "stock total est de " + getQuantiteDisponible() + " exemplaires.");
        }
    }

    /**
     * permet d’augmenter la quantité de 1
     */
    public void restituer(){
        this.quantiteDisponible++;
        this.journal.addInfoLog("1 exemplaire du livre « " + getTitre() + " » vient d'être restitué. Le " +
                "stock est de " + getQuantiteDisponible() + " exemplaires.");
    }

    /**
     * permet de récupérer la durée écoulée (nombre d’année) entre la date courante et la date de parution.
     */
    public long getDuree(){
        return this.dateParution.until(LocalDate.now(), ChronoUnit.YEARS);
    }

    @Override
    public String toString(){
        return "isbn : " + getIsbn() + ", titre : «" + getTitre() + "», catégorie : " + getCategorie().toString() +
                ", prix : " + getPrix() + ", quantité : " + getQuantiteDisponible() + ", date de parution : " + getDateParution().toString();
    }

}
