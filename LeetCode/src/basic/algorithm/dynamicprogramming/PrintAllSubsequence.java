package basic.algorithm.dynamicprogramming;

public class PrintAllSubsequence {
	public static void printAllSubsequence(char[] str, int i, String res) {
		if (i == str.length) {
			System.out.println(res);
			return;
		} 
		printAllSubsequence(str, i+1, res);
		printAllSubsequence(str, i+1, res + String.valueOf(str[i]));
	}
	
	public static void main(String[] args) {
		String test = "abc";
		printAllSubsequence(test.toCharArray(), 0, "");
	}
}
