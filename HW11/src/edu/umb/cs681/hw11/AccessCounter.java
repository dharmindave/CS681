package edu.umb.cs681.hw11;


import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class AccessCounter {

    private Map<java.nio.file.Path, Integer> map = new HashMap<java.nio.file.Path, Integer>();
    private ReentrantLock nonstaticLock = new ReentrantLock();
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
        nonstaticLock.lock();
        try {
            if (map.get(path) != null)
                map.put(path, map.get(path) + 1);
            else
                map.put(path, 1);
        }
        finally {
            nonstaticLock.unlock();
        }
    }

    public int getCount(Path path) {
        nonstaticLock.lock();
        try {
            if (map.get(path) != null)
                return map.get(path);
            else
                return 0;
        }
        finally {
            nonstaticLock.unlock();
        }
    }
}