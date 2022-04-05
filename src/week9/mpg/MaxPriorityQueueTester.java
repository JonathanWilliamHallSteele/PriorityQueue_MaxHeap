/**
 * Test class for MPQ
 */
package week9.mpg;

import java.util.Arrays;

/**
 * @author Malaka Walpola
 * @author Jonathan Steele jonwhsteele@gmail.com
 */
public class MaxPriorityQueueTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//test1();
		test2();
	}
	
	public static void test1() {
		Integer[] items = { 20, 30, 40, 80, 70, 60, 50, 10 };
		MaxPriorityQueue<Integer> myQueue = new MaxPriorityQueue<Integer>(Arrays.asList(items));
		
		myQueue.printMaxPriorityQueue();
		System.out.println("Size of the queue: " + myQueue.size());
		System.out.println("Element with highest priority: " + myQueue.nextElement());
		System.out.println("Removing element with highest priority returns: " + myQueue.remove() );
		System.out.println("Element with highest priority (updatred queue): " + myQueue.nextElement());
		myQueue.add(66);
		myQueue.add(88);
		myQueue.printMaxPriorityQueue();
	}
	
	public static void test2() {

		MaxPriorityQueue<Integer> maxPriorityQueue = new MaxPriorityQueue<Integer>(); //a
		
		maxPriorityQueue.add(1); //b
		maxPriorityQueue.add(99);
		maxPriorityQueue.add(22);
		maxPriorityQueue.add(42);
		maxPriorityQueue.add(47);
		maxPriorityQueue.add(10);
		maxPriorityQueue.add(2);
		maxPriorityQueue.add(871);
		
		maxPriorityQueue.printMaxPriorityQueue(); //c
		
		System.out.println("Size of the queue: " + maxPriorityQueue.size()); //d

		System.out.println("Next in Priority Queue: " + maxPriorityQueue.remove().doubleValue()); //e
		System.out.println("Next in Priority Queue: " + maxPriorityQueue.remove().doubleValue());
		
		maxPriorityQueue.printMaxPriorityQueue(); //f
		
		System.out.println("Size of queue: " + maxPriorityQueue.size()); //g
		
		maxPriorityQueue.add(999); //h
		maxPriorityQueue.add(12);
		maxPriorityQueue.add(998);
		
		maxPriorityQueue.printMaxPriorityQueue(); //i
		
		System.out.println("Size of queue: " + maxPriorityQueue.size()); //j
		
		System.out.println("Highest priority element: " + maxPriorityQueue.nextElement()); //k
		
		Integer[] items = { 11, 22, 33, 44, 55, 66, 77, 88 };
		MaxPriorityQueue<Integer> maxHeap = new MaxPriorityQueue<Integer>(Arrays.asList(items));
		
	}

}
