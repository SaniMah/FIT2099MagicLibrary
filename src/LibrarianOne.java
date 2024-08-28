import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LibrarianOne implements ActionCapable {
    private final List<String> monologues = new ArrayList<>();
    private final String name = "Librarian";

    public LibrarianOne() {
        monologues.add("We are only as strong as we are united, as weak as we are divided.");
        monologues.add("Words are, in my not-so-humble opinion, our most inexhaustible source of magic.");
        monologues.add("While we may come from different places and speak in different tongues, our hearts beat as one.");
        monologues.add("It is our choices, Harry, that show what we truly are, far more than our abilities.");
    }

    public String getName() {
        return name;
    }

    public String speak() {
        return monologues.get(new Random().nextInt(monologues.size()));
    }

    @Override
    public List<Action> allowableActions() {
        List<Action> actions = new ArrayList<>();
        actions.add(new TalkAction(this));
        return actions;
    }
}

