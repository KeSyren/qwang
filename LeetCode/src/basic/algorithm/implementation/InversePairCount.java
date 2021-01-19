package basic.algorithm.implementation;

public class InversePairCount {

	public static int inversePairCount(int[] arr) {
		if (arr == null || arr.length < 2) {
			return 0;
		}
		return mergeSort(arr, 0, arr.length - 1);
	}

	public static int mergeSort(int[] arr, int L, int R) {
		if (R == L) {
			return 0;
		}

		int mid = L + ((R - L) >> 1);
		return mergeSort(arr, L, mid) + mergeSort(arr, mid + 1, R) + merge(arr, L, mid, R);
	}

	public static int merge(int[] arr, int L, int mid, int R) {
		int[] help = new int[R - L + 1]; // help array
		int p1 = L;
		int p2 = mid + 1;
		int i = 0;

		int res = 0;
		while (p1 <= mid && p2 <= R) {
			res += arr[p1] < arr[p2] ? 0 : (mid - p1 + 1);
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}

		while (p1 <= mid) {
			help[i++] = arr[p1++];
		}

		while (p2 <= R) {
			help[i++] = arr[p2++];
		}

		for (i = 0; i < help.length; i++) {
			arr[L + i] = help[i];
		}
		return res;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 6, 1, 2, 4, 3, 5};

		int res = inversePairCount(a);
		System.out.println(res);

		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
