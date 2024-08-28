import java.util.HashSet;
import java.util.Set;


public class User {
    private final Set<Status> capabilitySet = new HashSet<>();
    private int magicPoint;
    private int darkMagicPoint;
    private boolean complete;

    // Getter for magicPoint
    public int getMagicPoint() {
        return magicPoint;
    }

    // Setter for magicPoint
    public void setMagicPoint(int magicPoint) {
        this.magicPoint = magicPoint;
    }

    // Method to add magic points
    public void addMagicPoint(int value) {
        this.magicPoint += value;
    }

    // Method to deduct magic points
    public void deductMagicPoint(int value) {
        this.magicPoint -= value;
    }

    // Getter for darkMagicPoint
    public int getDarkMagicPoint() {
        return darkMagicPoint;
    }

    // Setter for darkMagicPoint
    public void setDarkMagicPoint(int darkMagicPoint) {
        this.darkMagicPoint = darkMagicPoint;
    }

    // Method to add dark magic points
    public void addDarkMagicPoint(int value) {
        this.darkMagicPoint += value;
    }

    // Method to deduct dark magic points
    public void deductDarkMagicPoint(int value) {
        this.darkMagicPoint -= value;
    }

    // Method to reset magic points
    public void resetMagicPoint() {
        this.magicPoint = 0;
    }



    public boolean hasCapability(Status capability) {
        return capabilitySet.contains(capability);
    }

    public void addCapability(Status capability) {
        if (!hasCapability(capability)) {
            capabilitySet.add(capability);
        }
    }

    public void removeCapability(Status capability) {
        if (hasCapability(capability)) {
            capabilitySet.remove(capability);
        }
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public void decreaseDarkMagicPoint(int magicPoint) {
    }
}
