package com.revature.stack;

/**
 * Here we are creating our own Stack class.
 * This class is meant to represent the most basic 
 * functionality of the java.util.Stack class from the JRE.
 */
public class SimpleStack {

	private int maxSize;
	private long[] stackArray;
	private int top; // the index of the last item that was placed on top of the Stack

	public SimpleStack(int size) {
		this.maxSize = size;
		this.stackArray = new long[maxSize];
		this.top = -1; // we initialize it at -1 because the item at the top will increment by 1
					   // (and have index 0) when we first push an item in.
					   // top is used as a pointer.
	}

	// Places a new element on top
	public void push(long j) {

		if (isFull()) { // this is here in the case that we go beyond the boundaries of the array
			System.out.println(" this stack is already full");
		} else {
			top++; // increment index of item at the top
			stackArray[top] = j; // the top element is equal to what we pass through as input.
		}
	}

	// Pops the last element off
	public long pop() {

		if (isEmpty()) {
			System.out.println("the stack is already empty");
			return -1;
		} else {
			int old_top = top;
			top--;
			return stackArray[old_top];
		}
	}

	public long peak() {
		return stackArray[top];
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isFull() {
		return (maxSize - 1 == top);
	}
}
