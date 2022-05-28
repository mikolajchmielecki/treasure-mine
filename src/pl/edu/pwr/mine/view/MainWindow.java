package pl.edu.pwr.mine.view;

import pl.edu.pwr.mine.model.Circle;

import javax.swing.*;
import java.util.List;

public class MainWindow extends JFrame {

    private CirclesPanel panel;

    public MainWindow(List<Circle> circles, int width, int height) {
        panel = new CirclesPanel(circles, width, height);
        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void repaint() {
        super.repaint();
        panel.repaint();
    }

    public CirclesPanel getPanel() {
        return panel;
    }
}
