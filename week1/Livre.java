import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Livre est une classe représentant un livre dans un magasin
 */
public class Livre{
    private String isbn;
    private String titre;
    private Tcategorie categorie;
    private float prix;
    private int quantiteDisponible;
    private LocalDate dateParution;

    Livre(String isbn, String titre, Tcategorie categorie, float prix, int quantiteDisponible, LocalDate dateParution){
        this.isbn = isbn;
        this.titre = titre;
        this.categorie = categorie;
        this.prix = prix;
        this.quantiteDisponible = quantiteDisponible;
        this.dateParution = dateParution;
    }

    /**
     * getter for quantiteDisponible
     * @return
     */
    public int getQuantiteDisponible(){
        return quantiteDisponible;
    }

    /**
     * permet ou non de diminuer la quantité de un
     * @return
     */
    public boolean emprunter(){
        double decision = Math.random();
        boolean result;
        if(decision < 0.5){
            result = true;
        } else{
            result = false;
        }
        return result;
    }

    /**
     *  permet d’augmenter la quantité d’un nombre donné
     * @param nbr
     */
    public void ajouter(int nbr){
        quantiteDisponible += nbr; 
    }

    /**
     * permet d’augmenter la quantité de un
     */
    public void restituer(){
        quantiteDisponible += 1; 
    }


    /**
     * permet de récupérer la durée écoulée (nombre d’année) entre la date courante et la date de parution.
     * @return
     */
    public long getDuree(){
        return dateParution.until(LocalDate.now(), ChronoUnit.YEARS);
    }

    public String toString(){
        return isbn + " " + titre + " " + categorie.toString() + " " + Float.toString(prix) + " " + Integer.toString(quantiteDisponible) + " " + dateParution.toString();
    }

}