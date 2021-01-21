package basic.algorithm.implementation;

/**
 * O(N^2)
 * @author qingwang
 *
 */
public class InsertSort {

	public static void sort (int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i-1;
			
			
			/*
			 * Move elements of arr[0...i-1], that are greater than key, 
			 * to one position ahead of their current position
			 */
			while (j >=0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}
			
			arr[j + 1] = key; 
		}
		
	}
	
	
	public static void main(String[] args) {
		int[] a = new int[] { 41, 1, 3, 2, 2, 5, 4 };
		sort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}

	}
}
