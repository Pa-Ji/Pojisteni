package PojisteniApp;

import java.util.Scanner;

public class PojisteniApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Evidence evidence = new Evidence();

        while (true) {
            System.out.println("\nVítejte v pojišťovací aplikaci. Vyberte jednu z následujících možností:");
            System.out.println("1 - Přidat pojištěného");
            System.out.println("2 - Zobrazit seznam");
            System.out.println("3 - Vyhledat pojištěného");
            System.out.println("4 - Konec");

            System.out.print("Vaše volba: ");
            int volba;
            try {
                volba = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Neplatná volba, zkuste to znovu.");
                continue;
            }

            switch (volba) {
                case 1:
                    evidence.pridatPojisteneho(scanner);
                    break;
                case 2:
                    evidence.zobrazSeznam();
                    break;
                case 3:
                    System.out.print("Zadejte hledaný text (jméno, příjmení nebo část telefonního čísla): ");
                    String hledanyVyraz = scanner.nextLine().trim();
                    evidence.vyhledatPojisteneho(hledanyVyraz);
                    break;
                case 4:
                    System.out.println("Ukončuji aplikaci...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Neplatná volba, zkuste to znovu.");
            }
        }
    }
}
