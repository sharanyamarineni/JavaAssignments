package assignment5.assignment.data;

public class Basic {
    int n;
    char c;
    public void print(){
        System.out.println("int"+n);
        //null character, which is a control character. So we cant print
        System.out.println("char"+c);
    }
    public void print2(){
        int a;
        int b;
        //local variable need to be initialized, because they don't have default values
//        System.out.println(a);
//        System.out.println(b);
    }
}
