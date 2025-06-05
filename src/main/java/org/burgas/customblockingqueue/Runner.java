package org.burgas.customblockingqueue;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class Runner {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        CustomBlockingQueue customBlockingQueue = new CustomBlockingQueue();
        ExecutorService executorService = Executors.newCachedThreadPool();

        System.out.println("Queue size: " + customBlockingQueue.getSize());

        customBlockingQueue.enqueue(new Task());
        customBlockingQueue.enqueue(new Task());

        System.out.println("Queue size: " + customBlockingQueue.getSize());

        executorService.submit(customBlockingQueue.dequeue()).get();
        executorService.submit(customBlockingQueue.dequeue()).get();

        System.out.println("Queue size: " + customBlockingQueue.getSize());

        executorService.shutdown();
    }
}
