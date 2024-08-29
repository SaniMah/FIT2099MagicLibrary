import java.util.*;

public class Menu {

    /**
     * Displays a menu of actions, allowing the user to select one by typing the corresponding letter.
     *
     * @param actions A list of Action objects that represent the possible actions the user can take.
     * @return The Action selected by the user.
     */
    public static Action showMenu(List<Action> actions) {
        Scanner scanner = new Scanner(System.in);
        List<Character> freeChars = new ArrayList<>();
        Map<Character, Action> keyToActionMap = new HashMap<>();

        // Fill the list of freeChars with letters from 'a' to 'z'
        for (char j = 'a'; j <= 'z'; j++) {
            freeChars.add(j);
        }

        // Associate each action with a character and map it
        for (Action action : actions) {
            char c = freeChars.get(0);
            freeChars.remove(Character.valueOf(c));
            keyToActionMap.put(c, action);
            System.out.println(c + ": " + action.menuDescription());
        }

        char key;
        do {
            key = scanner.next().charAt(0);
        } while (!keyToActionMap.containsKey(key));

        return keyToActionMap.get(key);
    }
}
