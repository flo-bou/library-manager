

public enum Tcategorie {
    INFORMATIQUE("Informatique");

    private final String name;

    private Tcategorie(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }
}
