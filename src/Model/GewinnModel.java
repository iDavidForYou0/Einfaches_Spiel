package Model;

import java.util.Random;

public class GewinnModel {
    private int gesamtPunkte;
    private int spielerAnzahl;
    private int computerAnzahl;
    private int rundenErgebnis;

    public GewinnModel() {
        this.gesamtPunkte = 30;
    }

    public int getGesamtPunkte() {
        return this.gesamtPunkte;
    }

    public int getComputerAnzahl() {
        return this.computerAnzahl;
    }

    public int getRundenErgebnis() {
        return this.rundenErgebnis;
    }

    public void berechneComputerAnzahl() {
        Random random = new Random();
        this.computerAnzahl = random.nextInt(9);
    }

    public void berechneRunde(int spielerZahl) {
        this.spielerAnzahl = spielerZahl;
        berechneComputerAnzahl();

        if (this.spielerAnzahl == this.computerAnzahl) {
            this.rundenErgebnis = 20;
        } else if (this.spielerAnzahl == this.computerAnzahl + 1 || this.spielerAnzahl == this.computerAnzahl - 1) {
            this.rundenErgebnis = 5;
        } else {
            this.rundenErgebnis = -10;
        }
        this.gesamtPunkte += this.rundenErgebnis;
    }

    public boolean hatGewonnen() {
        return this.gesamtPunkte >= 100;
    }

    public boolean hatVerloren() {
        return this.gesamtPunkte <= 0;
    }

    public void neuesSpiel() {
        gesamtPunkte = 30;
        rundenErgebnis = 0;
        computerAnzahl = 0;
        spielerAnzahl = 0;
    }
}
