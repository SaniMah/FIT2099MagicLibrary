public class ReadAction extends Action {
    private MagicBook magicBook;  // Holds the reference to the MagicBook that this action is associated with.

    public ReadAction(MagicBook magicBook) {
        this.magicBook = magicBook;  // Initialize the magicBook instance variable with the provided MagicBook object.
    }

    @Override
    public String execute(User user) {
        // Call the read method of the MagicBook to perform the reading action.
        magicBook.read(user);

        // Get the updated magic and dark magic points from the user.
        int userNewMagicPoint = user.getMagicPoint();
        int userNewDarkMagicPoint = user.getDarkMagicPoint();

        // Return the result of the action as a String.
        return "User has read the book and now has " + userNewMagicPoint + " magic points and " + userNewDarkMagicPoint + " dark magic points.";
    }

    @Override
    public String menuDescription() {
        // Provide a description for this action to be shown in the menu.
        return "Read book: " + this.magicBook.getTitle();
    }
}
