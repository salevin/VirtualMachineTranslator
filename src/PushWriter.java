/**
 * Created by sam on 11/16/15.
 */
public class PushWriter {
    public static String CONSTANT(Integer index) {
        return "@" + index + "\n" +
                "D=A\n" +
                "@SP\n" +
                "A=M\n" +
                "M=D\n" +
                "@SP\n" +
                "M=M+1\n";
    }

    public static String ARGUMENT(Integer index) {
        return "@ARG\n" +
                "D=M\n" +
                "@" + index + "\n" +
                "A=D+A\n" +
                "D=M\n" +
                "@SP\n" +
                "A=M\n" +
                "M=D\n" +
                "@SP\n" +
                "M=M+1\n";
    }

    public static String THIS(Integer index) {
        return "@THIS\n" +
                "D=M\n" +
                "@" + index + "\n" +
                "A=D+A\n" +
                "D=M\n" +
                "@SP\n" +
                "A=M\n" +
                "M=D\n" +
                "@SP\n" +
                "M=M+1\n";
    }

    public static String THAT(Integer index) {
        return "@THAT\n" +
                "D=M\n" +
                "@" + index + "\n" +
                "A=D+A\n" +
                "D=M\n" +
                "@SP\n" +
                "A=M\n" +
                "M=D\n" +
                "@SP\n" +
                "M=M+1\n";
    }

    public static String LOCAL(Integer index) {
        return "@" + index + "\n" +
                "D=A\n" +
                "@LCL\n" +
                "A=D+M\n" +
                "D=M\n" +
                "@SP\n" +
                "A=M\n" +
                "M=D\n" +
                "D=A+1\n" +
                "@SP\n" +
                "M=D\n";
    }

    public static String POINTER(Integer index) {
        if (index == 0)
            return "@THIS \n" +
                    "D=M \n" +
                    "@SP\n" +
                    "A=M\n" +
                    "M=D\n" +
                    "@SP\n" +
                    "M=M+1\n";
        else
            return "@THAT \n" +
                    "D=M \n" +
                    "@SP\n" +
                    "A=M\n" +
                    "M=D\n" +
                    "@SP\n" +
                    "M=M+1\n";
    }

    public static String TEMP(Integer index) {
        return "@R5\n" +
                "D=A\n" +
                "@" + index + "\n" +
                "A=D+A\n" +
                "D=M\n" +
                "@SP\n" +
                "A=M\n" +
                "M=D\n" +
                "@SP\n" +
                "M=M+1\n";
    }

    public static String STATIC(Integer index) {
        return "@" + index + "\n" +
                "D=M\n" +
                "@SP\n" +
                "A=M\n" +
                "M=D\n" +
                "@SP\n" +
                "M=M+1\n";
    }
}
