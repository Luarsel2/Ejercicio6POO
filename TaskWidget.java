import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class TaskWidget implements InterfazWidget, Renderizable, Interactivo {
    private String nombreTask;
    private String descripcionTask;
    private String codigoTask;
    private LocalDate fechaEntrega;
    private boolean completada = false;

    public TaskWidget(String nombreTask, String descripcionTask, String codigoTask, LocalDate fechaEntrega) {
        this.nombreTask = nombreTask;
        this.descripcionTask = descripcionTask;
        this.codigoTask = codigoTask;
        this.fechaEntrega = fechaEntrega;
    }

    @Override
    public void mostrarMensaje(String mensaje) {
        System.out.println("[TaskWidget] " + mensaje);
    }

    @Override
    public void dibujarContenido(String contenido) {
        System.out.println(contenido);
    }

    public void fechaDeEntrega(LocalDate fecha) {
        this.fechaEntrega = fecha;
        System.out.println("Fecha de entrega actualizada: " + fecha);
    }

    public long diasRestantes() {
        return ChronoUnit.DAYS.between(LocalDate.now(), fechaEntrega);
    }

    public boolean estaVencida() {
    return !completada && fechaEntrega.isBefore(LocalDate.now());
}

public String getEstado() {
    if (completada) {
        return "Completada";
    } else if (estaVencida()) {
        return "Vencida";
    } else if (diasRestantes() <= 3) {
        return "Urgente";
    }
    return "Pendiente";
}

    public String getNombreTask() {
        return nombreTask;
    }

    public String getDescripcionTask() {
        return descripcionTask;
    }

    public String getCodigoTask() {
        return codigoTask;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setNombreTask(String nombreTask) {
        this.nombreTask = nombreTask;
    }

    public void setDescripcionTask(String descripcionTask) {
        this.descripcionTask = descripcionTask;
    }

    public void setCodigoTask(String codigoTask) {
        this.codigoTask = codigoTask;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    @Override
    public String toString() {
        return codigoTask + " - " + nombreTask + " | Fecha entrega: " + fechaEntrega + " | Estado: " + getEstado();
    }
    @Override
public void interactuar() {
    completada = true;
}

@Override
public JComponent obtenerVista() {
    JPanel panel = new JPanel();

    JLabel etiquetaTarea = new JLabel(toString());
    JButton botonCompletar = new JButton("Completar tarea");
    botonCompletar.setEnabled(!completada);

    botonCompletar.addActionListener(e -> {
        interactuar();
        etiquetaTarea.setText(toString());
        botonCompletar.setEnabled(false);
    });

    panel.add(etiquetaTarea);
    panel.add(botonCompletar);

    return panel;
}
}
