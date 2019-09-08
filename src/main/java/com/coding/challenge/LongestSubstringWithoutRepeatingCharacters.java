package com.coding.challenge;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		// final String str = "abcabcbb";
		// final String str = "bbbbb";
		// final String str = "pwwkew";
		// final String str = "abcde";
		// final String str = " ";
		// final String str = "abcabcdef";
		// final String str = "dvdf";
		final String str = "qrsvbspk";
		final int longestSubstring = lengthOfLongestSubstring(str);
		System.out.println(longestSubstring);
	}

	public static int lengthOfLongestSubstring(String s) {
		char[] chars = s.toCharArray();
		Map<Character, Integer> charDistributionMap = new HashMap<>();
		int maxLength = 0, windowStart = 0, substrLen = 0;
		for (int i = 0, n = chars.length; i < n; i++) {
			final int previousIdx = charDistributionMap.getOrDefault(chars[i], -1);
			// Checking for a duplicate.
			if (previousIdx != -1 && previousIdx >= windowStart) {
				maxLength = substrLen > maxLength ? substrLen : maxLength;
				windowStart = previousIdx + 1;
				substrLen = i - windowStart;
			}
			substrLen++;
			charDistributionMap.put(chars[i], i);

		}
		maxLength = Integer.max(maxLength, substrLen);
		return maxLength;
	}
}
