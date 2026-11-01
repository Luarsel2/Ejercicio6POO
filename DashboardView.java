import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class DashboardView extends JFrame {

    public DashboardView(List<Renderizable> widgets) {
        setTitle("Dashboard de widgets");
        setSize(1100, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JLabel titulo = new JLabel(
                "Mi Dashboard",
                SwingConstants.CENTER
        );

        titulo.setBorder(
                BorderFactory.createEmptyBorder(15, 10, 5, 10)
        );

        add(titulo, BorderLayout.NORTH);

        JPanel contenedor = new JPanel(
                new GridLayout(0, 1, 10, 10)
        );

        contenedor.setBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        );

        for (Renderizable widget : widgets) {
            contenedor.add(widget.obtenerVista());
        }

        add(new JScrollPane(contenedor), BorderLayout.CENTER);
    }
}