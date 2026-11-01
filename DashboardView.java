import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;

public class DashboardView extends JFrame {
    private JPanel contenedor;
    private JButton botonActualizar;

    public DashboardView(List<Renderizable> widgets) {
        setTitle("Dashboard de widgets");
        setSize(1100, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel barraSuperior = new JPanel();
        barraSuperior.add(new JLabel("Mi Dashboard"));

        botonActualizar = new JButton("Actualizar");
        barraSuperior.add(botonActualizar);

        add(barraSuperior, BorderLayout.NORTH);

        contenedor = new JPanel(new GridLayout(0, 1, 10, 10));
        contenedor.setBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        );

        add(new JScrollPane(contenedor), BorderLayout.CENTER);

        mostrarWidgets(widgets);
    }

    public void alActualizar(ActionListener accion) {
        botonActualizar.addActionListener(accion);
    }

    public void mostrarWidgets(List<Renderizable> widgets) {
        contenedor.removeAll();

        for (Renderizable widget : widgets) {
            contenedor.add(widget.obtenerVista());
        }

        contenedor.revalidate();
        contenedor.repaint();
    }
}