import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class MagicBook {

    private final String id;
    private final String title;
    private final String author;

    // Constructor with ID as String
    public MagicBook(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return String.format("ID: %s, Title: %s, Author: %s", id, title, author);
    }

    // Abstract method to be implemented by subclasses
    public abstract void read(User user);

    public void addActionsToMenu(User user) {
        while (!user.isComplete()) {
            List<Action> actions = new ArrayList<>();
            List<ActionCapable> actionCapables = new ArrayList<>();

            actionCapables.add((ActionCapable) user);
            actionCapables.add(new LibrarianOne());
            Collection<? extends ActionCapable> magicBooks = List.of();
            actionCapables.addAll(magicBooks);  // Assuming magicBooks is a collection of books

            for (ActionCapable actionCapable : actionCapables) {
                actions.addAll(actionCapable.allowableActions());
            }

            System.out.println("##############################");
            Action action = Menu.showMenu(actions);  // No need to wrap actions in Collections.singletonList
            System.out.println(action.execute(user));
        }
    }

    public abstract Collection<? extends Action> allowableActions();

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getID() {  // Fixed method to return the correct ID
        return id;
    }
}
