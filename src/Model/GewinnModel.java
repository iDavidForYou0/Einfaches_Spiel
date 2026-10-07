package Model;
import java.util.Random;

public class GewinnModel {
    private int gesamtPunkte;
    private int spielerAnzahl;
    private int computerAnzahl;
    private int rundenErgebnis;

    public GewinnModel() {

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

    }

    public boolean hatGewonnen() {

    }

    public boolean hatVerloren() {

    }
}
