
import java.io.FileWriter;
import java.io.IOException;

public class CodeWriter {

    private FileWriter asmFile;
    private String fileName = "";
    private String functionName = "";
    private int incr = 0;

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

    public void writeInit() {
        writeCode("@256\n" +
                  "D=A\n" +
                  "@SP\n" +
                  "M=D\n");
        writeCall("Sys.init", 0);
    }

    public void writeLabel(String label) {
        writeCode("(" + functionName + "$" + label + ")\n");
    }

    public void writeGoTo(String label) {
        writeCode("@" + functionName + "$" + label + "\n" +
                "0;JMP\n");
    }

    public void writeIf(String label) {
        writeCode("@SP\n" +
                "AM=M-1\n" +
                "D=M\n" +
                "@" + label + "\n" +
                "D;JNE\n");
    }

    public void writeCall(String functionName, Integer numArgs) {
        String label = functionName + "$" + incr;
        writeCode(CallWriter.RET_ADDR(label) +
                  CallWriter.LCL +
                  CallWriter.ARG +
                  CallWriter.THS +
                  CallWriter.THT +
                  CallWriter.MISC(numArgs));
        writeGoTo(functionName);
        writeLabel(label);
        incr++;
    }

    public void writeReturn() {
       writeCode(ReturnWriter.RETURN);
    }

    public void writeFunction(String functionName, Integer numLocals) {
        this.functionName = functionName;
        writeCode("(" + functionName +  ")\n");
        for (int i = 0; i < numLocals; i++) {
            writeCode("@0\n" +
                      "D=A\n" +
                      "@SP\n" +
                      "AM=M+1\n" +
                      "A=A-1\n" +
                      "M=D\n");
        }
    }

    public void writeArithmetic(String command) {
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
            }
            default: {
                System.out.println("Error in arithmetic segment string");
            }
        }
    }

    public void WritePushPop(CommandType command, String segment, Integer index) {
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
                    writeCode(PushWriter.TEMP(index + 5));
                    break;
                }
                case "pointer": {
                    writeCode(PushWriter.POINTER(index));
                    break;
                }
                case "static": {
                    writeCode(PushWriter.STATIC(index));
                    break;
                }
                default: {
                    System.out.println("Error in Push segment string");
                    break;
                }

            }
        } else if (command == CommandType.C_POP) {
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
                    writeCode(PopWriter.TEMP(index + 5));
                    break;
                }
                case "pointer": {
                    writeCode(PopWriter.POINTER(index));
                    break;
                }
                case "static": {
                    writeCode(PopWriter.STATIC(index));
                    break;
                }
                default: {
                    System.out.println("Error in Pop segment string");
                    break;
                }

            }
        } else {
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
