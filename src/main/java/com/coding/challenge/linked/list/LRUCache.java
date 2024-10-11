package com.coding.challenge.linked.list;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
	final Map<Integer, LinkNode> t;
	final LinkNode dummyHead = new LinkNode(-1, -1);
	LinkNode tail = dummyHead;
	final int capacity;
	int size = 0;

	LRUCache(int capacity) {
		this.capacity = capacity;
		t = new HashMap<>(capacity);
	}

	public static void main(String[] args) {
		final LRUCache lRUCache = new LRUCache(2);
		lRUCache.put(1, 1);
		lRUCache.put(2, 2);
		assert lRUCache.get(1) == 1;
		lRUCache.put(3, 3);
		assert lRUCache.get(2) == -1;
		lRUCache.put(4, 4);
		assert lRUCache.get(1) == -1;
		assert lRUCache.get(3) == 3;
		assert lRUCache.get(4) == 4;

		final LRUCache lRUCache2 = new LRUCache(1);
		lRUCache2.put(2, 1);
		assert lRUCache2.get(2) == 1;
		lRUCache2.put(3, 2);
		assert lRUCache2.get(2) == -1;
		assert lRUCache2.get(3) == 2;
	}

	public int get(int key) {
		if (t.containsKey(key)) {
			final LinkNode curr = t.get(key);
			remove(curr);
			addToTail(curr);
			return curr.val;
		}
		return -1;
	}

	private void remove(LinkNode curr) {
		curr.prev.next = curr.next;
		if (curr == tail)
			tail = tail.prev;
		else
			curr.next.prev = curr.prev;
	}

	private void addToTail(LinkNode curr) {
		tail.next = curr;
		curr.prev = tail;
		tail = tail.next;
	}

	public void put(int key, int value) {
		if (t.containsKey(key)) {
			final LinkNode curr = t.get(key);
			curr.val = value;
			remove(curr);
			addToTail(curr);
		} else {
			if (size == capacity) {
				final LinkNode nodeToRemove = dummyHead.next;
				remove(nodeToRemove);
				t.remove(nodeToRemove.key);
				size = size - 1;
			}
			final LinkNode node = new LinkNode(key, value);
			t.put(key, node);
			addToTail(node);
			size = size + 1;
		}
	}

	static class LinkNode {
		private LinkNode prev;
		private LinkNode next;
		private final int key;
		private int val;

		LinkNode(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}
}
