package cc.common.test;

public class Test1 extends Thread{

    public void run()
    {
        System.out.println(Thread.currentThread().getName()+" finished executing");
    }
    public static void main(String arg[]) throws InterruptedException, SecurityException
    {
        // creating the thread
        Test1 t1 = new Test1();
        Test1 t2 = new Test1();
        // this will call the run() method
        t1.start();
        t2.start();

        // Check for access permission of current running thread
        t1.checkAccess();
        System.out.println(t1.getName() + " has access");
        t2.checkAccess();
        System.out.println(t2.getName() + " has access");
    }

}
