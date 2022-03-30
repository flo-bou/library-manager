import java.time.LocalDate;

public class TestLivre {
    public static void main(String[] args) {
        Livre livre1 = new Livre("4324", "Le beau titre", Tcategorie.INFORMATIQUE, 9.99f, 120, LocalDate.of(1992, 7, 12));
        System.out.println(livre1);

        livre1.ajouter(12);
        livre1.restituer();

        if(livre1.emprunter()){
            System.out.println("Vous pouvez emprunter.");
        } else{
            System.out.println("Emprunt impossible.");
        }
        System.out.println(livre1.getQuantiteDisponible());

        System.out.println("Nombre d'années depuis la parution : " + livre1.getDuree());
    }
}
