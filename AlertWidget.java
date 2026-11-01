import java.awt.BorderLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.util.ArrayList;
import java.util.List;

public class AlertWidget implements InterfazWidget, Renderizable {
    private List<TaskWidget> tareas;

    public AlertWidget() {
        this.tareas = new ArrayList<>();
    }

    public void agregarTarea(TaskWidget tarea) {
        tareas.add(tarea);
    }

    public String obtenerAlertas() {
    StringBuilder alertas = new StringBuilder();

    for (TaskWidget tarea : tareas) {
        String estado = tarea.getEstado();

        if (estado.equals("Vencida") || estado.equals("Urgente")) {
            alertas.append("ALERTA: ")
                    .append(tarea.getCodigoTask())
                    .append(" - ")
                    .append(tarea.getNombreTask())
                    .append(" | Fecha de entrega: ")
                    .append(tarea.getFechaEntrega())
                    .append(" | Estado: ")
                    .append(estado)
                    .append("\n");
        }
    }

    if (alertas.length() == 0) {
        return "No hay tareas próximas a vencer.";
    }

    return alertas.toString();
}

public void revisarAlertas() {
    System.out.println(obtenerAlertas());
}

    @Override
    public void mostrarMensaje(String mensaje) {
        System.out.println("[AlertWidget] " + mensaje);
    }

    @Override
    public void dibujarContenido(String contenido) {
        System.out.println(contenido);
    }
    @Override
public JComponent obtenerVista() {
    JPanel panel = new JPanel(new BorderLayout());

    JTextArea textoAlertas = new JTextArea(obtenerAlertas(), 5, 30);
    textoAlertas.setEditable(false);
    textoAlertas.setLineWrap(true);
    textoAlertas.setWrapStyleWord(true);

    panel.add(new JScrollPane(textoAlertas), BorderLayout.CENTER);

    return panel;
}
}