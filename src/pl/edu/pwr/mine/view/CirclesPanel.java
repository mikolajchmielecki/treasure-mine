package pl.edu.pwr.mine.view;

import pl.edu.pwr.mine.model.Circle;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CirclesPanel extends JPanel {

    private List<Circle> kola;

    public CirclesPanel(List<Circle> circles, int width, int height) {
        this.kola = circles;
        setBackground(Color.GRAY);
        setPreferredSize(new Dimension(width, height));

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Circle circle : kola) {
            circle.draw(g);
        }
    }

}
