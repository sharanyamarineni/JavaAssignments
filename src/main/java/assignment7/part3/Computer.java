package assignment7.part3;

interface MotherBoard {
    void a();
    void b();
}

interface Mouse {
    void c();
    void d();
}

interface Keypad {
    void e();
    void f();
}

interface AllParts extends MotherBoard, Mouse, Keypad {
    void all();
}
class OS{
    public void os(){

    }
}
public class Computer extends OS implements AllParts{

    @Override
    public void a() {

    }

    @Override
    public void b() {

    }

    @Override
    public void c() {

    }

    @Override
    public void d() {

    }

    @Override
    public void e() {

    }

    @Override
    public void f() {

    }

    @Override
    public void all() {

    }
}
