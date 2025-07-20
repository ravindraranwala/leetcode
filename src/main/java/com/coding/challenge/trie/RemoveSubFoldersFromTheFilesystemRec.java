package com.coding.challenge.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class RemoveSubFoldersFromTheFilesystemRec {
	RemoveSubFoldersFromTheFilesystemRec() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String[] f1 = { "/a", "/a/b", "/c/d", "/c/d/e", "/c/f" };
		assert Arrays.asList("/a", "/c/d", "/c/f").equals(removeSubfolders(f1));

		final String[] f2 = { "/a", "/a/b/c", "/a/b/d" };
		assert Arrays.asList("/a").equals(removeSubfolders(f2));

		final String[] f3 = { "/a/b/c", "/a/b/ca", "/a/b/d" };
		assert Arrays.asList("/a/b/c", "/a/b/ca", "/a/b/d").equals(removeSubfolders(f3));
	}

	static List<String> removeSubfolders(String[] folder) {
		final TrieNode root = new TrieNode();
		for (String f : folder)
			add(f, 1, root, f.length());

		final List<String> l = new ArrayList<>();
		for (String f : folder)
			if (!subFolder(f, 1, root, f.length()))
				l.add(f);

		return l;
	}

	private static void add(String path, int i, TrieNode p, int n) {
		if (i >= n) {
			p.folder = true;
			return;
		}
		// read in the next token.
		int j = i;
		while (j < n && path.charAt(j) != '/')
			j = j + 1;

		final TrieNode curr = p.t.merge(path.substring(i, j), new TrieNode(), (a, b) -> a);
		add(path, j + 1, curr, n);
	}

	private static boolean subFolder(String path, int i, TrieNode p, int n) {
		if (i >= n)
			return false;

		if (p.folder)
			return true;

		// read in the next token.
		int j = i;
		while (j < n && path.charAt(j) != '/')
			j = j + 1;

		return subFolder(path, j + 1, p.t.get(path.substring(i, j)), n);
	}

	static class TrieNode {
		private boolean folder;
		private final Map<String, TrieNode> t = new HashMap<>();
	}
}
