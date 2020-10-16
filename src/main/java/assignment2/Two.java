package assignment2;

public class Two {
    public boolean checkStringAllAlphabets(String input){
        boolean result = input.toLowerCase()
                .replaceAll("[^a-z]", "")
                .replaceAll("(.)(?=.*\\1)", "")
                .length() == 26;
        System.out.println(input);
        return result;
    }
    public static void main(String[] args) {
        Two t =new Two();
        boolean res=t.checkStringAllAlphabets("abcadddddd efgh -)ijklmn opqrst)uvwxyz");
        System.out.println(res);
    }
}

// first removing all characters except alphabets
// second removing duplicate characters
//counting characters to be 26
// 0(n)
