import java.util.Random;

public class Utility {

    private static final Random random = new Random();

    /**
     * Generates a random integer between the specified lower and upper bounds (inclusive) and returns it as a String.
     *
     * @param lower the lower bound of the random integer.
     * @param upper the upper bound of the random integer.
     * @return a random integer between lower and upper (inclusive) as a String.
     * @throws IllegalArgumentException if the lower bound is greater than or equal to upper bound.
     */
    public static String generateRandomInt(int lower, int upper) {
        if (lower > upper) {
            throw new IllegalArgumentException("Lower bound must be less than or equal to upper bound.");
        }
        int randomInt = random.nextInt((upper - lower) + 1) + lower;
        return String.valueOf(randomInt);
    }
}


