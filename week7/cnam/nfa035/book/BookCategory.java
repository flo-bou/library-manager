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
        BookCategory result = BookCategory.NONDEFINI;
        switch (s){
            case "Informatique" :
                result = BookCategory.INFORMATIQUE;
                break;
            case "Roman" :
                result = BookCategory.ROMAN;
                break;
            case "Bande dessinée" :
                result = BookCategory.BD;
                break;
            case "Catégorie non définie" :
                result = BookCategory.NONDEFINI;
                break;
            default :
                result = BookCategory.NONDEFINI;
                break;
        }
        return result;
    }
}
