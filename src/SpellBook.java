import java.util.Collection;
import java.util.List;

public class SpellBook extends MagicBook {
    private final int magicPoint;

    public SpellBook(String id, String title, String author, int magicPoint) {
        super(id,title,author);
        this.magicPoint = magicPoint;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Magic Point: %d", magicPoint);
    }

    @Override
    public void read(User user) {

    }

    @Override
    public Collection<? extends Action> allowableActions() {
        return List.of();
    }
}

