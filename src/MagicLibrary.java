import java.util.ArrayList;
import java.util.List;

public class MagicLibrary {

    private List<MagicBook> books;

    public MagicLibrary() {
        createBooks();
    }

    // Method to create and add books to the list
    private void createBooks() {
        books = new ArrayList<>();
        books.add(new SpellBook("1", "Charms of Defence and Deterrence", "Catullus Spangle", 50));
        books.add(new SpellBook("2", "Essential Defence Against the Dark Arts", "Arsenius Jigger", 60));
        books.add(new HerbAndPotionBook("3", "Goshawk's Guide to Herbology", "Miranda Goshawk", 40));
        books.add(new HerbAndPotionBook("4", "Magical Drafts and Potions", "Arsenius Jigger", 45));
        books.add(new DarkArtBook("7", "Magick Moste Evile", "Godelot", 90));
        books.add(new DarkArtBook("8", "Secrets of the Darkest Art", "Owle Bullock", 95));
    }

    // Method to add actions to the menu and execute the selected action
    public void addActionsToMenu() {
        List<Action> actions = new ArrayList<>();

        for (MagicBook book : books) {
            actions.addAll(book.allowableActions());
        }

        System.out.println("#############################################");
        Action action = Menu.showMenu(actions);
        System.out.println(action.execute(new User()));  // Assuming a new user is passed here
    }

    // Method to display the list of books
    public void displayBooks() {
        for (MagicBook book : books) {
            System.out.println(book);
        }
    }

    // Method to print the status of the library and initiate user interaction
    public void printStatus() {
        System.out.println("Welcome to Hogwarts Library of FIT2099");
        displayBooks();
        addActionsToMenu();
        System.out.println("Thank you for visiting Hogwarts Library of FIT2099!");
    }
}
