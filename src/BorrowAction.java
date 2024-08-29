public class BorrowAction extends Action {
    private Borrowable book;

    public BorrowAction(Borrowable book) {
        this.book = book;
    }

    @Override
    public String execute(User user) {
        book.borrow(user);
        return "The book has been borrowed.";
    }

    @Override
    public String menuDescription() {
        return "Borrow book: " + ((MagicBook) book).getTitle();
    }
}
