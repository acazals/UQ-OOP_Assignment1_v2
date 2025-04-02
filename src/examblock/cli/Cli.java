package examblock.cli;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Provides a basic Command-Line Interface (CLI).
 * Handles providing options to the user and checking which option they picked.
 * <p>
 * Modified from code by James Baker, EECS Principal Software Engineer, UQ.
 * </p>
 */
public class Cli {

    /**
     * Prompts the user to pick an option from a collection provided as an ArrayList.
     * <p>
     *     (overloaded method with different parameter types)
     * </p>
     *
     * @param <T> the type of values in the options collection.
     * @param options the ArrayList containing options.
     * @return The chosen option.
     */
    public <T> T pickOptionFromCollection(List<T> options) {
        List<T> internalOptions = new ArrayList<>(options);
        CliMenu<T> menu = new CliMenu<>(internalOptions);
        return menu.getAllocation();
    }

    /**
     * Prompts the user to pick an option from a collection provided as a HashMap.
     * <p>
     *     (overloaded method with different parameter types)
     * </p>
     *
     * @param <T> the type of values in the options collection.
     * @param options the HashMap containing options as keys and values.
     * @return The value corresponding to the chosen key.
     */
    public <T> T pickOptionFromCollection(HashMap<String, T> options) {
        HashMap<String, T> internalOptions = new HashMap<>(options);
        CliMenu<T> menu = new CliMenu<>(internalOptions);
        return menu.getAllocation();
    }

    /**
     * Prompts the user to enter an input.
     *
     * @return The user's input as a String.
     */
    public String getStringInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter input: ");
        return scanner.nextLine();
    }

    /**
     * Prints blank lines to the console.
     *
     * @param lines the number of blank lines to print.
     */
    public void blank(int lines) {
        for (int i = 0; i < lines; i++) {
            System.out.println("\n");
        }
    }

    /**
     * A local main method to demonstrate the usage of the cli class.
     *
     * @param args command-line arguments (not used).
     */
    public static void main(String[] args) {
        Cli cli = new Cli();
        ArrayList<String> options = new ArrayList<>();
        options.add("Option 1");
        options.add("Option 2");
        options.add("Option 3");

        String pickedOption = cli.pickOptionFromCollection(options);
        System.out.println("Picked option: " + pickedOption);

        HashMap<String, String> optionMap = new HashMap<>();
        optionMap.put("A", "Option A");
        optionMap.put("B", "Option B");
        optionMap.put("C", "Option C");

        String pickedOptionFromMap = cli.pickOptionFromCollection(optionMap);
        System.out.println("Picked option from map: " + pickedOptionFromMap);
    }
}