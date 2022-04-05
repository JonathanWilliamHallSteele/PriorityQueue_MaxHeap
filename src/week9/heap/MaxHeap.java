/**
 * Implementation of the Max Heap.
 */
package week9.heap;

import java.util.ArrayList;

/**
 * @author Malaka Walpola
 * @author Jonathan Steele jonwhsteele@gmail.com
 *
 */
public class MaxHeap  { 

	//Heap Method Implementations
	/**
	 * Max-Heapify Implementation
	 * This method restores the heap property in the (sub)tree rooted at index i.
	 * It assumes that the sub-trees rooted at 2i and 2i+1 are heaps. 
	 * @param elementList - Heap in an ArrayList (starting from index 1. index 0 contains a dummy element)
	 * @param i - index of the root node of the sub-tree to be heapified.
	 */
	public static <E extends Comparable<E>> void maxHeapify(ArrayList<E> elementList, int i) {
		if(i<1)
			return;
		int heapLimit = elementList.size()-1;
		int l = leftChild(i);
		int r = rightChild(i);
		int largest = i;
		if((l <= heapLimit) && (elementList.get(l).compareTo(elementList.get(largest)) > 0) )
			largest = l;
		if((r <= heapLimit) && (elementList.get(r).compareTo(elementList.get(largest)) > 0) )
			largest = r;

		if(largest != i) {
			//Swap elements
			swapElements(elementList, i, largest);
			//Recursive call
			maxHeapify(elementList, largest);
		}
	}

	/**
	 * Build-Max-Heap Implementation
	 * Convert the elements from 1 to n into a heap.
	 * Element with index zero is ignored
	 */
	public static <E extends Comparable<E>> void buildMaxHeap(ArrayList<E> elementList) {
		int start = elementList.size()/2;
		for(int i=start; i>0; i--) {
			maxHeapify(elementList, i);
		}
	}

	//Code to be completed
	/**
	 * Max-HeapMaximum Implementation
	 * Return the largest element in the input ArrayList assuming it is a heap.
	 * @param elementList - heap in an ArrayList
	 * @return the largest element in the heap given in the ArrayList
	 */
	public static <E extends Comparable<E>> E heapMax(ArrayList<E> elementList) {
		
		return elementList.get(0);	
	}

	/**
	 * Max-HeapExtractMax Implementation
	 * Extract the largest element in the heap given in the ArrayList and return it.
	 * @param elementList - heap in an ArrayList
	 * @return the largest element in the heap
	 */
	public static <E extends Comparable<E>> E heapExtractMax(ArrayList<E> elementList) {
		
		E deletedNode = elementList.get(1);
		int max = 1;
		
		swapElements(elementList, max, elementList.size()-1); //swapping the max element with the last element
		elementList.remove(elementList.size()-1);
		maxHeapify(elementList, max); //turns the heap back into a heap by calling heapify on the new max element
		
		return deletedNode;
	}

	/**
	 * Max-HeapIncreaseKey Implementation.
	 * Increase the value (priority) of the element at the ith index to newKey if it is larger than the curent value.
	 * @param elementList - heap in an ArrayList
	 * @param i - index of the element
	 * @param newKey - new value of the key
	 * @return success or failure of the operation.
	 */
	public static <E extends Comparable<E>> boolean heapIncreaseKey(ArrayList<E> elementList, int i, E newKey) {
		if(i > 0 && i < elementList.size() && null != newKey && (elementList.get(i).compareTo(newKey) < 0)) {
			//Valid index and key larger than current key.
			elementList.set(i, newKey); //Update the value/key at the specified index.
			//Float the value up in the tree until parent is larger than this key/value 
			//OR this node does not have a parent (it is the root).
			while(parent(i)> 0 && elementList.get(i).compareTo(elementList.get(parent(i))) > 0) {
				swapElements(elementList, i, parent(i));
				i = parent(i);
			}
			return true;
		}
		return false;
	}

	/**
	 * Max-HeapDecreaseKey Implementation.
	 * Decrease the value (priority) of the element at the ith index to newKey if the request is valid.
	 * @param elementList - heap in an ArrayList
	 * @param i - index of the element
	 * @param newKey - new value of the key
	 * @return success or failure of the operation.
	 */
	public static <E extends Comparable<E>> boolean heapDecreaseKey(ArrayList<E> elementList, int i, E newKey) {
		
		if (elementList.get(i) == null)
			return false;
		
		elementList.set(i, newKey);
		maxHeapify(elementList, i);
		
		return true;
	}

	/**
	 * Insert the given key to the heap
	 * @param <E>
	 * @param elementList - heap in an ArrayList
	 * @param key -  new value to be inserted to the heap
	 */
	public static <E extends Comparable<E>> void heapInsert(ArrayList<E> elementList, E key) {
		if(elementList.size() == 0) { //If we are adding element to an empty Heap, we add a dummy element to the front.
			elementList.add(key); //Dummy element
			elementList.add(key); //Add actual element.
			return; //Done
		}
		
		elementList.add(key); //adding element to end of the arrayList
		
		int index = elementList.size()-1; //index is the index of the element added
		int parentIndex = 0;			//parentIndex is the index of its parent
		
		if (index % 2 == 1)
			parentIndex = (index - 1) / 2;
		else if (index % 2 == 0)
			parentIndex = index / 2; 	//here I find the actual parentIndex
		
		while (key.compareTo(elementList.get(parentIndex)) > 0) { //now we loop until the parentIndex element is greater than the inserted element
			
			swapElements(elementList, index, parentIndex); //we swap indexes to move the larger element up the heap
			
			index = parentIndex; //now we setup index and parentIndex to go through the loop again
			
			if (parentIndex % 2 == 0)
				parentIndex = parentIndex / 2;
			else if (parentIndex % 2 == 1)
				parentIndex = (parentIndex - 1) / 2;
			
		}
	}

	//Utility Methods
	//Methods to get indices
	/**
	 * Return the index of the parent node of node i (if exists)
	 * @param i
	 * @return index of the parent node of the node i if i is not the root. if i  the root, returns -1;
	 */
	public static int parent(int i) {
		if(i > 1)
			return i/2;
		else
			return -1;
	}

	/**
	 * Return the index of the left child of the node i
	 * @param i
	 * @return index of the left child of the node i
	 */
	public static int leftChild(int i) {
		return i*2;
	}

	/**
	 * Return the index of the right child of the node i
	 * @param i
	 * @return index of the right child of the node i
	 */
	public static int rightChild(int i) {
		return i*2+1;
	}

	//Swap elements
	/**
	 * Exchange elements in locations i and j in the heap elements array (ArrayList).
	 * @param i
	 * @param j
	 */
	public static <E> void swapElements(ArrayList<E> elementList, int i, int j) {
		E temp = elementList.get(i);
		elementList.set(i, elementList.get(j));
		elementList.set(j, temp);
	}

	//Print ArrayList
	/**
	 * Utility function to print the Heap stored in an ArrayList
	 * @param list
	 */
	public static <E> void printArrayList(ArrayList<E> list) {
		if(list.size() > 1) {
			System.out.print("Heap is: [ ");
			for(int i=1; i<list.size()-1; i++)//Note here the first element is ignored as it is a dummy element
				System.out.print(i + ":" + list.get(i) + ", ");
			System.out.print((list.size()-1) + ":" + list.get(list.size()-1));
			System.out.println(" ]");
		}
		else
			System.out.println("Heap is Empty!");
	}
}
