package assignment11;

import java.io.*;

public class CountOccurences {
    public static void main(String[] args) throws IOException {
        File file =new File("/home/sharanyam/Sample2/abc");
        FileInputStream fileStream = new FileInputStream(file);
        InputStreamReader input = new InputStreamReader(fileStream);
        BufferedReader reader = new BufferedReader(input);
        int charCount = 0;
        String data;
        while((data = reader.readLine()) != null) {
            for(int i=0;i<data.length();i++){
                if(data.charAt(i)!=' '){
                    charCount++;
                }
            }
        }
        System.out.println(charCount);
    }
}
