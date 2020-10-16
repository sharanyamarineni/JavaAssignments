package assignment8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionHandling {
    public void equals(String s) throws FileNotFoundException {
//        File file =new File("/home/sharanyam/Sample2/abc2");
//        FileReader fr = new FileReader(file);
            if(s.equals("abc")){
                System.out.println("equal");
            }
            else{
                System.out.println("not equal");
            }
            equals(s);

    }

    public static void main(String[] args) throws FileNotFoundException {
        String s="abc";
        ExceptionHandling eh = new ExceptionHandling();
        try {
            eh.equals(s);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally {
            System.out.println("finallyy");
        }

    }
}
