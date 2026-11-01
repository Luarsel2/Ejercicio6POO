import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class WidgetClima implements InterfazWidget, Renderizable, Interactivo {    
    private float temperatura;
    private String calidadAire;
    private float viento;
    private float humedad;
    private float uv; 
    private String ciudad;
    private boolean mostrarEnFahrenheit = false;

    public WidgetClima() {
        this("Ciudad por defecto", 20.0f, "Buena", 10.0f, 3.0f, 3.0f);
    }

    public WidgetClima(String ciudad, float temperatura, String calidadAire, float viento, float humedad, float uv) {
        this.ciudad = ciudad;
        this.temperatura = temperatura;
        this.calidadAire = calidadAire;
        this.viento = viento;
        this.humedad = humedad;
        this.uv = uv;
    }

    @Override
    public void mostrarMensaje(String mensaje) {
        System.out.println("[WidgetClima] " + mensaje);
    }

    @Override
    public void dibujarContenido(String contenido) {
        System.out.println(contenido);
    }

    public void actualizarClima(String ciudad, float temperatura, String calidadAire, float viento, float humedad, float uv) {
        this.ciudad = ciudad;
        this.temperatura = temperatura;
        this.calidadAire = calidadAire;
        this.viento = viento;
        this.humedad = humedad;
        this.uv = uv;
    }

    public String obtenerResumen() {
    float temperaturaMostrada = mostrarEnFahrenheit
            ? temperatura * 9.0f / 5.0f + 32
            : temperatura;

    String unidad = mostrarEnFahrenheit ? "°F" : "°C";

    return "Ciudad: " + ciudad
            + " | Temperatura: " + temperaturaMostrada + unidad
            + " | Aire: " + calidadAire
            + " | Viento: " + viento + " km/h"
            + " | Humedad: " + humedad + "%"
            + " | UV: " + uv;
}

    @Override
    public String toString() {
        return obtenerResumen();
    }
    @Override
public void interactuar() {
    mostrarEnFahrenheit = !mostrarEnFahrenheit;
}

@Override
public JComponent obtenerVista() {
    JPanel panel = new JPanel();

    JLabel etiquetaClima = new JLabel(obtenerResumen());
    JButton botonCambiar = new JButton("Cambiar °C / °F");

    botonCambiar.addActionListener(e -> {
        interactuar();
        etiquetaClima.setText(obtenerResumen());
    });

    panel.add(etiquetaClima);
    panel.add(botonCambiar);

    return panel;
}
}
