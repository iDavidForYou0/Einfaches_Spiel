package Controller;

import Model.GewinnModel;
import View.GrafikFrame;
import View.GrafikPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class GewinnController {
    private GewinnModel model;
    private GrafikPanel view;

    public GewinnController(GewinnModel model, GrafikFrame frame) {
        this.model = model;
        this.view = frame.getPanel();

        view.addEingabeListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spielen();
            }
        });

        view.addNochEinmalListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (model.hatGewonnen() || model.hatVerloren()) {
                    model.neuesSpiel();
                    view.setGesamtPunkte("Gesamtpunkte: 30");
                }
                view.zuruecksetzen();
            }
        });
    }

    private void spielen() {
        int zahl;
        try {
            zahl = Integer.parseInt(view.getSpielerEingabe());
        }

        catch (NumberFormatException ex) {
            view.setRundenErgebnis("Bitte eine Zahl eingeben!");
            return;
        }

        if (zahl < 1 || zahl > 9) {
            view.setRundenErgebnis("Nur Zahlen von 1 bis 9!");
            return;
        }

        model.berechneComputerAnzahl();
        model.berechneRunde(zahl);

        view.setComputerZahl(String.valueOf(model.getComputerAnzahl()));
        view.setGesamtPunkte(String.valueOf(model.getGesamtPunkte()));

        if (model.hatGewonnen()) {
            view.setRundenErgebnis("Gewonnen");
        }

        else if (model.hatVerloren()){
            view.setRundenErgebnis("Verloren");
        }
        else {
            int r = model.getRundenErgebnis();
            view.setRundenErgebnis(r > 0 ? "+" + r : String.valueOf(r));
            view.setFarbe(r > 0 ? Color.GREEN : Color.RED);
        }

        view.setEingabeAktiv(false);
        view.setNochEinmalAktiv(true);
    }

    public static void main(String[] args) {
        GrafikFrame frame = new GrafikFrame();
        new GewinnController(new GewinnModel(), frame);
        frame.setVisible(true);
    }
}
