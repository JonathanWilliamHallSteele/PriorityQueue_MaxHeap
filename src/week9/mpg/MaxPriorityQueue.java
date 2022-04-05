/**
 * Priority Queue implementation using a Heap.
 * Implements a max priority queue where larger key has the higher priority.
 */
package week9.mpg;

import java.util.ArrayList;
import java.util.Collection;
import week9.heap.MaxHeap;

/**
 * @author Malaka Walpola
 * @author Jonathan Steele jonwhsteele@gmail.com
 */
public class MaxPriorityQueue<E extends Comparable<E>> {
	
	private ArrayList<E> elements;

	/**
	 * Default constructor.
	 */
	public MaxPriorityQueue() {
		super();
		this.elements = new ArrayList<E>();
	}
	
	/**
	 * Constructor that accepts a set of items.
	 * @param items - items to be inserted into the PriorityQueue.
	 */
	public MaxPriorityQueue(Collection<E> items) {
		super();
		if(null != items && items.size()>0) {
			this.elements = new ArrayList<E>(items); //Simply add items in order.
			this.elements.add(0, this.elements.get(0)); //Add dummy element to index 0.
			MaxHeap.buildMaxHeap(this.elements); //Convert the ArrayList into a heap.
		}
		else
			this.elements = new ArrayList<E>();
	}

	/**
	 * Return the size.
	 * @return the size of the MaxPriorityQueue.
	 */
	public int size() {
		int elementCount = this.elements.size()-1; //Recall that the first element of the elements is a dummy element.
		if(elementCount > 0) //MaxPriorityQueue is not empty.
			return elementCount;
		return 0; //MaxPriorityQueue is empty. 
	}

	/**
	 * Clear the MaxPriorityQueue.
	 */
	public void clear() {
		this.elements.clear();
	}

	/**
	 * Return the element with highest priority in the MaxPriorityQueue.
	 * @return the element with highest priority
	 */
	public E nextElement() {
		return MaxHeap.heapMax(this.elements);
	}
	
	/**
	 * Add new value to the MaxPriorityQueue.
	 * @param value - to be added to the MaxPriorityQueue.
	 * @return success of the operation.
	 */
	public boolean add(E value) {
		MaxHeap.heapInsert(this.elements, value);
		return true;
	}
	
	/**
	 * Remove and return the element with highest priority in the MaxPriorityQueue.
	 * @return the element with highest priority 
	 */
	public E remove() {
		return MaxHeap.heapExtractMax(this.elements);
	}
	
	/**
	 * Utility to print the MaxPriorityQueue for visualization.
	 */
	public void printMaxPriorityQueue() {
		MaxHeap.printArrayList(this.elements);
	}
}
