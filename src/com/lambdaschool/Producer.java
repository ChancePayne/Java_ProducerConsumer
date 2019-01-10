package com.lambdaschool;

public class Producer implements Runnable {
    private LockableList<Integer> data;

    public Producer(LockableList<Integer> data) {
        this.data = data;
    }

    @Override
    public void run() {
        int number = 0;
        while(true) {
            data.add(number++);
            System.out.println("Size: " + data.size());
            try {
                Thread.sleep((long) (Math.random() * 25));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
