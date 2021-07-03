package com.coding.challenge.heaps;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Map;

import com.coding.challenge.ListNode;

public class K_WayMerge {
	private K_WayMerge() {
		throw new AssertionError("Non instantiable !");
	}

	public static void main(String[] args) {
		// TODO: add sample data and test the implementation.
	}

	public static <T> ListNode<T> kWayMerge(Comparator<? super T> cmp, ListNode<T>... sortedLists) {
		final Queue<Map.Entry<T, ListNode<T>>> queue = PriorityQueue.of(Map.Entry.comparingByKey(cmp));
		for (ListNode<T> a : sortedLists)
			// Adding the first element of each list to the heap.
			queue.insert(new AbstractMap.SimpleEntry<>(a.val, a.next));

		final ListNode<T> dummyHead = new ListNode<>(null);
		ListNode<T> current = dummyHead;
		while (!queue.isEmpty()) {
			final Map.Entry<T, ListNode<T>> entry = queue.extract();
			final T key = entry.getKey();
			current.next = new ListNode<T>(key);
			current = current.next;
			final ListNode<T> nextNode = entry.getValue();
			if (nextNode != null)
				queue.insert(new AbstractMap.SimpleEntry<>(nextNode.val, nextNode.next));

		}
		return dummyHead.next;
	}

	public static <T extends Comparable<? super T>> ListNode<T> kWayMerge(ListNode<T>... sortedLists) {
		return kWayMerge(Comparator.naturalOrder(), sortedLists);
	}
}
