import java.util.List;

public interface ActionCapable {
    List<Action> allowableActions();

    String speak();
}
