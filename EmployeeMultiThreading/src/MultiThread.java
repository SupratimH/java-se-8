
class MyClass {
    int a;

    MyClass(int a) {
        this.a = a;
    }

    void display() {
        System.out.println("MyClass::" + a);
    }
}

class MyThread extends Thread {
    MyClass mc;

    MyThread(MyClass mc) {
        this.mc = mc;
        //start();
    }

    @Override
    public  void run() {
        System.out.println("MyThread::run()" + this.getName() + " " + this.getId());
        mc.display();
    }

    void startThread () {
        System.out.println("MyThread::startThread() " + " " + this.getName() + " " + this.getId());
        //start();
    }

}

public class MultiThread {

    public static void main(String [] args) {
        int startThread = 0;
        MyClass myClass = new MyClass(99);

        MyThread myThread = new MyThread(myClass);
        myThread.startThread();

        MyThread myThread1 = new MyThread(myClass);
        myThread1.startThread();

        myThread.run();

        Thread mt = Thread.currentThread();
        System.out.println("main() " + " " + mt.getName() + " " + mt.getId());

    }
}
