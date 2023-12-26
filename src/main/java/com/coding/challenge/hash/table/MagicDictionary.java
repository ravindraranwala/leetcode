package com.coding.challenge.hash.table;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class MagicDictionary {
	private final Map<Integer, List<String>> t = new HashMap<>();

	public MagicDictionary() {
	}

	public static void main(String[] args) {
		MagicDictionary magicDictionary = new MagicDictionary();
		final String[] dictionary = { "hello", "leetcode" };
		magicDictionary.buildDict(dictionary);
		assert !magicDictionary.search("hello");
		assert magicDictionary.search("hhllo");
		assert !magicDictionary.search("hell");
		assert !magicDictionary.search("leetcoded");

	}

	public void buildDict(String[] dictionary) {
		for (String s : dictionary)
			t.computeIfAbsent(s.length(), unused -> new ArrayList<>()).add(s);
	}

	public boolean search(String searchWord) {
		final int n = searchWord.length();
		for (String s : t.getOrDefault(n, Collections.emptyList())) {
			int diffCnt = 0;
			for (int i = 0; i < n; i++)
				if (s.charAt(i) != searchWord.charAt(i))
					diffCnt = diffCnt + 1;

			if (diffCnt == 1)
				return true;
		}
		return false;
	}
}
