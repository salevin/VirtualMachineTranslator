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
        "A=D-A\n" +
        "D=M\n" +
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
        "M=D+A\n" +
        //that
        "@R14\n" +
        "D=M\n" +
        "@1\n" +
        "A=D-A\n" +
        "D=M\n" +
        "@THAT\n" +
        "M=D\n" +
        //this
        "@R14\n" +
        "D=M\n" +
        "@2\n" +
        "A=D-A\n" +
        "D=M\n" +
        "@THAT\n" +
        "M=D\n" +
        //arg
        "@R14\n" +
        "D=M\n" +
        "@3\n" +
        "A=D-A\n" +
        "D=M\n" +
        "@ARG\n" +
        "M=D\n" +
        //lcl
        "@R14\n" +
        "D=M\n" +
        "@4\n" +
        "A=D-A\n" +
        "D=M\n" +
        "@LCL\n" +
        "M=D\n" +
        //goto
        "@R15\n" +
        "A=M\n" +
        "A;JMP\n";
}
