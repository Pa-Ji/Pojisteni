package PojisteniApp;

import PojisteniApp.Pojisteny;

import java.util.ArrayList;
import java.util.List;

class Evidence {
    private List<Pojisteny> seznam;

    public Evidence() {
        this.seznam = new ArrayList<>();
    }

    public void pridatPojisteneho(String jmeno, String prijmeni, int vek, String telefon) {
        if (jmeno.isEmpty() || prijmeni.isEmpty()) {
            System.out.println("Jméno a příjmení nesmí být prázdné!");
            return;
        }
        if (vek <= 0) {
            System.out.println("Věk musí být kladné číslo!");
            return;
        }
        Pojisteny novy = new Pojisteny(jmeno, prijmeni, vek, telefon);
        seznam.add(novy);
        System.out.println("Pojištěný byl úspěšně přidán.");
    }

    public void zobrazSeznam() {
        if (seznam.isEmpty()) {
            System.out.println("Žádní pojištění nejsou v evidenci.");
        } else {
            int i = 1;
            for (Pojisteny p : seznam) {
                System.out.println(i++ + ". " + p);
            }
        }
    }

    public void vyhledatPojisteneho(String jmeno, String prijmeni) {
        for (Pojisteny p : seznam) {
            if (p.getJmeno().equalsIgnoreCase(jmeno) && p.getPrijmeni().equalsIgnoreCase(prijmeni)) {
                System.out.println("Nalezen: " + p);
                return;
            }
        }
        System.out.println("Pojištěný nenalezen.");
    }
}
