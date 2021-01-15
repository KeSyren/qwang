package basic.algorithm.recursion;

public class FindMax {
	
	public static int getMax(int[] arr, int L, int R) {
		
		if (L == R) {
			return arr[L];
		}
		
		int mid = (L + R)/2;
		int maxLeft = getMax(arr, L, mid);
		int maxRight = getMax(arr, mid+1, R);
		
		return Math.max(maxLeft, maxRight);
	}
	
	public static void main(String[] args) {
		int[] arr = {4,2,31};
		System.out.println(getMax(arr, 0, arr.length-1));
		
	} 
	
	
	
	/**
	 * time complexity
	 * T(N) = 2T(N/2) + O(1)
	 * General Analysis: T(N) = aT(N/b) + O(N^d)
	 * 1) log(b, a) > d -> time complexity = O(N^log(b,a))
	 * 2) log(b, a) = d -> time complexity = O(N^d * logN)
	 * 3) log(b, a) < d -> time complexity = O(N^d)
	 * 
	 */

}
