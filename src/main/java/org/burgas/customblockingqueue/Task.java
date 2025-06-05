package org.burgas.customblockingqueue;

import java.util.concurrent.atomic.AtomicInteger;

public final class Task implements Runnable {

    private static final AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public void run() {
        System.out.println("Task running: " + atomicInteger.incrementAndGet());
    }
}
