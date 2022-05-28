import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Panel1 extends JPanel {

    private List<Kolo> kola;

    public Panel1(List<Kolo> kola, int width, int height) {
        this.kola = kola;
        setBackground(Color.GRAY);
        setPreferredSize(new Dimension(width, height));

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Kolo kolo : kola) {
            kolo.rysuj(g);
        }
    }

}
