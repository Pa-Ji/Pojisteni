package PojisteniApp;

import java.util.Scanner;

public class PojisteniApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Evidence evidence = new Evidence();

        while (true) {
            System.out.print("Výtejte v pojištovací aplikaci, prosím vyberte jednu z nasledujicích možností.");
            System.out.println("\n1 - Přidat pojištěného");
            System.out.println("2 - Zobrazit seznam");
            System.out.println("3 - Vyhledat pojištěného");
            System.out.println("4 - Konec");

            int volba = scanner.nextInt();
            scanner.nextLine(); // Čištění bufferu

            switch (volba) {
                case 1:
                    System.out.print("Zadej jméno: ");
                    String jmeno = scanner.nextLine();
                    System.out.print("Zadej příjmení: ");
                    String prijmeni = scanner.nextLine();
                    System.out.print("Zadej věk: ");
                    int vek = scanner.nextInt();
                    scanner.nextLine(); // Čištění bufferu
                    System.out.print("Zadej telefonní číslo: ");
                    String telefon = scanner.nextLine();
                    evidence.pridatPojisteneho(jmeno, prijmeni, vek, telefon);
                    break;
                case 2:
                    evidence.zobrazSeznam();
                    break;
                case 3:
                    System.out.print("Zadej jméno: ");
                    String hledaneJmeno = scanner.nextLine();
                    System.out.print("Zadej příjmení: ");
                    String hledanePrijmeni = scanner.nextLine();
                    evidence.vyhledatPojisteneho(hledaneJmeno, hledanePrijmeni);
                    break;
                case 4:
                    System.out.println("Ukončuji aplikaci...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Neplatná volba, zkus to znovu.");
            }
        }
    }
}
