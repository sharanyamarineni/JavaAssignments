package yourname.assignment.singleton;

public class Sample {
    String member;
    public static Sample check(String member){
        member="john";
        return new Sample();
    }
    public void print(){
        System.out.println(member);
    }
}
