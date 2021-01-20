package basic.algorithm.implementation;


/**
 * Quick sort (O(NlogN) and O(1)) is an in-place sort, 
 * i.e., it doesn't require any extra space. Merge sort (O(NlogN) and O(N))) need O(N) extra storage. 
 * @author qingwang
 *
 */
public class QuickSortBasic {
	public static void quickSort(int[] arr, int low, int high) {
		
		if(arr == null || arr.length <2) {
			return;
		}
		
		if (low < high) {
			int pi = partition(arr, low, high);
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		}

	}

	public static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low - 1;
		
		for (int j = low; j< high; j++) {
			if (arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i+1, high);
		return i+1;
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public static void main(String[] args) {
		int[] a = new int[] { 81,9, 1, 3, 4, 3, 2, 5 };
		quickSort(a, 0, a.length-1);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
