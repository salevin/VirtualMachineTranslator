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
            }default: {
                System.out.println("Error in arithmetic segment string");
            }
        }
	}

    public void WritePushPop(CommandType command, String segment, Integer index){
        if (command == CommandType.C_PUSH) {
            switch (segment) {
                case "constant": {
                    writeCode(PushWriter.CONSTANT(index));
                }
                case "local": {
                    writeCode(PushWriter.LOCAL(index));
                }
                case "argument": {
                    writeCode(PushWriter.ARGUMENT(index));
                }
                case "this": {
                    writeCode(PushWriter.THIS(index));
                }
                case "that": {
                    writeCode(PushWriter.THAT(index));
                }
                case "temp": {
                    writeCode(PushWriter.TEMP(index));
                }
                case "pointer": {
                    writeCode(PushWriter.POINTER());
                }
                default: {
                    System.out.println("Error in Push segment string");
                }

            }
        }
        else if (command == CommandType.C_POP) {
            switch (segment) {
                case "local": {
                    writeCode(PopWriter.LOCAL(index));
                }
                case "argument": {
                    writeCode(PopWriter.ARGUMENT(index));
                }
                case "this": {
                    writeCode(PopWriter.THIS(index));
                }
                case "that": {
                    writeCode(PopWriter.THAT(index));
                }
                case "temp": {
                    writeCode(PopWriter.TEMP(index));
                }
                case "pointer": {
                    writeCode(PopWriter.POINTER());
                }
                default: {
                    System.out.println("Error in Pop segment string");
                }

            }
        }
        else {
            System.out.println("Error in WritePushPop");
        }
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
