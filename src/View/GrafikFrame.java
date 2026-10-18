package View;

import javax.swing.*;

import java.awt.event.ActionListener;

public class GrafikFrame extends JFrame {
    private GrafikPanel panel;

    public GrafikFrame(ActionListener controller) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new GrafikPanel();
        this.add(panel);
        this.setVisible(true);
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
    }

    public GrafikPanel getPanel() {
        return panel;
    }
}
