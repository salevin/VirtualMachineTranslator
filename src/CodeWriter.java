import java.io.FileWriter;
import java.io.IOException;

public class CodeWriter {

	private FileWriter asmFile;
	private String fileName = "";
	private String functionName = "";

	public CodeWriter(String basename) {
		try {  // Open the ASM file for writing.
			asmFile = new FileWriter(basename + ".asm");
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
		functionName = "";
	}

	// You might find this useful.
	// Write a sequence of ASM code to the ASM file.
	// The parameter code is expected to contain all necessary newline
	// characters.
	private void writeCode(String code) {
		try {
			asmFile.write(code);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void writeArithmetic(String command){
        switch (command) {
            case "add": {
                writeCode(ArithmeticType.ADD);
                break;
            }
            case "sub": {
                writeCode(ArithmeticType.SUB);
                break;
            }
            case "eq": {
                writeCode(ArithmeticType.EQ());
                break;
            }
            case "and": {
                writeCode(ArithmeticType.AND);
                break;
            }
            case "lt": {
                writeCode(ArithmeticType.LT());
                break;
            }
            case "gt": {
                writeCode(ArithmeticType.GT());
                break;
            }
            case "neg": {
                writeCode(ArithmeticType.NEG);
                break;
            }
            case "not": {
                writeCode(ArithmeticType.NOT);
                break;
            }
            case "or": {
                writeCode(ArithmeticType.OR);
                break;
            }
        }
	}

    public void WritePushPop(String command, String segment, Integer index){

    }

	public void close() {
		try {
			asmFile.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

}