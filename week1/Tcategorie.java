//package Project.NFA035.week1;

public enum Tcategorie {
    INFORMATIQUE("Informatique"), ROMAN("Roman"), BD("Bande dessinée"), NONDEFINI("Catégorie non définie");

    private final String name;

    private Tcategorie(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }
}
