package basic.algorithm.implementation;

/**
 * O(N) find the MaxGap
 * 
 * @author qingwang
 *
 */
public class MaxGap {

	public static int maxGap(int[] nums) {
		if (nums == null || nums.length < 2) {
			return 0;
		}

		int len = nums.length;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		// find max and min of nums
		for (int i = 0; i < len; i++) {
			min = Math.min(min, nums[i]);
			max = Math.max(max, nums[i]);
		}

		if (min == max)
			return 0;

		boolean[] hasnum = new boolean[len + 1]; // has nums
		int[] maxs = new int[len + 1]; // max value of each bin
		int[] mins = new int[len + 1]; // min value of each bin
		int bid = 0;
		// three variables min max hasnum for each bin
		for (int i = 0 ; i < len; i++) {
			bid = bucket(nums[i], len, min, max);
			mins[bid] = hasnum[bid]? Math.min(mins[bid], nums[i]) : nums[i];
			maxs[bid] = hasnum[bid]? Math.max(maxs[bid], nums[i]) : nums[i];
			hasnum[bid] = true;
		}
		int res = 0;
		int lastMax  = maxs[0];
		int i = 1;
		
		//difference between two non-empty bin
		for(; i <= len; i++) {
			if (hasnum[i]) {
				res= Math.max(res, mins[i]-lastMax);
				lastMax = maxs[i];
			}
		}
		return res;
	}

	public static int bucket(long num, long len, long min, long max) {
		return (int) ((num - min) * len / (max - min));
	}
	
	public static void main(String[] args) {
		int[] a = new int[]{1,3,31,2,8};
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		System.out.println(maxGap(a));
	}
	
	
}
