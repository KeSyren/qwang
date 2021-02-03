package basic.algorithm.dynamicprogramming;

/**
 * 
 * Find a shortest path from left upper corner to right down corner of a matrix.
 * And each element is positive. Two actions: move right or move down. [ 1 3 1 2
 * 0 5 7 8 1 0 8 9 6 0 1 ]
 * 
 * 
 * @author qingwang
 *
 */
public class ShortestPath {

	// defind a function walk that return the shortest path from the current
	// position to right corner.
	public static int walk(int[][] matrix, int i, int j) {
		if (i == matrix.length - 1 && j == matrix[0].length - 1) {
			return matrix[i][j];
		}
		if (i == matrix.length - 1) { // only move right
			return matrix[i][j] + walk(matrix, i, j + 1);
		}
		if (j == matrix[0].length - 1) {
			return matrix[i][j] + walk(matrix, i + 1, j);
		}

		// right -> the shortest path(matrix[i][j+1], matrix[matrix.length-1][matrix[0].length-1])
		int moveRight = walk(matrix, i, j + 1); 
		// down -> the shortest path(matrix[i+1][j], matrix[matrix.length-1][matrix[0].length-1])
		int moveDown = walk(matrix, i + 1, j); 

		return matrix[i][j] + Math.min(moveRight, moveDown);

	}
	
	public static boolean isSum(int[] arr, int i, int sum, int aim) {
		if (i == arr.length) return sum == aim;
		return isSum(arr, i+1, sum, aim) || isSum(arr, i+1, sum + arr[i], aim); // choose or not choose the ith element. 
	}

	public static void main(String[] args) {
		int[] arr = {1,4,8};
		int aim = 12;
		System.out.println(isSum(arr, 0,0,aim));
	}
}
