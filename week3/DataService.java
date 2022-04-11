package week3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataService {
    // Cette méthode crée les livres en mémoire.
    // L’ensemble des traitements se réaliseront sur cette liste.
    static List<Livre> getLivres(){
        List<Livre> listeLivres = new ArrayList<>();
        listeLivres.add(new Livre("4723974", "La petite Maison dans la prairie", TCategorie.ROMAN, 19.9f, 3,
                LocalDate.of(1945, 5, 2)));
        listeLivres.add(new Livre("4324834523", "Fables", TCategorie.ROMAN, -12f, 2, LocalDate.of(1792, 2, 23)));
        listeLivres.add(new Livre("432483023", "Spirou", TCategorie.BD, 9.99f, 0, LocalDate.of(1992, 7, 12)));

        return listeLivres;
    }
}
