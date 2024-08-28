import java.util.Collection;
import java.util.List;

public class DarkArtBook extends MagicBook{
    private int darkMagicPoint;
    private Status status;

    public DarkArtBook(String id, String title, String author, int darkMagicPoint) {
        super(id, title, author);
        this.darkMagicPoint = darkMagicPoint;
        this.status = Status.CURSED;
    }


    @Override
    public void read(User user) {
        user.addDarkMagicPoint(this.darkMagicPoint);
        user.addCapability(this.status);
    }

    @Override
    public Collection<? extends Action> allowableActions() {
        return List.of();
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Dark Magic Point: %d", darkMagicPoint);
    }
}

