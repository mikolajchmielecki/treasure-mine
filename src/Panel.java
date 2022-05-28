import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Panel extends JPanel {

    private List<KoloThread> kola;

    public Panel(List<KoloThread> kola, int width, int height) {
        this.kola = kola;
        setBackground(Color.GRAY);
        setPreferredSize(new Dimension(width, height));

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (KoloThread kolo : kola) {
            kolo.getKolo().rysuj(g);
        }
    }


}
