import javax.swing.*;
import java.util.List;

public class Okienko1 extends JFrame {

    private Panel1 panel;

    public Okienko1(List<Kolo> kola, int width, int height) {
        panel = new Panel1(kola, width, height);
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

    public Panel1 getPanel() {
        return panel;
    }
}
