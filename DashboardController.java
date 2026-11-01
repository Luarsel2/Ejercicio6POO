import java.time.LocalDate;
import javax.swing.SwingUtilities;

public class DashboardController {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Dashboard dashboard = new Dashboard();

            WidgetClima widget = new WidgetClima(
                    "Guatemala",
                    24.5f,
                    "Buena",
                    12.0f,
                    52.0f,
                    3.0f
            );

            ClockWidget reloj = new ClockWidget();

            QuoteWidget frase = new QuoteWidget(
                    "El éxito llega a quienes siguen intentándolo."
            );

            TaskWidget tarea1 = new TaskWidget(
                    "Revisión de requisitos",
                    "Validar requisitos del cliente",
                    "T-101",
                    LocalDate.now().minusDays(1)
            );

            TaskWidget tarea2 = new TaskWidget(
                    "Preparar presentación",
                    "Montar demo del proyecto",
                    "T-102",
                    LocalDate.now().plusDays(2)
            );

            AlertWidget alertWidget = new AlertWidget();
            alertWidget.agregarTarea(tarea1);
            alertWidget.agregarTarea(tarea2);

            dashboard.agregarWidget(widget);
            dashboard.agregarWidget(reloj);
            dashboard.agregarWidget(frase);
            dashboard.agregarWidget(tarea1);
            dashboard.agregarWidget(tarea2);
            dashboard.agregarWidget(alertWidget);

            DashboardView ventana = new DashboardView(
                    dashboard.getWidgets()
            );
            ventana.alActualizar(e -> {
         ventana.mostrarWidgets(dashboard.getWidgets());
});
            ventana.setVisible(true);
        });
    }
}