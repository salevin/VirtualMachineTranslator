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

    public CommandType commandType() {
        String com;
        if (current.contains(" "))
            com = current.substring(0, current.indexOf(" "));
        else
            com = current;

        if (com == "function") {
            return CommandType.C_FUNCTION;
        }
        else if (com == "push") {
            return CommandType.C_PUSH;
        }
        else if (com == "pop") {
            return CommandType.C_POP;
        }
        else if (com == "label") {
            return CommandType.C_LABEL;
        }
        else if (com == "return") {
            return CommandType.C_RETURN;
        }
        else if (com == "call") {
            return CommandType.C_CALL;
        }
        else if (com == "goto") {
            return CommandType.C_GOTO;
        }
        else if (com == "if-goto") {
            return CommandType.C_IF;
        }
        else {
            return CommandType.C_ARITHMETIC;
        }
    }
            
                
    public String arg1() {
        if (commandType() == CommandType.C_ARITHMETIC) {
            return current;
        }
        else if (commandType() == CommandType.C_RETURN) {
            return null;
        }
        else {
            int i = current.indexOf(" ");
            int j = current.indexOf(" ", i);
            return current.substring(i++, j);
        }
    }

    public int arg2() {
        if (commandType() == CommandType.C_POP || commandType() == CommandType.C_PUSH ||
              commandType() == CommandType.C_FUNCTION || commandType() == CommandType.C_CALL) {
            int i = current.indexOf(" ");
            int j = current.indexOf(" ", i);
            int k = current.indexOf(" ", j);
            return Integer.getInteger(current.substring(j++, k));
        }
        else {
            return -1;
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
