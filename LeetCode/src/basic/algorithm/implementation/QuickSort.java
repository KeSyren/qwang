package basic.algorithm.implementation;

// enhancement version
public class QuickSort {
	public static void quickSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		quickSortProcess(arr, 0, arr.length - 1);
	}

	public static void quickSortProcess(int[] arr, int L, int R) {
		if (L < R) {
			//swap(arr, L+(int)(Math.random() * (R-L+1)), R);
			int[] p = partition(arr, L, R);
			quickSortProcess(arr, L, p[0] - 1);
			quickSortProcess(arr, p[1] + 1, R);
		}
	}

	// arr[R] == num, L is the current pointer
	// index from p[0] to p[1] in array are equal to num
	public static int[] partition(int[] arr, int L, int R) {
		int less = L - 1;
		int more = R;   // pivot
		while (L < more) {
			if (arr[L] < arr[R]) {
				swap(arr, ++less, L++);
			} else if (arr[L] > arr[R]) {
				swap(arr, --more, L);
			} else {
				L++;
			}
		}
		swap(arr, more, R);
		return new int[] {less + 1, more};
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 9, 1, 3, 4, 3, 2, 5 };
		quickSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
