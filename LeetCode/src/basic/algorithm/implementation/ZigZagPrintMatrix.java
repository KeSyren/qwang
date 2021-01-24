package basic.algorithm.implementation;

/**
 * Zig zag print a matrix
 * 
 * @author qingwang
 *
 */
public class ZigZagPrintMatrix {

	public static void printMatrixZigZag(int[][] matrix) {
		int aR = 0; // A(0, 0) A always moves along x then y.
		int aC = 0;
		int bR = 0; // B(0, 0) B always moves along y then x.
		int bC = 0;
		int endR = matrix.length - 1;
		int endC = matrix[0].length - 1;

		boolean fromUp = false;
		while (aR != endR + 1) { // A is at the last row.
			printLevel(matrix, aR, aC, bR, bC, fromUp);
			aR = aC == endC ? aR + 1 : aR;  // except A is at endC, aR = aR;
			aC = aC == endC ? aC : aC + 1;  //except A is at endC, aC = aC+ 1;
			
			bC = bR == endR ? bC + 1 : bC;  // except B is at endR, bC = bC;
			bR = bR == endR ? bR : bR + 1;  // except B is at endR, bR = bR + 1;
			fromUp = !fromUp;
		}
		System.out.println();
	}

	public static void printLevel(int[][] m, int aR, int aC, int bR, int bC, boolean f) {
		if (f) {
			while (aR != bR + 1) {
				System.out.print(m[aR++][aC--] + " ");
			}
		} else {
			while (bR != aR - 1) {
				System.out.print(m[bR--][bC++] + " ");
			}
		}
		
	}
		
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3,4},
				          {5,6,7,8},
				          {9,10,11,12}};
		printMatrixZigZag(matrix);
	}

}
