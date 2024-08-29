import java.util.Collection;
import java.util.Collections;

public class SpellBook extends MagicBook {
    private int magicPoint;

    public SpellBook(String id, String title, String author, int magicPoint) {
        super(id, title, author);
        this.magicPoint = magicPoint;
    }

    @Override
    public void read(User user) {
        user.addMagicPoint(magicPoint);
        System.out.println("User now has Magic power of " + user.getMagicPoint() + " and Dark magic power of " + user.getDarkMagicPoint());
    }

    @Override
    public Collection<? extends Action> allowableActions() {
        return Collections.emptyList(); // Simplified for example
    }

    @Override
    public String toString() {
        return super.toString() + " | Magic Point: " + magicPoint;
    }
}
