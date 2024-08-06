public class MagicLibrary {
    private MagicBook[] books;

    public MagicLibrary() {
        createBooks();
    }

    private void createBooks() {
        books = new MagicBook[8];
        books[0] = new SpellBook("1", "Charms of Defence and Deterrence", "Catullus Spangle", 50);
        books[1] = new SpellBook("2", "Essential Defence Against the Dark Arts", "Arsenius Jigger", 60);
        books[2] = new HerbAndPotionBook("3", "Goshawk's Guide to Herbology", "Miranda Goshawk", 40);
        books[3] = new HerbAndPotionBook("4", "Magical Drafts and Potions", "Arsenius Jigger", 45);
        books[4] = new AncientMagicBook("5", "Hogwarts: A History", "Bathilda Bagshot", 70);
        books[5] = new AncientMagicBook("6", "Scars of Salem: Essays on the Witch Trials of 1692", "Carlos Eduardos", 65);
        books[6] = new DarkArtBook("7", "Magick Moste Evile", "Godelot", 90);
        books[7] = new DarkArtBook("8", "Secrets of the Darkest Art", "Owle Bullock", 95);
    }

    public void displayBooks() {
        for (MagicBook book : books) {
            System.out.println(book);
        }
    }

    public void printStatus() {
        System.out.println("Welcome to the Magic Library!");
        displayBooks();
        System.out.println("Thank you for visiting Hogwarts Library of FIT2099");
    }
}
