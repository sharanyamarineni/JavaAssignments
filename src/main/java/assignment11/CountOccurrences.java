package assignment11;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class CountOccurrences {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("/home/sharanyam/Sample2/abc"));
        final String outputFilePath = "/home/sharanyam/Sample2/output";
        String currentLine = reader.readLine();

        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<currentLine.length();i++){
            char ch= currentLine.charAt(i);
            if(ch!=' ') {
                if (hm.containsKey(ch)) {
                    hm.put(ch, hm.get(ch) + 1);
                } else {
                    hm.put(ch, 1);
                }
            }
        }
        System.out.println(hm);
        File file = new File(outputFilePath);

        BufferedWriter bf = null;
        try{
            bf = new BufferedWriter( new FileWriter(file) );

            for(Map.Entry<Character, Integer> entry : hm.entrySet()){
                bf.write( entry.getKey() + ":" + entry.getValue() );
                bf.newLine();
            }
            bf.flush();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                bf.close();
            }catch(Exception e){}
        }
    }
}
