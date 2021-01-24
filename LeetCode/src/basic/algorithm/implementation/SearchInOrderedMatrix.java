package basic.algorithm.implementation;

/**
 * Search an element in N*M matrix (every row and column is sorted in increasing
 * order). Find K in matrix in O(N+M).
 */
public class SearchInOrderedMatrix {

	public static int[] search(int[][] matrix, int K) {
		if (matrix == null || matrix.length == 0)
			return null;
		int N = matrix.length - 1;
		int M = matrix[0].length - 1;

		
		
		// search from top right corner. 
		int i = 0;
		int j = M;

		while (K != matrix[i][j]) {
			
			if (K > matrix[i][j]) {
				i++;
			}
			if (K < matrix[i][j]) {
				j--;
			}
			if (K == matrix[i][j]) {
				return new int[] {i, j};
			}	
			
		}
		return new int[] {-1,-1};
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{ 10, 20, 30, 40 }, 
                          { 15, 25, 35, 45 }, 
                          { 27, 29, 37, 48 }, 
                          { 32, 33, 39, 50 } };
	
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
		}
		
		int[] res = search(matrix, 29);
		
		System.out.print("(" + (res[0]+1) + "," + (res[1]+1) + ")");
	
	}
	
}
