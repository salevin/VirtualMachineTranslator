/**
 * Created by sam on 11/11/15.
 */
public class ArithmeticType {

    private static int counter = 0;

    static String ADD =
            "@SP\n" +
                    "AM=M-1\n" +
                    "D=M\n" +
                    "A=A-1\n" +
                    "M=D+M\n";

    static String SUB =
            "@SP\n" +
                    "AM=M-1\n" +
                    "D=M\n" +
                    "A=A-1\n" +
                    "M=D|M\n";
    static String EQ =
            "@SP\n" +
                    "AM=M-1\n" +
                    "D=M\n" +
                    "A=A-1\n" +
                    "M=D|M\n";
    static String AND =
            "@SP\n" +
                    "AM=M-1\n" +
                    "D=M\n" +
                    "A=A-1\n" +
                    "M=D&M\n";
    static String LT =
            "@SP\n" +
                    "AM=M-1\n" +
                    "D=M\n" +
                    "A=A-1\n" +
                    "M=D|M\n";
    static String GT =
            "@SP\n" +
                    "AM=M-1\n" +
                    "D=M\n" +
                    "A=A-1\n" +
                    "M=D|M\n";
    static String NEG =
            "@SP\n" +
                    "AM=M-1\n" +
                    "D=M\n" +
                    "A=A-1\n" +
                    "M=D|M\n";
    static String NOT =
            "@SP\n" +
                    "AM=M-1\n" +
                    "D=M\n" +
                    "A=A-1\n" +
                    "M=D|M\n";
    static String OR =
            "@SP\n" +
                    "AM=M-1\n" +
                    "D=M\n" +
                    "A=A-1\n" +
                    "M=D|M\n";

    public static String EQ() {
        counter++;

        return
                "@SP\n" +
                        "AM=M-1\n" +
                        "D=M\n" +
                        "A=A-1\n" +
                        "D=M-D\n" +
                        "@JUMPEQ" + counter + "\n" +
                        "D;JEQ\n" +
                        "@SP\n" +
                        "A=M-1\n" +
                        "M=0\n" +
                        "@END" + counter + "\n" +
                        "0;JMP\n" +
                        "(JUMPEQ" + counter + ")\n" +
                        "@SP\n" +
                        "A=M-1\n" +
                        "M=-1\n" +
                        "(END" + counter + ")\n";
    }

    public static String GT() {
        counter++;

        return
                "@SP \n" +
                        "AM=M-1 \n" +
                        "D=M \n" +
                        "A=A-1 \n" +
                        "D=M-D \n" +
                        "@JUMPGT" + counter + "\n" +
                        "D;JGT \n" +
                        "@SP\n" +
                        "A=M-1 \n" +
                        "M=0 \n" +
                        "@END" + counter + "\n" +
                        "0;JMP \n" +
                        "(JUMPGT" + counter + ") \n" +
                        "@SP\n" +
                        "A=M-1 \n" +
                        "M=-1 \n" +
                        "(END" + counter + ")\n";
    }

    static String LT() {
        counter++;
        return
                "@SP \n" +
                        "AM=M-1 \n" +
                        "D=M \n" +
                        "A=A-1 \n" +
                        "D=M-D \n" +
                        "@JUMPLT" + counter + "\n" +
                        "D;JLT \n" +
                        "@SP\n" +
                        "A=M-1 \n" +
                        "M=0 \n" +
                        "@END" + counter + "\n" +
                        "0;JMP \n" +
                        "(JUMPLT" + counter + ") \n" +
                        "@SP\n" +
                        "A=M-1 \n" +
                        "M=-1 \n" +
                        "(END" + counter + ") \n";
    }

}
