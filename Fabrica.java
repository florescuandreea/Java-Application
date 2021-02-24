package simulare;

import java.util.ArrayList;
import java.util.List;

public class Fabrica {

    private static Fabrica instance;

    private int nrMasiniCreate;
    private final List<Masina> masini = new ArrayList<>(10);

    private Fabrica(){}

    public static Fabrica getInstance(){
        if(instance == null){
            instance = new Fabrica();
        }
        return instance;
    }

    public void adaugaMasina(String culoare, int pret) {
        if(masini.size() == 10){
            System.out.println("Fabrica este plina!");
            return;
        }
        Masina masina = new Masina(nrMasiniCreate, culoare, pret);
        masini.add(masina);
        nrMasiniCreate++;
        System.out.println("Masina adaugata!");
    }

    public void afisareMasini() {
        if(masini.size() == 0){
            System.out.println("Fabrica este goala!");
            return;
        }
        for(Masina masina: masini){
            System.out.println(masina.toString());
        }
    }

    public void detaliiMasina(Integer id) {
        for(Masina masina: masini){
            if (masina.getId() == id){
                System.out.println(masina.toString());
                return;
            }
        }
        System.out.println("Masina cautata nu exista!");
    }

    public void afiseazaCuloare(String culoare) {
        boolean existaMasiniCuCuloareaSpecificata = false;
        for(Masina masina: masini){
            if(masina.getCuloare().equalsIgnoreCase(culoare)){
                System.out.println(masina.toString());
                existaMasiniCuCuloareaSpecificata = true;
            }
        }
        if(!existaMasiniCuCuloareaSpecificata){
            System.out.println("Nu sunt masini cu culoarea " + culoare + " in fabrica!");
        }
    }

    public void vindeMasina(Integer id) throws MasinaNuExistaException {
        Masina masinaCautata = null;
        for(Masina masina: masini){
            if(masina.getId() == id){
                masinaCautata = masina;
                break;
            }
        }
        if(masinaCautata == null){
            throw new MasinaNuExistaException("Nu exista masina!");
        }
        masini.remove(masinaCautata);
        System.out.println( masinaCautata.toString());
        System.out.println(" a fost vanduta!");
    }

    public int getNrMasiniStoc(){
        return masini.size();
    }
}
