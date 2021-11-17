package com.revature.queue;

import java.util.LinkedList;
import java.util.Queue;

public class App {

	public static void main(String[] args) {
		
		/*
		 * If we set the max size to 9, the last 9 values inserted 
		 * will be present, and the 10th value will overwrite the 
		 * first (so, 99999 will represent the *first* value, over
		 * writing 100 due to the nature of a circular queue.
		 */
		SimpleQueue myQueue = new SimpleQueue(9); // change between 10 and 9 to demonstrate CiruclarQueue
		
		myQueue.insert(100); // If set the maxSize to 9, this first value will be overwritten by the 10th
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
		
		// Remember we can alsways just instantiate a Queue from the JRE class like so:
		
		/*
		 * Queue - A collection designed for holding elements prior to processing. 
		 * 
		 * Besides basic Collection operations, queues provide additional insertion, extraction, and inspection operations. Each of these methods exists in two forms: one throws 
		 * an exception if the operation fails, the other returns a special value (either null or false, depending on the 
		 * operation). The latter form of the insert operation is designed specifically for use with capacity-restricted Queue 
		 * implementations; in most implementations, insert operations cannot fail.
		 * 
		 * For the most part, queues maintain a first-in, first-out order (FIFO). One exception to this rule is the PriorityQueue
		 * implementation, which order elements according to a supplied comparator, or the elements' natural ordering.
		 */
		
		Queue<Integer> nums = new LinkedList<>();  // LinkedList implements Queue interface!
		// In a Queue you can store duplicate values.
		
		System.out.println("============= Queues! ");
		
		// You can add duplicates in a Queue!!
		nums.add(23);
		nums.add(24);
		nums.add(25);
		
		while(nums.size() != 0) {
			
			System.out.println("Queue size: " + nums.size());
			System.out.println("Processing... " + nums.poll()); // poll() removes the head of the queue
		}
	}

}
