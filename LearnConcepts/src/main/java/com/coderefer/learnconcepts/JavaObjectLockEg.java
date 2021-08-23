package com.coderefer.learnconcepts;

public class JavaObjectLockEg {
    public static void main(String[] args) {
        JavaObjectLockEg eg = new JavaObjectLockEg();
        Thread t1 = new Thread1(eg);
        Thread t2 = new Thread2(eg);
        t1.start();
        t2.start();    }
    synchronized void m1() {
        System.out.println("in m1 method and Thread name is " + Thread.currentThread().getName());
    }
    synchronized void m2() {
        System.out.println("in m2 method and Thread name is " + Thread.currentThread().getName());
    }
}
class Thread1 extends Thread{
    JavaObjectLockEg eg;
    public Thread1(JavaObjectLockEg eg) {
        this.eg = eg;
    }

    @Override
    public void run() {
        eg.m1();
        eg.m2();
    }
}
class Thread2 extends Thread{
    JavaObjectLockEg eg;
    public Thread2(JavaObjectLockEg eg) {
        this.eg = eg;
    }

    @Override
    public void run() {
        eg.m1();
        eg.m2();
    }
}
