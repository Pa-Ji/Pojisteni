package PojisteniApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

class Evidence {
    private List<Pojisteny> seznam;
    private static final Pattern JMENO_REGEX = Pattern.compile("^[A-ZČĎĚŇŘŠŤŽ][a-zčďěňřšťžáíéúůý]*([ ][A-ZČĎĚŇŘŠŤŽ][a-zčďěňřšťžáíéúůý]*)*$");
    private static final Pattern TELEFON_REGEX = Pattern.compile("\\d{9}");

    public Evidence() {
        this.seznam = new ArrayList<>();
    }

    public void pridatPojisteneho(Scanner scanner) {
        System.out.print("Zadejte jméno (více jmen oddělte mezerou): ");
        String jmeno = scanner.nextLine().trim();
        if (!validujJmeno(jmeno)) {
            System.out.println("CHYBA: Jméno musí začínat velkým písmenem a nesmí obsahovat speciální znaky.");
            return;
        }

        System.out.print("Zadejte příjmení: ");
        String prijmeni = scanner.nextLine().trim();
        if (!validujJmeno(prijmeni)) {
            System.out.println("CHYBA: Příjmení musí začínat velkým písmenem a nesmí obsahovat speciální znaky.");
            return;
        }

        int vek;
        while (true) {
            System.out.print("Zadejte věk: ");
            try {
                vek = Integer.parseInt(scanner.nextLine().trim());
                if (vek < 0 || vek > 130) {
                    System.out.println("CHYBA: Věk musí být v rozmezí 0-130 let.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("CHYBA: Věk musí být číslo.");
            }
        }

        String telefon;
        while (true) {
            System.out.print("Zadejte telefonní číslo: ");
            telefon = scanner.nextLine().trim().replaceAll("\\s", "");
            if (!TELEFON_REGEX.matcher(telefon).matches()) {
                System.out.println("CHYBA: Telefonní číslo musí mít přesně 9 číslic.");
            } else {
                break;
            }
        }

        Pojisteny novy = new Pojisteny(jmeno, prijmeni, vek, telefon);
        seznam.add(novy);
        System.out.println("Pojištěný byl úspěšně přidán.");
    }

    private boolean validujJmeno(String vstup) {
        return vstup != null && JMENO_REGEX.matcher(vstup).matches();
    }

    public void zobrazSeznam() {
        if (seznam.isEmpty()) {
            System.out.println("Žádní pojištění nejsou v evidenci.");
        } else {
            seznam.stream().sorted((p1, p2) -> p1.getJmeno().compareToIgnoreCase(p2.getJmeno()))
                    .forEach(System.out::println);
        }
    }

    public void vyhledatPojisteneho(String hledanyVyraz) {
        hledanyVyraz = hledanyVyraz.toLowerCase();
        boolean nalezen = false;
        for (Pojisteny p : seznam) {
            if (p.getJmeno().toLowerCase().contains(hledanyVyraz) ||
                    p.getPrijmeni().toLowerCase().contains(hledanyVyraz) ||
                    p.getTelefon().contains(hledanyVyraz)) {
                System.out.println("Nalezen: " + p);
                nalezen = true;
            }
        }
        if (!nalezen) {
            System.out.println("Pojištěný nenalezen.");
        }
    }
}
