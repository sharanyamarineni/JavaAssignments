package assignment9;
import java.util.regex.*;
public class Regex {
    static boolean checkRegex(String s){
        Pattern p = Pattern.compile("^[A-Z].*");
        Matcher m = p.matcher(s);
        boolean b = m.matches();
        return b;
    }
    public static void main(String[] args) {
        String s ="Hello world.";
        System.out.println(checkRegex(s));
    }
}
