/**
 * Created by sam on 12/4/15.
 */
public class CallWriter {
    public static String RET_ADDR(String label) {
        return "@" + label + "\n" +
                "D=A\n" +
                "@SP\n" +
                "AM=M+1\n" +
                "A=A-1\n" +
                "M=D\n";
    }

    static String LCL =
            "@LCL\n" +
                    "D=M\n" +
                    "@SP\n" +
                    "AM=M+1\n" +
                    "A=A-1\n" +
                    "M=D\n";

    static String ARG =
            "@ARG\n" +
                    "D=M\n" +
                    "@SP\n" +
                    "AM=M+1\n" +
                    "A=A-1\n" +
                    "M=D\n";

    static String THS =
            "@THIS\n" +
                    "D=M\n" +
                    "@SP\n" +
                    "AM=M+1\n" +
                    "A=A-1\n" +
                    "M=D\n";

    static String THT =
            "@THAT\n" +
                    "D=M\n" +
                    "@SP\n" +
                    "AM=M+1\n" +
                    "A=A-1\n" +
                    "M=D\n";

    static String MISC(Integer numArgs) {
        return "@SP\n" +
                "D=M\n" +
                "@" + (numArgs + 5) + "\n" +
                "D=D-A\n" +
                "@ARG\n" +
                "M=D\n" +
                "@SP\n" +
                "D=M\n" +
                "@LCL\n" +
                "M=D\n";
    }

}
