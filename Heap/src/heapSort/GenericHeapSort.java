package heapSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Shruti
 *
 * @param <AnyType>
 */
public class GenericHeapSort<AnyType extends Comparable<AnyType>> {
	private int getLeft(int i) {
		return (2 * i + 1);
	}

	private int getRight(int i) {
		return (2 * i + 2);
	}

	private void maxHeapify(List<AnyType> arr, int i) {
		int leftChildIndex = getLeft(i);
		int rightChildIndex = getRight(i);
		int heapSize = arr.size();
		int largest = 0;

		if (leftChildIndex < heapSize) {
			if (arr.get(leftChildIndex).compareTo(arr.get(i)) > 0) {
				largest = leftChildIndex;
			} else {
				largest = i;
			}
		} else {
			largest = i;
		}

		if (rightChildIndex < heapSize) {
			if (arr.get(rightChildIndex).compareTo(arr.get(i)) > 0) {
				largest = arr.get(rightChildIndex).compareTo(arr.get(leftChildIndex)) > 0 ? rightChildIndex
						: leftChildIndex;
			}
		}

		if (largest != i) {
			Collections.swap(arr, i, largest);
			maxHeapify(arr, largest);
		}
	}

	/**
	 * @Description Takes a list of comparable objects and the index of the first
	 *              parent node just one level up the leaf nodes and builds a
	 *              maxHeap
	 * 
	 */
	public void buildMaxHeap(List<AnyType> arr) {
		int heapSize = arr.size();
		for (int i = (heapSize / 2) - 1; i >= 0; i--) {
			maxHeapify(arr, i);
		}

	}

	private void minHeapify(List<AnyType> arr, int i) {
		int l = getLeft(i);
		int r = getRight(i);
		int heapSize = arr.size();
		int largest = 0;

		if (l < heapSize) {
			if (arr.get(l).compareTo(arr.get(i)) < 0) {
				largest = l;
			} else {
				largest = i;
			}
		} else {
			largest = i;
		}

		if (r < heapSize) {
			if (arr.get(r).compareTo(arr.get(i)) < 0) {
				largest = arr.get(r).compareTo(arr.get(l)) < 0 ? r : l;
			}
		}

		if (largest != i) {
			Collections.swap(arr, i, largest);
			minHeapify(arr, largest);
		}
	}

	/**
	 * @param List<T>arr:
	 *            List of comparable objects
	 * @Description Takes a list of comparable objects and the index of the first
	 *              parent node just one level up the leaf nodes and builds a
	 *              minHeap
	 * 
	 */
	public void buildMinHeap(List<AnyType> arr) {
		int heapSize = arr.size();
		for (int i = (heapSize / 2) - 1; i >= 0; i--) {
			minHeapify(arr, i);
		}

	}

	/**
	 * @Description Takes a List of Comparable objects and sorts them in descending
	 *              order using heapsort.Gives compilation error Bound Mismatch if
	 *              class of the given objects is not implementing
	 *              java.lang.Comparable
	 */
	public void sortDesc(List<AnyType> arr) {
		buildMaxHeap(arr);
		List<AnyType> sortedList = new ArrayList<AnyType>();
		int loopIteration = arr.size();
		for (int i = 0; i < loopIteration; i++) {

			sortedList.add(arr.get(0));
			arr = arr.subList(1, arr.size());
			buildMaxHeap(arr);
		}
	}

	/**
	 * @Description Takes a List of Comparable objects and sorts them in ascending
	 *              order using heapsort. Gives compilation error Bound Mismatch if
	 *              class of the given objects is not implementing
	 *              java.lang.Comparable
	 * 
	 */
	public void sortAsc(List<AnyType> arr) {
		buildMinHeap(arr);
		List<AnyType> sortedList = new ArrayList<AnyType>();
		int loopIteration = arr.size();
		for (int i = 0; i < loopIteration; i++) {

			sortedList.add(arr.get(0));
			arr = arr.subList(1, arr.size());
			buildMinHeap(arr);
		}
	}
}
