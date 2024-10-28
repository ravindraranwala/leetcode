package com.coding.challenge.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class RemoveSubFoldersFromTheFilesystem {
    private final TrieNode root = new TrieNode(false);
	private static final char DELIMITER = '/';

	RemoveSubFoldersFromTheFilesystem() {

	}

	public static void main(String[] args) {
		final String[] folder1 = { "/a", "/a/b", "/c/d", "/c/d/e", "/c/f" };
		System.out.println(new RemoveSubFoldersFromTheFilesystem().removeSubfolders(folder1));

		final String[] folder2 = { "/a", "/a/b/c", "/a/b/d" };
		System.out.println(new RemoveSubFoldersFromTheFilesystem().removeSubfolders(folder2));

		final String[] folder3 = { "/a/b/c", "/a/b/ca", "/a/b/d" };
		System.out.println(new RemoveSubFoldersFromTheFilesystem().removeSubfolders(folder3));

		final String[] folder4 = { "/a/b/c", "/abc/d" };
		System.out.println(new RemoveSubFoldersFromTheFilesystem().removeSubfolders(folder4));
	}

	List<String> removeSubfolders(String[] folder) {
        for (String f : folder)
			insert(f);

		final List<String> folders = new ArrayList<>();
		for (String f : folder)
			if (!subFolder(f))
				folders.add(f);

		return folders;
	}

    private void insert(String folder) {
		final int m = folder.length();
		TrieNode curr = root;
		int i = 1;
		for (int j = 1; j < m; j++) {
			if (folder.charAt(j) == DELIMITER) {
				final String name = folder.substring(i, j);
				if (!curr.children.containsKey(name))
					curr.children.put(name, new TrieNode(false));
				curr = curr.children.get(name);
				// starts a new window.
				i = j + 1;
			}
		}
		final String key = folder.substring(i, m);
		if (curr.children.containsKey(key))
			curr.children.get(key).folder = true;
		else
			curr.children.put(key, new TrieNode(true));
	}

	private boolean subFolder(String folder) {
		final int m = folder.length();
		TrieNode curr = root;
		int i = 1;
		for (int j = 1; j < m; j++) {
			if (folder.charAt(j) == DELIMITER) {
				final String name = folder.substring(i, j);
				curr = curr.children.get(name);
				if (curr.folder)
					return true;
				// starts a new window.
				i = j + 1;
			}
		}
		return false;
	}

	static class TrieNode {
		private boolean folder;
		private final Map<String, TrieNode> children;

		TrieNode(boolean folder) {
			this.folder = folder;
			this.children = new HashMap<>();
		}
	}
}
