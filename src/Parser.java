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
