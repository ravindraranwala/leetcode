package com.coding.challenge.bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class WordLadder {
	private static final char[] ALPHABET = "abcdefghijklmnopqrstuvwxyz".toCharArray();

	WordLadder() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")) == 5;
		assert ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log")) == 0;
	}

	static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		final Set<String> dictionary = new HashSet<>(wordList);
		final Queue<Vertex> q = new ArrayDeque<>();
		dictionary.remove(beginWord);
		q.offer(new Vertex(beginWord, 1));
		while (!q.isEmpty()) {
			final Vertex u = q.poll();
			// explore u's adjacency list.
			final int l = u.word.length();
			final char[] a = u.word.toCharArray();
			for (int i = 0; i < l; i++) {
				for (char ch : ALPHABET) {
					a[i] = ch;
					final String nextWord = new String(a);
					if (dictionary.contains(nextWord)) {
						if (endWord.equals(nextWord))
							return u.d + 1;
						dictionary.remove(nextWord);
						q.offer(new Vertex(nextWord, u.d + 1));
					}
				}
				a[i] = u.word.charAt(i);
			}
		}
		return 0;
	}

	static class Vertex {
		private final String word;
		private final int d;

		public Vertex(String word, int d) {
			this.word = word;
			this.d = d;
		}
	}
}
