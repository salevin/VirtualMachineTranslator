/**
 * Created by sam on 11/16/15.
 */
public class PopWriter {
    public static String ARGUMENT(Integer index) {
        return "@ARG\n" +
                "D=M\n" +
                "@" + index + "\n" +
                "D=D+A\n" +
                "@R13\n" +
                "M=D\n" +
                "@SP\n" +
                "AM=M-1\n" +
                "D=M\n" +
                "@R13\n" +
                "A=M\n" +
                "M=D\n";
    }

    public static String THIS(Integer index) {
        return "@THIS\n" +
                "D=M\n" +
                "@" + index + "\n" +
                "D=D+A\n" +
                "@R13\n" +
                "M=D\n" +
                "@SP\n" +
                "AM=M-1\n" +
                "D=M\n" +
                "@R13\n" +
                "A=M\n" +
                "M=D\n";
    }

    public static String THAT(Integer index) {
        return "@THAT\n" +
                "D=M\n" +
                "@" + index + "\n" +
                "D=D+A\n" +
                "@R13\n" +
                "M=D\n" +
                "@SP\n" +
                "AM=M-1\n" +
                "D=M\n" +
                "@R13\n" +
                "A=M\n" +
                "M=D\n";
    }

    public static String LOCAL(Integer index) {
        return "@LCL\n" +
                "D=M\n" +
                "@" + index + "\n" +
                "D=D+A\n" +
                "@R13\n" +
                "M=D\n" +
                "@SP\n" +
                "AM=M-1\n" +
                "D=M\n" +
                "@R13\n" +
                "A=M\n" +
                "M=D\n";
    }

    public static String POINTER() {
        return "@R13\n" +
                "M=D\n" +
                "@SP\n" +
                "AM=M-1\n" +
                "D=M\n" +
                "@R13\n" +
                "A=M\n" +
                "M=D\n";
    }

    public static String TEMP(Integer index) {
        return "@R5\n" +
                "D=M\n" +
                "@" + index + "\n" +
                "D=D+A\n" +
                "@R13\n" +
                "M=D\n" +
                "@SP\n" +
                "AM=M-1\n" +
                "D=M\n" +
                "@R13\n" +
                "A=M\n" +
                "M=D\n";
    }
}