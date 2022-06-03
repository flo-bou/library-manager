package cnam.nfa035.book;


public enum BookCategory {
    INFORMATIQUE("Informatique"),
    ROMAN("Roman"),
    BD("Bande dessinée"),
    NONDEFINI("Catégorie non définie");

    private final String name;

    BookCategory(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return this.name;
    }

    public static BookCategory toEnum(String s) {
        BookCategory result = null;

        for(BookCategory cat : BookCategory.values()){
            if(cat.toString().contains(s)){
                result = cat;
                if(cat.toString().equals(s)){
                    break;
                }
            }
        }

        return result;
    }
}
