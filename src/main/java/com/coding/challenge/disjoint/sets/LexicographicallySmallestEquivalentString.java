package com.coding.challenge.disjoint.sets;

class LexicographicallySmallestEquivalentString {
	private static final char FIRST_LETTER = 'a';
	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

	LexicographicallySmallestEquivalentString() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert "aab".equals(smallestEquivalentString("abc", "cde", "eed"));
		assert "makkek".equals(smallestEquivalentString("parker", "morris", "parser"));
		assert "hdld".equals(smallestEquivalentString("hello", "world", "hold"));
		assert "aauaaaaada".equals(smallestEquivalentString("leetcode", "programs", "sourcecode"));
	}

	static String smallestEquivalentString(String s1, String s2, String baseStr) {
		final Node[] a = new Node[26];
		for (int i = 0; i < 26; i++)
			a[i] = makeSet(i);

		final int m = s1.length();
		for (int i = 0; i < m; i++) {
			// think of this as an edge in our graph.
			final Node u = a[s1.charAt(i) - FIRST_LETTER];
			final Node v = a[s2.charAt(i) - FIRST_LETTER];
			if (findSet(u) != findSet(v))
				union(u, v);
		}

		final int[] mapping = new int[26];
		for (int i = 0; i < 26; i++)
			mapping[i] = findSet(a[i]).rank;

		final StringBuilder ans = new StringBuilder();
		for (char ch : baseStr.toCharArray())
			ans.append(ALPHABET.charAt(mapping[ch - FIRST_LETTER]));

		return ans.toString();
	}

	// Disjoint set operations are implemented here.
	static Node makeSet(int rank) {
		final Node x = new Node();
		x.p = x;
		x.rank = rank;
		return x;
	}

	static void union(Node x, Node y) {
		link(findSet(x), findSet(y));
	}

	private static void link(Node x, Node y) {
		// union by rank heuristic.
		if (x.rank > y.rank)
			x.p = y;
		else
			y.p = x;
	}

	static Node findSet(Node x) {
		if (x != x.p)
			x.p = findSet(x.p);// Path compression.

		return x.p;
	}

	static class Node {
		private int rank;
		private Node p;
	}
}
