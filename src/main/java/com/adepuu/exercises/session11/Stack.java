package com.adepuu.exercises.session11;

import com.adepuu.dsa.datastructure.LinkedList;

public class Stack {
    private LinkedList stackList;
    private int size;

    public Stack() {
        stackList = new LinkedList();
        size = 0;
    }

    public void push(int value) {
        stackList.insertAtBeginning(value);
        size++;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return -1;
        } else {
            int poppedValue = stackList.head.data;
            stackList.deleteByKey(poppedValue);
            size--;
            return poppedValue;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;
        } else {
            return stackList.head.data;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
    /**
     * Write a Java stack program that can scale dynamically
     * <p>
     * As a developer, I want to implement a Java stack program that can scale dynamically using a linked list, so that I can efficiently manage data storage and retrieval in my applications.
     * Notes:
     * The program doesn't require a menu system; focus should be on data structure implementation.
     * <p>
     * Acceptance Criteria:
     * - Functionality: The program must be able to perform basic stack operations (push, pop, peek) on a linked list.
     * - Dynamic Scaling: The stack should automatically scale in size as elements are added or removed, without any manual resizing required by the user.
     * - Performance: The program should maintain constant time complexity for push and pop operations, ensuring efficient data management.
     * - Memory Efficiency: The stack should use memory efficiently, allocating and deallocating memory dynamically as needed.
     * - Error Handling: The program should handle edge cases gracefully, such as attempting to pop an element from an empty stack, and provide clear error messages.
     */
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3); // Resize happens here
        stack.push(4);
        stack.pop();
        stack.pop(); // Resize happens here
        stack.pop();
        stack.pop(); // Stack is empty
        System.out.println(stack.peek()); // Outputs -1 (empty stack)
    }
}
