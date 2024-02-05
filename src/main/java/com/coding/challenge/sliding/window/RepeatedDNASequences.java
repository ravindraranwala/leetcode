package com.coding.challenge.sliding.window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class RepeatedDNASequences {
	RepeatedDNASequences() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
		System.out.println(findRepeatedDnaSequences("AAAAAAAAAAAAA"));
	}

	static List<String> findRepeatedDnaSequences(String s) {
		final int n = s.length();
		final Map<String, Integer> f = new HashMap<>();
		// Fixed size window.
		for (int i = 0, w = 10; i < n; i++)
			if (i >= w - 1)
				f.merge(s.substring(i - w + 1, i + 1), 1, Integer::sum);

		final List<String> ans = new ArrayList<>();
		for (String key : f.keySet())
			if (f.get(key) > 1)
				ans.add(key);
		return ans;
	}
}
