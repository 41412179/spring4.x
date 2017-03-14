package com.smart;

@Monitorable
public class NaiveWaiter implements Waiter {
    public void greetTo(String clientName) {
        System.out.println("NaiveWaiter greet to " + clientName);
    }

    public void serveTo(String clientName) {
        System.out.println("NaiveWaiter serve to " + clientName);
    }

    public void smile(String name, int times) {
        System.out.println("NaiveWaiter: smile to " + name + " " + times + " times");
    }
}
