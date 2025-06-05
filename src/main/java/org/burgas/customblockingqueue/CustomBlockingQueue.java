package org.burgas.customblockingqueue;

public final class CustomBlockingQueue {

    private int size;
    private Node first, last;

    public CustomBlockingQueue() {
        size = 0;
        this.first = this.last = null;
    }

    public synchronized void enqueue(Runnable runnable) {
        Node node = new Node(runnable);

        if (this.size == 0) {
            this.first = node;

        } else {
            this.last.setNextNode(node);
        }

        this.last = node;
        this.size++;

        notify();
    }

    public synchronized Runnable dequeue() {
        while (size == 0) {
            try {
                wait();

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        Runnable task = this.first.getTask();
        this.size--;

        return task;
    }

    public int getSize() {
        return this.size;
    }
}
