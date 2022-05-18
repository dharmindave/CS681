package edu.umb.cs681.hw14;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
public class AccessCounter {

    private ConcurrentHashMap<Path, AtomicInteger> ConcurrentHashMap = new ConcurrentHashMap<>();
    private static ReentrantLock staticLock = new ReentrantLock();
    private static AccessCounter instance = null;
    private AccessCounter() {};

    public static AccessCounter getInstance() {
        staticLock.lock();
        try {
            if (instance == null)
                instance = new AccessCounter();
            return instance;
        }
        finally {
            staticLock.unlock();
        }
    }

    public void increment(Path path) {
        ConcurrentHashMap.compute(path, (Path k, AtomicInteger v) -> {
        if(v == null) {
            System.out.println(Thread.currentThread().getName() + " increase " + path + " to " + 1);
            return new AtomicInteger(1);
        } else {
            System.out.println(Thread.currentThread().getName() + " increase " + path + " to " + (v.get()+1));
            return new AtomicInteger(v.incrementAndGet());
        }
    });
    }

    public int getCount(Path path) {
        return ConcurrentHashMap.compute(path, (java.nio.file.Path k, AtomicInteger v) -> {
            if(v == null) {
                System.out.println(Thread.currentThread().getName() + " get " + path + " count " + 0);
                return new AtomicInteger(0);
            } else {
                System.out.println(Thread.currentThread().getName() + " get " + path + " count " + v.get());
                return v;
            }
        }).get();
    }
}