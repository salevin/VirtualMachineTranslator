/**
 * Created by sam on 11/16/15.
 */
public class PushWriter {
    public static String CONSTANT(Integer index){
        return "@" + Integer.toString(index) + "\n" +
                "D=A\n" +
                "@SP\n" +
                "M=D\n" +
                "@SP\n" +
                "M=M+1\n";
    }
    public static String ARGUMENT(Integer index){
        return "@ARG\n" +
                "D=M\n" +
                "@" + Integer.toString(index) + "\n" +
                "A=D+A" +
                "D=M\n" +
                "@SP\n" +
                "A=M\n" +
                "M=D\n" +
                "@SP\n" +
                "M=M+1\n";
    }
    public static String THIS(Integer index){
        return "@constant\n" +
                "D=A\n" +
                "@"+ Integer.toString(index) + "\n" +
                "M=D\n";
    }
    public static String THAT(Integer index){
        return "@constant\n" +
                "D=A\n" +
                "@"+ Integer.toString(index) + "\n" +
                "M=D\n";
    }
    public static String LOCAL(Integer index){
        return "@constant\n" +
                "D=A\n" +
                "@"+ Integer.toString(index) + "\n" +
                "M=D\n";
    }
    public static String POINTER(Integer index){
        return "@R13\n" +
                "M=D\n" +
                "@SP\n" +
                "AM=M-1\n" +
                "D=M\n" +
                "@R13\n" +
                "A=M\n" +
                "M=D\n";
    }
    public static String TEMP(Integer index){
        return "@R5\n" +
                "D=A\n" +
                "@"+ Integer.toString(index) + "\n" +
                "A=D+A\n" +
                "D=M\n" +
                "@SP\n" +
                "A=M\n" +
                "M=D\n" +
                "@SP\n" +
                "M=M+1\n";
    }
}
