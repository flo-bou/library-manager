package week4;

public enum BookCategory {
    INFORMATIQUE("Informatique"), ROMAN("Roman"), BD("Bande dessinée"), NONDEFINI("Catégorie non définie");

    private final String name;

    private BookCategory(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }
}
