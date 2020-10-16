package yourname.assignment.main;

import yourname.assignment.data.Basic;
import yourname.assignment.singleton.Sample;

public class Main {
    public static void main(String[] args) {
        Basic basic =new Basic();
        Sample sample = new Sample();
        basic.print();
        basic.print2();
        //we can't call static methods from other classes.
//        Sample sample =check("abc");
        sample.print();
    }

}
