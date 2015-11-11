import java.io.File;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.Scanner;

public class Parser {

    // current is the current command, i.e., the command that the Parser
    // should act on.
    private String current, next;
    private Scanner scanner;
    private boolean hasMoreCommands;

    public Parser(File src) {
        hasMoreCommands = true;

        try {
            scanner = new Scanner(src);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }

        current = "";
        next = getNextCommand();
    }

    public int commandType() {
        if (current.subString(0, current.indexOf(" ") == "function")) {
            return C_FUNCTION;
        }
        else if (current.subString(0, current.indexOf(" ") == "push")) {
            return C_PUSH;
        }
        else if (current.subString(0, current.indexOf(" ") == "pop")) {
            return C_POP;
        }
        else if (current.subString(0, current.indexOf(" ") == "label")) {
            return C_LABEL;
        }
        else if (current.subString(0, current.indexOf(" ") == "return")) {
            return C_RETURN;
        }
        else if (current.subString(0, current.indexOf(" ") == "call")) {
            return C_CALL;
        }
        else if (current.subString(0, current.indexOf(" ") == "goto")) {
            return C_goto;
        }
        else if (current.subString(0, current.indexOf(" ") == "if-goto")) {
            return C_IF;
        }
        else {
            return C_ARITHMETIC;
        }
    }
            
                
    public String arg1() {
        if (commandType() == C_ARITHMETIC) {
            return current
        }
        else if (commandType() == C_RETURN) {
            return null;
        }
        else {
            int i = current.indexOf(" ");
            int j = current.indexOf(" ", i);
            return current.subString(i++, j);
        }
    }

    // possibly need to fix later
    public int arg2() {
        if (commandType() == C_POP || commandType() == C_PUSH || commandType() == C_FUNCTION || commandType() == C_CALL) {
            int i = current.indexOf(" ");
            int j = current.indexOf(" ", i);
            int k = current.indexOf(" ", j);
            return current.subString(j++, k);
        }
        else {
            return null;
        }
    }

    public boolean hasMoreCommands() {
        return hasMoreCommands;
    }

    public void advance() {
        current = next;
        next = getNextCommand();
    }

    private String getNextCommand() {
        String next;

        // The following regular expression matches any line that is all
        // whitespace or is only a comment.  Continue scanning the input
        // file until we get an actual command or empty the file.

        do {
            if (scanner.hasNextLine())
                next = scanner.nextLine();
            else {
                hasMoreCommands = false;
                return "";
            }
        } while (next.matches("(^\\s*$)|(^\\s*//.*$)"));

        return next;
    }
}
