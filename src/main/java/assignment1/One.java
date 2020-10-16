package assignment1;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.RegexFileFilter;
import java.io.File;
import java.util.Collection;

// iterating through all directories and finding files

public class One {
    public void checkFiles(String s){
                File dir =new File(s);
        Collection files = FileUtils.listFiles(
                dir,
                new RegexFileFilter("^(.*?)"),
                DirectoryFileFilter.DIRECTORY
        );
        System.out.println(files);
    }
    public static void main(String[] args) {
        One o =new One();
        o.checkFiles("/home/");
    }
}
