public class ReadAction extends Action {

    private MagicBook magicBook;

    // Constructor to initialize the magicBook
    public ReadAction(MagicBook magicBook) {
        this.magicBook = magicBook;
    }

    @Override
    public String execute(User user) {
        magicBook.read(user);  // This method will update user’s magic points
        int userNewMagicPoint = user.getMagicPoint();
        int userNewDarkMagicPoint = user.getDarkMagicPoint();

        return "User has read the book and now has " + userNewMagicPoint + " magic points and " + userNewDarkMagicPoint + " dark magic points.";
    }

    @Override
    public String menuDescription() {
        return "Read book " + this.magicBook;
    }
}

