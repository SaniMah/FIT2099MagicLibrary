import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MagicLibrary {

    private List<MagicBook> books = new ArrayList<>();


    public void createBooks() {
        books.add(new SpellBook("1", "Charms of Defence and Deterrence", "Catullus Spangle", 10));
        books.add(new SpellBook("2", "Essential Defence Against the Dark Arts", "Arsenius Jigger", 10));
        books.add(new HerbAndPotionBook("3", "Goshawk's Guide to Herbology", "Miranda Goshawk", 5));
        books.add(new HerbAndPotionBook("4", "Magical Drafts and Potions", "Arsenius Jigger", 15));
        books.add(new DarkArtBook("6", "Magick Moste Evile", "Godelot", 20));
        books.add(new DarkArtBook("7", "Secrets of the Darkest Art", "Owle Bullock", 30));
    }


    public void addActionsToMenu(User user) {
        while (!user.isComplete()) {
            List<Action> actions = new ArrayList<>();
            List<ActionCapable> actionCapables = new ArrayList<>();


            actionCapables.add((ActionCapable) new LibrarianOne());
            actionCapables.add((ActionCapable) new LibrarianTwo());
            actionCapables.add(new GeminiLibrarian());
            actionCapables.addAll((Collection<? extends ActionCapable>) books);


            for (ActionCapable capable : actionCapables) {
                actions.addAll(capable.allowableActions());
            }


            actions.add(new ExitAction());

            System.out.println("###############################################");


            Action selectedAction = Menu.showMenu(actions);


            System.out.println(selectedAction.execute(user));
        }
    }


    public void printStatus() {
        System.out.println("Welcome to Hogwarts Library of FIT2099");
        createBooks();
        User user = new User();
        addActionsToMenu(user);
        System.out.println("Thank you for visiting Hogwarts Library of FIT2099!");
    }
}
