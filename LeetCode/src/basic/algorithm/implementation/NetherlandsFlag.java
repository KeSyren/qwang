package basic.algorithm.implementation;

/**
 * sort an array and given a num. numbs < num, numbs= num, numbs> num
 */

public class NetherlandsFlag {

	public static int[] partition(int[] arr, int L, int R, int num) {
		int less = L - 1;
		int more = R + 1;
		int curr = L;   //current pointer
		while (curr < more) {
			if (arr[curr] < num) {
				swap(arr, ++less, curr++);
			} else if (arr[curr] > num) {
				swap(arr, --more, curr);
			} else {                     // arr[curr] == num
				curr++;
			}
		}
		return arr;
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static void main(String[] args) {
		int[] a = new int[]{1,3,4,3,2,5};
		int[] res = new int[a.length];
		res = partition(a, 0, a.length-1, 3);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}
	
}
