package basic.algorithm.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class LowestLLexicography {
	
	public static class MyComparator implements Comparator<String> {

		@Override
		public int compare(String o1, String o2) {
			return (o1 + o2).compareTo(o2 + o1);
		}
		
		
		public static String lowestString(String[] strs) {
			if (strs == null || strs.length == 0) {
				return "";
			}
			Arrays.parallelSort(strs, new MyComparator());
			String res = "";
			for (int i = 0; i < strs.length; i++) {
				res += strs[i];
			}
			return res;
		}
		
		public static void main(String[] args) {
			String[] strs1 = {"jibw", "ji", "jb", "bw"};
			
			System.out.println(lowestString(strs1));
		}
	}
}
