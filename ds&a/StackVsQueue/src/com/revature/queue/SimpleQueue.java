package com.revature.queue;

public class SimpleQueue {

	private int maxSize; // initializes the set number of slots
	private long[] queueArray; // slots to main the data (using a long[] as underlying data type

	private int front; // this will be the index position for the element in the front
	private int rear; // going to be the index position for the element at the back of the line
	private int nItems; // counter to maintain the number of items in our queue

	public SimpleQueue(int size) {
		this.maxSize = size;
		this.queueArray = new long[size];
		front = 0; // index position of the first slot of the array
		rear = -1; // there is no item in the array yet to be considered as the last item.
		nItems = 0; // we don't have elements in the array yet
	}

	public void insert(long j) {
		/**
		 * This prevents an unchecked exception from occurring (IndexOutOfBounds) in the
		 * case that we try to add more items than we have allowed slots for.
		 * 
		 * This actually creates something called a CircularQueue in values will be overwritten
		 * by a later added value if the # of elements added is more than the max amount of 
		 * elements allowed. 
		 */
		if (rear == maxSize - 1) {
			rear = -1;
		}

		rear++;
		queueArray[rear] = j;
		nItems++;
	}

	public long remove() { // remove item from the front of the queue
		long temp = queueArray[front];
		front++;
		if (front == maxSize) {
			front = 0; // we can set front back to the 0th index so that we can utilize the entire
						// array again
		}
		nItems--;
		return temp;
	}

	public long peekFront() {
		return queueArray[front];
	}

	public boolean isEmpty() {
		return (nItems == 0);
	}

	public boolean isFull() {
		return (nItems == maxSize);
	}

	public void view() {

		System.out.print("[ ");

		for (int i = 0; i < queueArray.length; i++) {
			System.out.print(queueArray[i] + " ");
		}

		System.out.print("]");
	}

}
