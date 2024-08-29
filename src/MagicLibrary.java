import java.util.ArrayList;
import java.util.List;

public class MagicLibrary {

    private List<MagicBook> books = new ArrayList<>();

    // Method to create and add books to the library
    public void createBooks() {
        books.add(new SpellBook("1", "Charms of Defence and Deterrence", "Catullus Spangle", 10));
        books.add(new SpellBook("2", "Essential Defence Against the Dark Arts", "Arsenius Jigger", 10));
        books.add(new HerbAndPotionBook("3", "Goshawk's Guide to Herbology", "Miranda Goshawk", 5));
        books.add(new HerbAndPotionBook("4", "Magical Drafts and Potions", "Arsenius Jigger", 15));
        books.add(new DarkArtBook("6", "Magick Moste Evile", "Godelot", 20));
        books.add(new DarkArtBook("7", "Secrets of the Darkest Art", "Owle Bullock", 30));
    }

    // Method to add actions to the menu and allow the user to select an action
    public void addActionsToMenu(User user) {
        while (!user.isComplete()) {
            List<Action> actions = new ArrayList<>();
            List<ActionCapable> actionCapables = new ArrayList<>();

            // Add LibrarianOne and all magicBooks to actionCapables
            actionCapables.add(new LibrarianOne());
            actionCapables.addAll(books);

            // Gather all allowable actions from each ActionCapable object
            for (ActionCapable capable : actionCapables) {
                actions.addAll(capable.allowableActions());
            }

            // Add ExitAction separately
            actions.add(new ExitAction());

            System.out.println("###############################################");

            // Use the Menu class to show the menu and return the selected action
            Action selectedAction = Menu.showMenu(actions);

            // Execute the selected action
            System.out.println(selectedAction.execute(user));
        }
    }

    // Main method to run the library's functionality
    public void printStatus() {
        System.out.println("Welcome to Hogwarts Library of FIT2099");
        createBooks(); // Create the books
        User user = new User(); // Create a new user
        addActionsToMenu(user); // Add actions to the menu and execute selected action
        System.out.println("Thank you for visiting Hogwarts Library of FIT2099!");
    }
}
