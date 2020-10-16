package assignment7.part2;


public class Main {
    public static void main(String[] args) {
        //upcasting
        Cycle c[] = new Cycle[3];
        c[0] = new Unicycle();
        c[1] = new Bicycle();
        c[2] = new Tricycle();

        c[0].balance();
        c[1].balance();
        c[2].balance();

        //downcasting
        Cycle obj = new Unicycle();
        Unicycle sub = (Unicycle) obj;
        sub.balance();
    }


}
