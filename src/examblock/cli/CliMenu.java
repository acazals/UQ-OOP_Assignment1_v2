package examblock.cli;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * A helper class for the CLI that handles the menu display and option selection.
 *
 * Modified from code by James Baker, EECS Principal Software Engineer, UQ.
 *
 * @param <T> the type of values in the menu.
 */
public class CliMenu<T> {
    /**
     * keys
     */
    private final List<String> keys;
    /**
     * values
     */
    private final List<T> values;

    /**
     * Constructs a cliMenu with options provided as a HashMap.
     *
     * @param options the HashMap containing options as keys and corresponding values
     */
    public CliMenu(HashMap<String, T> options) {
        keys = new ArrayList<>(options.keySet());
        values = new ArrayList<>(options.values());
    }

    /**
     * Constructs a cliMenu with options provided as an ArrayList.
     *
     * @param options the ArrayList containing options
     */
    public CliMenu(List<T> options) {
        keys = new ArrayList<>();
        values = new ArrayList<>(options);
        for (int i = 0; i < options.size(); i++) {
            keys.add(String.valueOf(i + 1));
        }
    }

    /**
     * Prompts the user to pick an option from the menu.
     *
     * @return the chosen option
     */
    public T getAllocation() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice < 0 || choice >= values.size()) {
            System.out.println("Please pick an option:");
            for (int i = 0; i < keys.size(); i++) {
                System.out.println((i + 1) + ". " + values.get(i).toString());
            }
            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt() - 1;
            } else {
                scanner.next();
            }
        }
        return values.get(choice);
    }
}