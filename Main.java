package simulare;

import java.util.Scanner;

public class Main {
    private static Fabrica fabrica;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String startCommand = scanner.nextLine();

        while (!startCommand.equals("START")) {
            System.out.println("Te rog introdu comanda START!");
            startCommand = scanner.nextLine();
        }
        afiseazaComenzi();

        fabrica = Fabrica.getInstance();
        startThreadAfisareStoc();
        executaComenzi(scanner);
    }

    private static void startThreadAfisareStoc() {
        Thread threadAfisareStoc = new Thread(getTask());
        threadAfisareStoc.start();
    }

    private static Runnable getTask() {
        return () -> {
            while (true) {
                try {
                    Thread.sleep(30000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("In stoc sunt: " + fabrica.getNrMasiniStoc());
            }
        };
    }

    private static void executaComenzi(Scanner scanner) {
        while (true) {
            String commanda = scanner.nextLine();
            String[] params = commanda.split(" ");

            switch (params[0]) {
                case "START":{
                    apelareStart();
                    break;
                }
                case "ADAUGA": {
                    adaugaMasina(params);
                    break;
                }
                case "AFISARE": {
                    afisareMasini();
                    break;
                }
                case "DETALII": {
                    detaliiMasina(params);
                    break;
                }
                case "AFISEAZA": {
                    afiseazaCuloare(params);
                    break;
                }
                case "VINDE": {
                    vindeMasina(params);
                    break;
                }
                case "EXIT": {
                    iesireAplicatie();
                    break;
                }
                default:{
                    cazDefault();
                }
            }
        }
    }

    private static void cazDefault() {
        System.out.println("Comanda nu exista!");
        afiseazaComenzi();
    }

    private static void iesireAplicatie() {
        System.out.println("La revedere!");
        System.exit(0);
    }

    private static void vindeMasina(String[] params) {
        Integer id = Integer.parseInt(params[1]);
        try {
            fabrica.vindeMasina(id);
        } catch (MasinaNuExistaException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void afiseazaCuloare(String[] params) {
        String culoare = params[1];
        fabrica.afiseazaCuloare(culoare);
    }

    private static void detaliiMasina(String[] params) {
        Integer id = Integer.parseInt(params[1]);
        fabrica.detaliiMasina(id);
    }

    private static void afisareMasini() {
        fabrica.afisareMasini();
    }

    private static void apelareStart() {
        System.out.println("Ati pornit deja aplicatia");
        afiseazaComenzi();
    }

    private static void adaugaMasina(String[] params) {
        String culoare = params[1];
        int pret = Integer.parseInt(params[2]);
        fabrica.adaugaMasina(culoare, pret);
    }

    private static void afiseazaComenzi() {
        System.out.println("Urmatoarele comenzi sunt disponibile:");
        System.out.println("START");
        System.out.println("ADAUGA <culoare> <pret>");
        System.out.println("AFISARE");
        System.out.println("DETALII <id_masina>");
        System.out.println("AFISEAZA <culoare>");
        System.out.println("VINDE <id_masina>");
        System.out.println("EXIT");
    }
}
