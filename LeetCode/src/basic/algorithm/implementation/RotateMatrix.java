package basic.algorithm.implementation;


/**
 * rotate a matrix in O(1).
 * @author qingwang
 *
 */
public class RotateMatrix {

	public static void rotate(int[][] matrix) {
		int tR = 0; // top row
		int tC = 0;
		int dR = matrix.length - 1;
		int dC = matrix[0].length - 1;

		while (tR < dR) {
			rotateEdge(matrix, tR++, tC++, dR--, dC--);
		}
	}

	public static void rotateEdge(int[][] m, int tR, int tC, int dR, int dC) {
		int times = dC - tC;
		int tmp = 0;
		for (int i = 0; i <= times; i++) {
			tmp = m[tR][tC + i];
			m[tR][tC + i] = m[dR - i][tC];
			m[dR - i][tC] = m[dR][dC - i];
			m[dR][dC - i] = m[tR + i][dC];
			m[tR + i][dC] = tmp;
		}

	}
	
	public static void printMatrix (int[][] m) {
		int row = m.length;
		int col = m[0].length;
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(m[i][j] + " ");
				if (j == col-1) {
					System.out.println();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] arr = new int[][]{{ 1, 2}, { 3, 4 }}; 
		printMatrix(arr);
	}

}
