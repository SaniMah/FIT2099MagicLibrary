import java.util.Scanner;

public class TalkAction extends Action {
    private final ActionCapable librarian;

    public TalkAction(ActionCapable librarian) {
        this.librarian = librarian;
    }

    @Override
    public String execute(User user) {
        if (librarian instanceof GeminiLibrarian) {
            System.out.print("Enter your prompt: ");
            Scanner scanner = new Scanner(System.in);
            String prompt = scanner.nextLine();
            return ((GeminiLibrarian) librarian).speak(prompt);
        } else if (librarian instanceof LibrarianTwo) {
            return ((LibrarianTwo) librarian).speak();
        } else {
            return librarian.speak(); // Assuming speak() method is available in all librarians
        }
    }

    @Override
    public String menuDescription() {
        return "Talk to " + librarian.getClass().getSimpleName();
    }
}
