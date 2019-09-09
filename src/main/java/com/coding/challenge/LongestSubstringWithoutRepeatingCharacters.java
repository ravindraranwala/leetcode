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
		Map<Character, Integer> charDistributionMap = new HashMap<>();
		int maxLength = 0, substrLen = 0;
		for (int i = 0, n = s.length(), windowStart = 0; i < n; i++) {
			final int previousIdx = charDistributionMap.getOrDefault(s.charAt(i), -1);
			// Checking for a duplicate.
			if (previousIdx != -1 && previousIdx >= windowStart) {
				maxLength = Math.max(maxLength, substrLen);
				windowStart = previousIdx + 1;
				substrLen = i - windowStart;
			}
			substrLen++;
			charDistributionMap.put(s.charAt(i), i);

		}
		maxLength = Math.max(maxLength, substrLen);
		return maxLength;
	}
}
