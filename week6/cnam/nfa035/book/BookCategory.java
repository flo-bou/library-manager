package cnam.nfa035.book;

public enum BookCategory {
    INFORMATIQUE("Informatique"), ROMAN("Roman"), BD("Bande dessinée"), NONDEFINI("Catégorie non définie");

    private final String name;

    BookCategory(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return this.name;
    }
}
