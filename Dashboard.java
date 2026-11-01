import java.util.ArrayList;
import java.util.List;

public class Dashboard {
    private List<Renderizable> widgets = new ArrayList<>();

    public void agregarWidget(Renderizable widget) {
        widgets.add(widget);
    }

    public List<Renderizable> getWidgets() {
        return new ArrayList<>(widgets);
    }
}   