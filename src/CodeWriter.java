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
            // System.out.println(command);
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
                    break;
                }
                case "local": {
                    writeCode(PushWriter.LOCAL(index));
                    break;
                }
                case "argument": {
                    writeCode(PushWriter.ARGUMENT(index));
                    break;
                }
                case "this": {
                    writeCode(PushWriter.THIS(index));
                    break;
                }
                case "that": {
                    writeCode(PushWriter.THAT(index));
                    break;
                }
                case "temp": {
                    writeCode(PushWriter.TEMP(index));
                    break;
                }
                case "pointer": {
                    writeCode(PushWriter.POINTER());
                    break;
                }
                default: {
                        System.out.println("Error in Push segment string");
                    break;
                }

            }
        }
        else if (command == CommandType.C_POP) {
            switch (segment) {
                case "local": {
                    writeCode(PopWriter.LOCAL(index));
                    break;
                }
                case "argument": {
                    writeCode(PopWriter.ARGUMENT(index));
                    break;
                }
                case "this": {
                    writeCode(PopWriter.THIS(index));
                    break;
                }
                case "that": {
                    writeCode(PopWriter.THAT(index));
                    break;
                }
                case "temp": {
                    writeCode(PopWriter.TEMP(index));
                    break;
                }
                case "pointer": {
                    writeCode(PopWriter.POINTER());
                    break;
                }
                default: {
                    System.out.println("Error in Pop segment string");
                    break;
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
