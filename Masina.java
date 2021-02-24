package simulare;

public class Masina {
    private final int id;
    private final String culoare;
    private final int pret;

    public Masina(int id, String culoare, int pret) {
        this.id = id;
        this.culoare = culoare;
        this.pret = pret;
    }

    public int getId() {
        return id;
    }

    public String getCuloare() {
        return culoare;
    }


    public int getPret() {
        return pret;
    }


    @Override
    public String toString() {
        return "Masina{" +
                "id=" + id +
                ", culoare='" + culoare + '\'' +
                ", pret=" + pret + '\'' +
                '}';
    }
}
