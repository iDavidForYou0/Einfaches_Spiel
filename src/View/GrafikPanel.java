package View;

import java.awt.*;

import javax.swing.*;

import java.awt.event.ActionListener;

public class GrafikPanel extends JPanel {
    private JLabel runde;
    private JLabel gesamt;
    private JTextField spieler;
    private JTextField computer;
    private JButton nochEinmal;

    public GrafikPanel(){
        setLayout(new BorderLayout(5, 5));

        JPanel mitte = new JPanel(new GridLayout(4, 2, 5, 5));

        runde = erzeugeAnzeigeLabel("Tippe eine Zahl von 1 bis 9");
        gesamt = erzeugeAnzeigeLabel("30");

        spieler = erzeugeZahlenFeld();
        computer = erzeugeZahlenFeld();
        computer.setEditable(false);

        mitte.add(erzeugeUeberschrift("Rundenergebnis:"));
        mitte.add(erzeugeUeberschrift("Gesamtpunkte:"));
        mitte.add(runde);
        mitte.add(gesamt);
        mitte.add(erzeugeUeberschrift("Deine Zahl:"));
        mitte.add(erzeugeUeberschrift("Computer:"));
        mitte.add(spieler);
        mitte.add(computer);

        nochEinmal = new JButton("Noch Einmal!");
        JPanel unten = new JPanel();
        unten.add(nochEinmal);

        add(mitte, BorderLayout.CENTER);
        add(unten, BorderLayout.SOUTH);
    }

    private JLabel erzeugeUeberschrift(String text) {
        return new JLabel(text, SwingConstants.CENTER);
    }

    private JLabel erzeugeAnzeigeLabel(String text) {
        JLabel l = new JLabel(text, SwingConstants.CENTER);
        l.setOpaque(true);
        l.setBackground(Color.WHITE);
        l.setFont(l.getFont().deriveFont(Font.BOLD));
        return l;
    }

    private JLabel erzeugeZahlenFeld() {
        JTextField f = new JTextField();
        f.setHorizontalAlignment(JTextField.CENTER);
        f.setFont(new Font("SansSerif", Font.BOLD, 36));
        return f;
    }

    public String getSpielerEingabe() {
        return spieler.getText().trim();
    }

    public void setRundenErgebnis(String text) {
        runde.setText(text);
    }

    public void setGesamtPunkte(String text) {
        gesamt.setText(text);
    }

    public void setComputerZahl(String text) {
        computer.setText(text);
    }

    public void zuruecksetzen() {
        spieler.setText("");
        computer.setText("");
        runde.setText("Tippe eine Zahl von 1 bis 9");
        spieler.requestFocus();
    }

    public void addEingabeListener(ActionListener l) {
        spieler.addActionListener(l);
    }

    public void addNochEinmalListener(ActionListener l) {
        nochEinmal.addActionListener(l);
    }
}
