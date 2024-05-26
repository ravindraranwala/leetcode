package com.coding.challenge.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.coding.challenge.trie.Trie;

class WordBreakII {
	WordBreakII() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final List<String> wordDict1 = Arrays.asList("cat", "cats", "and", "sand", "dog");
		final List<String> sentences1 = Arrays.asList("cat sand dog", "cats and dog");
		assert sentences1.equals(wordBreak("catsanddog", wordDict1));

		final List<String> wordDict2 = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
		final List<String> sentences2 = Arrays.asList("pine apple pen apple", "pine applepen apple",
				"pineapple pen apple");
		assert sentences2.equals(wordBreak("pineapplepenapple", wordDict2));

		final List<String> wordDict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
		assert wordBreak("catsandog", wordDict3).isEmpty();
	}

	static List<String> wordBreak(String s, List<String> wordDict) {
		final int n = s.length();
		final List<List<String>> sentences = new ArrayList<>();
		for (int i = 0; i < n; i++)
			sentences.add(new ArrayList<>());

		// build a trie with the dictionary.
		final Trie trie = new Trie();
		for (String word : wordDict)
			trie.insert(word);

		for (int i = n - 1; i >= 0; i--) {
			for (int j = i; j < n; j++) {
				final String curr = s.substring(i, j + 1);
				if (trie.search(curr)) {
					if (j == n - 1)
						sentences.get(i).add(curr);
					else
						for (String sentence : sentences.get(j + 1))
							sentences.get(i).add(curr + " " + sentence);
				}
			}
		}
		return sentences.get(0);
	}
}
