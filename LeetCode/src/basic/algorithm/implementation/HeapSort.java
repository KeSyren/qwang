package basic.algorithm.implementation;

/**
 * Very very important -- greedy algorithm
 * Construct maxheap (using array) heap sort
 * 1. convert an array to maxheap
 * 2. swap (arr, maxroot, lastleft)
 * 3. heapify
 * 
 * time complexity: O(NlogN)
 * space complexity: O(1)
 * @author qingwang
 *
 */

public class HeapSort {
	public static void heapSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			heapInsert(arr, i); // 0~i build max-heap
		}
		
		int heapSize = arr.length;
		while (heapSize > 0) {
			heapify(arr, 0, heapSize);
			swap(arr, 0, --heapSize);
		}
	}

	// build max heap time complexity O(N)=log1 + log2 + .. + logN
	public static void heapInsert(int[] arr, int index) {
		while (arr[index] > arr[(index - 1) / 2]) {
			swap(arr, index, (index - 1) / 2);
			index = (index - 1) / 2;
		}
	}

	public static void heapify(int[] arr, int index, int heapSize) {
		int left = index * 2 + 1;
		while (left < heapSize) {
			int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left; // left or right larger
			largest = arr[largest] > arr[index] ? largest : index;
			if (largest == index) {
				break;
			}
			swap(arr, largest, index);
			index = largest;
			left = index * 2 + 1;
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public static void main(String[] args) {
		int[] a = new int[]{8,1};
		
		heapSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

}
