import javax.swing.JComponent;

public interface Renderizable {
    void dibujarContenido(String contenido);

    JComponent obtenerVista();
}