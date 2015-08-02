package easy.string.operation;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two strings s and t, write a function to determine if t is an anagram
 * of s. For example, s = "anagram", t = "nagaram", return true. s = "rat", t =
 * "car", return false.
 * 
 * @author qwang
 *
 *         Solution: It creates a size 26 int arrays as buckets for each letter
 *         in alphabet. It increments the bucket value with String s and
 *         decrement with string t. So if they are anagrams, all buckets should
 *         remain with initial value which is zero.
 */

public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
		if(s == null||t == null||s.length() != t.length()) return false;
		int[] alphabet = new int[26];
		for(int i = 0; i < s.length(); i++) alphabet[s.charAt(i)-'a']++;
		for(int j = 0; j < t.length(); j++) alphabet[t.charAt(j)-'a']--;
		for(int i : alphabet) if(i !=0) return false;
		return true;
	}
}
