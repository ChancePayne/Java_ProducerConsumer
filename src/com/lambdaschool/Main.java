package com.lambdaschool;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        LockableList<Integer> data = new LockableList<>();
        new Thread(new Producer(data)).start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Consumer(data, 1)).start();
        new Thread(new Consumer(data, 2)).start();
    }
}
