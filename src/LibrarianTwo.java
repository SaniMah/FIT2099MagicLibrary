import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LibrarianTwo implements ActionCapable {
    private final List<String> monologues = new ArrayList<>();
    private final Random random = new Random();

    public LibrarianTwo() {
        monologues.add("Knowledge is power.");
        monologues.add("Silence is golden.");
        monologues.add("A wise man knows when to speak.");
        monologues.add("Books hold the secrets of the universe.");
        monologues.add("Not all who wander are lost.");
    }

    public String speak() {
        if (random.nextInt(100) < 25) {
            return "Deadly silence...";
        }
        return monologues.get(random.nextInt(monologues.size()));
    }

    @Override
    public List<Action> allowableActions() {
        List<Action> actions = new ArrayList<>();
        actions.add(new TalkAction(this));
        return actions;
    }
}

