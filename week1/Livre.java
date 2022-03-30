//package week1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Livre est une classe représentant une référence de livre dans une bibliothèque
 */
public class Livre{
    private final String isbn;
    private final String titre;
    private final Tcategorie categorie;
    private float prix;
    private int quantiteDisponible;
    private final LocalDate dateParution;

    Livre(String isbn, String titre, Tcategorie categorie, float prix, int quantiteDisponible, LocalDate dateParution){
        this.isbn = isbn;
        this.titre = titre;
        this.categorie = categorie;
        this.prix = isPositive(prix) ? prix : 0.0f;
        this.quantiteDisponible = isPositive(quantiteDisponible) ? quantiteDisponible : 0;
        this.dateParution = dateParution;
    }

    /**
     * getter for quantiteDisponible
     */
    public int getQuantiteDisponible(){
        return quantiteDisponible;
    }

    /**
     * Teste si l'entré est positive
     */
    private boolean isPositive(int num){
        return num >= 0;
    }

    /**
     * Teste si l'entré est positive
     */
    private boolean isPositive(float num){
        return num >= 0f;
    }

    /**
     * permet ou non de diminuer la quantité de un
     */
    public boolean emprunter(){
        boolean result;
        if(quantiteDisponible > 0){
            result = true;
        } else{
            result = false;
        }
        return result;
    }

    /**
     *  permet d’augmenter la quantité d’un nombre donné
     */
    public void ajouter(int nbr){
        quantiteDisponible += nbr; 
    }

    /**
     * permet d’augmenter la quantité de 1
     */
    public void restituer(){
        quantiteDisponible++; 
    }

    /**
     * permet de récupérer la durée écoulée (nombre d’année) entre la date courante et la date de parution.
     */
    public long getDuree(){
        return dateParution.until(LocalDate.now(), ChronoUnit.YEARS);
    }

    public String toString(){
        return isbn + ", " + titre + ", " + categorie.toString() + ", " + Float.toString(prix) + ", " + Integer.toString(quantiteDisponible) + ", " + dateParution.toString();
    }

}