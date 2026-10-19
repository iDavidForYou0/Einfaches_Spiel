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
        this.setLayout(new BorderLayout());
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(3, 2, 4, 4));
        northPanel.add(new JLabel("Rundenergebnis:", JLabel.CENTER));
        northPanel.add(new JLabel("Gesamtpunkte:", JLabel.CENTER));

        runde = new JLabel("Tippe eine Zahl von 1 - 9", JLabel.CENTER);
        runde.setOpaque(true);
        runde.setBackground(new Color(255, 255, 255));

        gesamt = new JLabel("Gesamtpunkte: 30", JLabel.CENTER);
        gesamt.setOpaque(true);
        gesamt.setBackground(new Color(255, 255, 255));

        northPanel.add(runde);
        northPanel.add(gesamt);
        northPanel.add(new JLabel("Deine Zahl:", JLabel.CENTER));
        northPanel.add(new JLabel("Computer:", JLabel.CENTER));

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(1, 2, 4, 4));

        spieler = new JTextField();
        spieler.setHorizontalAlignment(JTextField.CENTER);
        centerPanel.add(spieler);

        computer = new JTextField();
        computer.setHorizontalAlignment(JTextField.CENTER);
        computer.setEditable(false);
        centerPanel.add(computer);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout());
        nochEinmal = new JButton("Noch einmal");
        southPanel.add(nochEinmal);

        this.add(northPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);
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

    private JTextField erzeugeZahlenFeld() {
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
