package com.coding.challenge.heaps;

import java.util.Comparator;

import com.coding.challenge.ListNode;

public class K_WayMerge {
	private K_WayMerge() {
		throw new AssertionError("Non instantiable !");
	}

	public static void main(String[] args) {

	}

	public static <T> ListNode<T> kWayMerge(Comparator<? super T> cmp, ListNode<T>... sortedLists) {
		final Comparator<ListNode<T>> listNodeCmp = (o1, o2) -> cmp.compare(o1.val, o2.val);
		final Queue<ListNode<T>> queue = PriorityQueue.of(listNodeCmp);
		for (ListNode<T> a : sortedLists)
			// Adding the first element of each list to the heap.
			queue.insert(a);

		final ListNode<T> dummyHead = new ListNode<>(null);
		ListNode<T> current = dummyHead;
		while (!queue.isEmpty()) {
			final ListNode<T> node = queue.extract();
			current.next = new ListNode<T>(node.val);
			current = current.next;
			final ListNode<T> nextNode = node.next;
			if (nextNode != null)
				queue.insert(nextNode);
		}
		return dummyHead.next;
	}

	public static <T extends Comparable<? super T>> ListNode<T> kWayMerge(ListNode<T>... sortedLists) {
		return kWayMerge(Comparator.naturalOrder(), sortedLists);
	}
}