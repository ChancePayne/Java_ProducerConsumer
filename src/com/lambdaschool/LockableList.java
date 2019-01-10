package com.lambdaschool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class LockableList<T> {
    private List<T> data;
    private Semaphore lock;

    public LockableList() {
        this.data = new ArrayList<T>();
        this.lock = new Semaphore(1);
    }

    public void add(T item) {
        while(!this.acquire()) {}
        data.add(item);
        this.release();
    }

    public boolean acquire() {
        try {
            lock.acquire();
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void release() {
        lock.release();
    }

    public T remove() {
        while(!this.acquire()) {}
        T value = null;
        if(data.size() > 0) {
            value = data.remove(0);
        }
        this.release();
        return value;
    }

    public int size() {
        while(!this.acquire()) {}
        int value = data.size();
        this.release();
        return value;
    }
}
