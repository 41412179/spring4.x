package com.smart.advisor;

public class WaiterDelegate {
    private Waiter waiter;

    public void service(String clientName) {    //waiter的方法通过该方法发起调用
        waiter.greetTo(clientName);
        waiter.serveTo(clientName);
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }
}
