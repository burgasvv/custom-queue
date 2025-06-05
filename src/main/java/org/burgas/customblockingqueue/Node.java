package org.burgas.customblockingqueue;

public final class Node {

    private final Runnable task;
    private Node nextNode;

    public Node(Runnable task) {
        this.task = task;
    }

    public Runnable getTask() {
        return task;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
