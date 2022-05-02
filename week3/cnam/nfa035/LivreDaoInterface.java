package cnam.nfa035;

import java.util.List;

public interface LivreDaoInterface {
    String getLivres();
    Livre getLivreParIsbn(String isbn);
    List<Livre> getLivreParCategorie(TCategorie categorie);
    List<Livre> getLivreParTitre(String titre);
    boolean ajouterLivre(Livre livre);
    boolean modifierLivre(Livre livre);
    boolean modifierLivre(String isbn, int quantite);
    boolean suprimerLivre(String isbn);
}
