package basic.algorithm.implementation;

/**
 * Time complexity O(N^2) Space complexity O(1) 1. find the minimum element 2.
 * swap the found element with the first element
 * 
 * @author qingwang
 *
 */
public class SelectionSort {

	public static void sort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int min_idx = i;
			for (int j = i+1; j < arr.length; j++) {
				if (arr[j] < arr[min_idx]) {
					min_idx = j;
				}
			}
			swap(arr, i, min_idx);
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public static void main(String[] args) {
		int[] a = new int[] {41,1,3,2,5,4};
		sort(a);
		for (int i = 0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		
	}

}
