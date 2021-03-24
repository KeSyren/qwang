package easy.array.operation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinSubsequence {
	
	public static List<Integer> minSubsequence(int[] nums){
		int total_sum = 0;
		List<Integer> result = new ArrayList<Integer>();
		int local_sum = 0;
		int length = nums.length;
		for (int i : nums) {
			total_sum += i;
		}
		
		Arrays.sort(nums);
		for (int i = nums.length-1; i>=0; i--) {
			if (local_sum > (total_sum /2))
				break;
			else {
				result.add(nums[i]);
				local_sum += nums[i];
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[]{4,3,10,9,8};
		List<Integer> result = minSubsequence(nums);
		for(int i=0;i<result.size();i++)  {
			System.out.println(result.get(i));
		}
	}
}
