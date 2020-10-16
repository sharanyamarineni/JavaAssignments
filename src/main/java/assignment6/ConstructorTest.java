package assignment6;

public class ConstructorTest {
    public ConstructorTest(){
        new ConstructorTest("hii");
    }
    public ConstructorTest(String s){
        System.out.println(s);
    }

    public static void main(String[] args) {
        ConstructorTest c =new ConstructorTest();
       // ConstructorTest[] arr = new ConstructorTest[5];
//        for ( int i=0; i<arr.length; i++) {
//            arr[i]=new ConstructorTest();
//        }
    }
}
