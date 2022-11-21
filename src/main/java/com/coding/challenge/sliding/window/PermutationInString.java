package com.coding.challenge.sliding.window;

import java.util.HashMap;
import java.util.Map;

class PermutationInString {
	PermutationInString() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert checkInclusion("ab", "eidbaooo");
		
		assert !checkInclusion("ab", "eidboaoo");
	}

	static boolean checkInclusion(String s1, String s2) {
		final int m = s1.length();
		final Map<Character, Integer> sf = new HashMap<>();
		for (char ch : s1.toCharArray())
			sf.merge(ch, 1, Integer::sum);

		final int n = s2.length();
		final Map<Character, Integer> wf = new HashMap<>();
		int c = 0;
		boolean ans = false;

		for (int i = 0; i < n; i++) {
			final char endCh = s2.charAt(i);
			wf.merge(endCh, 1, Integer::sum);
			if (wf.get(endCh).equals(sf.get(endCh)))
				c = c + 1;
			if (i >= m - 1) {
				ans = ans || c == sf.size();
				// sliding the window by discarding the starting character
				final char startCh = s2.charAt(i - m + 1);
				if (wf.get(startCh).equals(sf.get(startCh)))
					c = c - 1;
				wf.put(startCh, wf.get(startCh) - 1);
			}
		}
		return ans;
	}
}
