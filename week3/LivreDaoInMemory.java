package week3;

import java.util.ArrayList;
import java.util.List;

/*
* Class to access/CRUD Livres stored in RAM
* Une liste de livre est créée à l'instanciation
* */
public class LivreDaoInMemory implements LivreDaoInterface{
    List<Livre> listeLivres;

    LivreDaoInMemory(){
        listeLivres = DataService.getLivres();
    }

    public String getLivres(){
        String result = "";
        for(Livre l : this.listeLivres){
            result = result.concat(l.toString()).concat("\n");
        }
        return result;
    }

    public Livre getLivreParIsbn(String isbn){
        Livre result = null;
        for(Livre l : this.listeLivres){
            if(isbn.equals(l.getIsbn())){
                result = l;
            }
        }
        return result;
    }

    public List<Livre> getLivreParCategorie(TCategorie categorie){
        List<Livre> result = new ArrayList<>();
        for(Livre l : this.listeLivres){
            if(categorie == l.getCategorie()){
                result.add(l);
            }
        }
        return result;
    }

    public List<Livre> getLivreParTitre(String titre){
        List<Livre> result = new ArrayList<>();
        for(Livre l : this.listeLivres){
            if(titre.equals(l.getTitre())){
                result.add(l);
            }
        }
        return result;
    }

    public boolean ajouterLivre(Livre livre){
        boolean result = true;
        // parcours de la liste pour savoir si un livre avec un isbn similaire est déjà présent
        for(Livre l : this.listeLivres){
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

    public boolean modifierLivre(Livre livre){
        boolean result = false;
        for(Livre l : this.listeLivres){
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
        for(Livre l : this.listeLivres){
            if(isbn.equals(l.getIsbn())){
                l.setQuantiteDisponible(quantite);
                result = true;
            }
        }
        return result;
    }

    public boolean suprimerLivre(String isbn){
        boolean result = false;
        for(Livre l : this.listeLivres){
            if(isbn.equals(l.getIsbn())){
                this.listeLivres.remove(l);
                result = true;
            }
        }
        return result;
    }

}
