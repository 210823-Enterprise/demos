package com.revature.queue;

public class App {

	public static void main(String[] args) {
		
		/*
		 * If we set the max size to 9, the last 9 values inserted 
		 * will be present, and the 10th value will overwrite the 
		 * first (so, 99999 will be presents the *first* value, over
		 * writing 100 due to the nature of a circular queue.
		 */
		SimpleQueue myQueue = new SimpleQueue(9); // change between 10 and 9 to demonstrate CiruclarQueue
		
		myQueue.insert(100); // If  we set the 
		myQueue.insert(1000);
		myQueue.insert(14);
		myQueue.insert(12);
		myQueue.insert(44);
		myQueue.insert(99);
		myQueue.insert(99);
		myQueue.insert(99);
		myQueue.insert(99);
		myQueue.insert(99999);
		myQueue.view();
	}

}
