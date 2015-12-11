/**
 * Created by sam on 12/7/15.
 */
public class ReturnWriter {
    static String RETURN =
        "@LCL\n" +
        "D=M\n" +
        "@R14\n" +
        "M=D\n" +
        // ret
        "@R14\n" +
        "D=M\n" +
        "@5\n" +
        "D=D-A\n" +
        "@R15\n" +
        "M=D\n" +
        //pop shit
        "@SP\n" +
        "AM=M-1\n" +
        "D=M\n" +
        "@ARG\n" +
        "A=M\n" +
        "M=D\n" +
        //sp
        "@ARG\n" +
        "D=M+1\n" +
        "@SP\n" +
        "M=D\n" +
        //that
        "@R14\n" +
        "D=M\n" +
        "@1\n" +
        "D=D-A\n" +
        "@THAT\n" +
        "M=D\n" +
        //this
        "@R14\n" +
        "D=M\n" +
        "@2\n" +
        "D=D-A\n" +
        "@THAT\n" +
        "M=D\n" +
        //arg
        "@R14\n" +
        "D=M\n" +
        "@3\n" +
        "D=D-A\n" +
        "@ARG\n" +
        "M=D\n" +
        //lcl
        "@R14\n" +
        "D=M\n" +
        "@4\n" +
        "D=D-A\n" +
        "@LCL\n" +
        "M=D\n" +
        //goto
        "@R15\n" +
        "0;JMP\n";
}
