package cnam.nfa035;

public enum TCategorie {
    INFORMATIQUE("Informatique"), ROMAN("Roman"), BD("Bande dessinée"), NONDEFINI("Catégorie non définie");

    private final String name;

    private TCategorie(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }
}
