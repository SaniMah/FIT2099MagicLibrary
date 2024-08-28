import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class Menu {

    public static Action showMenu(List<Action> actions) {
        Scanner scanner = new Scanner(System.in);
        List<Character> freeChars = new ArrayList<>();
        Map<Character, Action> keyToActionMap = new HashMap<>();

        // Populate the freeChars list with alphabet characters
        for (char j = 'a'; j <= 'z'; j++) {
            freeChars.add(j);
        }

        // Map each action to a character and display it
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

