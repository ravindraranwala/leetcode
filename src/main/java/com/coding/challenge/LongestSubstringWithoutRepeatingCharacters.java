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
		int maxLength = 0;
		for (int i = 0, n = chars.length; i < n; i++) {
			final Integer previousIdx = charDistributionMap.putIfAbsent(chars[i], i);
			// Checking for a duplicate.
			if (previousIdx != null) {
				final int substrLen = charDistributionMap.size();
				maxLength = substrLen > maxLength ? substrLen : maxLength;
				/*
				 * reset current char pointer back to one after the duplicate char's first
				 * occurrence.
				 */
				i = previousIdx;
				// we need to create a new map and start from the scratch again.
				charDistributionMap = new HashMap<>();
			}
		}

		maxLength = Integer.max(maxLength, charDistributionMap.size());
		return maxLength;
	}
}
