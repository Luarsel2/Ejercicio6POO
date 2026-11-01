import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ClockWidget implements InterfazWidget, Renderizable {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Override
    public void mostrarMensaje(String mensaje) {
        System.out.println("[ClockWidget] " + mensaje);
    }

    @Override
    public void dibujarContenido(String contenido) {
        System.out.println(contenido);
    }

    public String obtenerHoraActual() {
        return LocalTime.now().format(formatter);
    }

    @Override
    public String toString() {
        return "Hora actual: " + obtenerHoraActual();
    }
    @Override
    public JComponent obtenerVista() {
    JPanel panel = new JPanel();
    JLabel etiquetaHora = new JLabel("Hora actual: " + obtenerHoraActual());

    panel.add(etiquetaHora);

    return panel;
}
}
