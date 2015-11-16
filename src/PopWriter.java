/**
 * Created by sam on 11/16/15.
 */
public class PopWriter {
    public static String CONSTANT(Integer index){
        return "@constant\n" +
                "D=A\n" +
                "@"+ Integer.toString(index) + "\n" +
                "M=D\n";
    }
    public static String ARGUMENT(Integer index){
        return "@constant\n" +
                "D=A\n" +
                "@"+ Integer.toString(index) + "\n" +
                "M=D\n";
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
        return "@constant\n" +
                "D=A\n" +
                "@"+ Integer.toString(index) + "\n" +
                "M=D\n";
    }
    public static String TEMP(Integer index){
        return "@constant\n" +
                "D=A\n" +
                "@"+ Integer.toString(index) + "\n" +
                "M=D\n";
    }
}
