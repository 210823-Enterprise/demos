package com.revature.stack;

/**
 * This StringStack will be used in the Stack challenge (within App.java).
 * Note the change from long[] to char[] in the underlying array.
 * This is why inferring Generics in the Stack Class (from JRE) is so great!
 * 
 * https://www.geeksforgeeks.org/stack-class-in-java/
 */
public class CharStack {

	private int maxSize;
	private char[] stackArray; // changed
	private int top; 

	public CharStack(int size) {
		this.maxSize = size;
		this.stackArray = new char[maxSize]; //changed
		this.top = -1;
	}

	// Places a new element on top
	public void push(char j) { // changed

		if (isFull()) { 
			System.out.println("this stack is already full");
		} else {
			top++;
			stackArray[top] = j; 
		}
	}

	// Pops the last element off
	public char pop() {

		if (isEmpty()) {
			System.out.println("the stack is already empty");
			return '0'; // changed
		} else {
			int old_top = top;
			top--;
			return stackArray[old_top];
		}
	}

	public char peak() {
		return stackArray[top];
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isFull() {
		return (maxSize - 1 == top);
	}
}

