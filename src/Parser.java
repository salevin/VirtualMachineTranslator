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
        if (current.indexOf(" ") != -1)
            com = current.substring(0, current.indexOf(" "));
        else 
            com = current;

        switch(com) {
            case "function":
                return CommandType.C_FUNCTION;
            case "push":
                return CommandType.C_PUSH;
            case "pop":
                return CommandType.C_POP;
            case "label":
                return CommandType.C_LABEL;
            case "return":
                return CommandType.C_RETURN;
            case "call":
                return CommandType.C_CALL;
            case "goto":
                return CommandType.C_GOTO;
            case "if-goto":
                return CommandType.C_IF;
            default:
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
            int i = current.indexOf(" ") + 1;
            int j = current.indexOf(" ", i) + 1;
            String sub = current.substring(i, j-1);
            return sub;
        }
    }

    public int arg2() {
        if (commandType() == CommandType.C_POP || commandType() == CommandType.C_PUSH ||
              commandType() == CommandType.C_FUNCTION || commandType() == CommandType.C_CALL) {
            int i = current.indexOf(" ") + 1;
            int j = current.indexOf(" ", i) + 1;
            String sub = current.substring(j);
            return Integer.parseInt(sub);
        }
        else {
            System.out.println("Error in arg2");
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
