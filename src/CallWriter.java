/**
 * Created by sam on 12/4/15.
 */
public class CallWriter {
    public static String RET_ADDR(String label) {
        return "@" + label + "\n" +
                "D=A\n" +
                "@SP\n" +
                "AM = M+1\n" +
                "A=A-1\n" +
                "M=D\n";
    }

    static String LCL =
        "@LCL" +
                "D=A\n" +
                "@SP\n" +
                "AM = M+1\n" +
                "A=A-1\n" +
                "M=D\n";

    static String ARG =
        "@ARG" +
                "D=A\n" +
                "@SP\n" +
                "AM = M+1\n" +
                "A=A-1\n" +
                "M=D\n";

    static String THS =
            "@THIS" +
                "D=A\n" +
                "@SP\n" +
                "AM = M+1\n" +
                "A=A-1\n" +
                "M=D\n";

    static String THT =
            "@THAT" +
                "D=A\n" +
                "@SP\n" +
                "AM = M+1\n" +
                "A=A-1\n" +
                "M=D\n";

}
