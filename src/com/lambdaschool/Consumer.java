package com.lambdaschool;

public class Consumer implements Runnable {
    private LockableList<Integer> data;
    private int id;

    public Consumer(LockableList<Integer> data, int id) {
        this.data = data;
        this.id = id;
    }

    @Override
    public void run() {
        while(true) {
            System.out.println(
                    String.format(
                            "id: %d - %d",
                            this.id,
                            this.data.remove()));
            // processing
            try {
                Thread.sleep((long) (Math.random() * 10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // processing done

            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
