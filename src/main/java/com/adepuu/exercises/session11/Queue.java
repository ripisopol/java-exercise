package com.adepuu.exercises.session11;

import com.adepuu.dsa.datastructure.LinkedList;
public class Queue {
    private LinkedList queueList;

    public Queue() {
        queueList = new LinkedList();
    }

    public void enqueue(int value) {
        queueList.insertAtEnd(value);
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        } else {
            int dequeuedValue = queueList.head.data;
            queueList.head = queueList.head.next;
            return dequeuedValue;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        } else {
            return queueList.head.data;
        }
    }

    public boolean isEmpty() {
        return queueList.head == null;
    }

    public int size() {
        return queueList.size();
    }
    /**
     * Write a Java queue program that can scale dynamically
     * <p>
     * As a developer, I want to implement a Java queue program that can scale dynamically using a linked list, so that I can efficiently manage data storage and retrieval in my applications.
     * <p>
     * Notes:
     * The program doesn't require a menu system; focus should be on data structure implementation.
     * <p>
     * Acceptance Criteria:
     * - Functionality: The program must be able to perform basic queue operations (enqueue, dequeue, peek) on a linked list.
     * - Dynamic Scaling: The queue should automatically scale in size as elements are added or removed, without any manual resizing required by the user.
     * - Performance: The program should maintain constant time complexity for enqueue and dequeue operations, ensuring efficient data management.
     * - Memory Efficiency: The queue should use memory efficiently, allocating and deallocating memory dynamically as needed.
     * - Error Handling: The program should handle edge cases gracefully, such as attempting to dequeue an element from an empty queue, and provide clear error messages.
     */
    public static void main(String[] args) {
        Queue queue = new Queue();

        // Enqueue elements
        for (int i = 1; i <= 10; i++) {
            queue.enqueue(i);
        }

        // Dequeue elements
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }
}
