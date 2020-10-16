package assignment7.part4;

interface Cycle{
    void ride();
}
interface CycleFactory{
    Cycle getCycle();
}

class Unicycle implements Cycle{
    public void ride(){
        System.out.println("unicycle riding");
    }
}
class UniFactory implements CycleFactory{
    public Cycle getCycle(){
        return new Unicycle();
    }
}

class Bicycle implements Cycle{
    public void ride(){
        System.out.println("Bicycle riding");
    }
}
class BiFactory implements CycleFactory{
    public Cycle getCycle(){
        return new Bicycle();
    }
}

class Tricycle implements Cycle{
    public void ride(){
        System.out.println("Tricycle riding");
    }
}
class TriFactory implements CycleFactory{
    public Cycle getCycle(){
        return new Tricycle();
    }
}

public class PartFour {
    public static void rideCycle(CycleFactory factory){
        Cycle c = factory.getCycle();
        c.ride();
    }
    public static void main(String[] args) {
        rideCycle(new UniFactory());
        rideCycle(new BiFactory());
        rideCycle(new TriFactory());
    }
}
