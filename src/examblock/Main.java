package examblock;

/**
 * Provides the main method for the whole application.
 */
public class Main {

    /**
     * The main method for the whole application.
     *
     * @param args - command-line arguments (not used)
     */
    public static void main(String[] args) {
        ExamBlock block = new ExamBlock(); // Instantiates a new ExamBlock called block.
        block.manage(); // Executes block's manage() method.
    }
}