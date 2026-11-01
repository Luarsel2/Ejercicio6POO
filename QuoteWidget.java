import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class QuoteWidget implements InterfazWidget, Renderizable {
    private String frase;

    public QuoteWidget() {
        this("Haz lo que puedas, con lo que tienes, donde estés.");
    }

    public QuoteWidget(String frase) {
        this.frase = frase;
    }

    @Override
    public void mostrarMensaje(String mensaje) {
        System.out.println("[QuoteWidget] " + mensaje);
    }

    @Override
    public void dibujarContenido(String contenido) {
        System.out.println(contenido        );
    }

    public String obtenerFrase() {
        return frase;
    }

    @Override
    public String toString() {
        return "Frase del día: " + frase;
    }
    @Override
    public JComponent obtenerVista() {
    JPanel panel = new JPanel();
    JLabel etiquetaFrase = new JLabel("Frase del día: " + frase);

    panel.add(etiquetaFrase);

    return panel;
}
}
