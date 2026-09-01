package com.coding.challenge.linked.list;

import java.util.Arrays;

import com.coding.challenge.ListNode;

class FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints {
	FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final ListNode<Integer> head1 = new ListNode<>(3, new ListNode<>(1));
		final int[] ans1 = { -1, -1 };
		assert Arrays.equals(ans1, nodesBetweenCriticalPoints(head1));

		final ListNode<Integer> head2 = new ListNode<>(5, new ListNode<>(3,
				new ListNode<>(1, new ListNode<>(2, new ListNode<>(5, new ListNode<>(1, new ListNode<>(2)))))));
		final int[] ans2 = { 1, 3 };
		assert Arrays.equals(ans2, nodesBetweenCriticalPoints(head2));

		final ListNode<Integer> head3 = new ListNode<>(1, new ListNode<>(3, new ListNode<>(2, new ListNode<>(2,
				new ListNode<>(3, new ListNode<>(2, new ListNode<>(2, new ListNode<>(2, new ListNode<>(7)))))))));
		final int[] ans3 = { 3, 3 };
		assert Arrays.equals(ans3, nodesBetweenCriticalPoints(head3));
	}

	static int[] nodesBetweenCriticalPoints(ListNode<Integer> head) {
		int prevNodeVal = head.val;
		int minDistance = Integer.MAX_VALUE;
		int maxDistance = 0;
		ListNode<Integer> currNode = head;
		int currIdx = 0;
		int lastCriticalPoint = -1;

		while (currNode.next != null) {
			final int nextVal = currNode.next.val;
			if ((currNode.val > prevNodeVal && currNode.val > nextVal)
					|| (currNode.val < prevNodeVal && currNode.val < nextVal)) {
				if (lastCriticalPoint != -1) {
					final int currDist = currIdx - lastCriticalPoint;
					minDistance = Math.min(minDistance, currDist);
					maxDistance = maxDistance + currDist;
				}
				lastCriticalPoint = currIdx;
			}
			prevNodeVal = currNode.val;
			currIdx = currIdx + 1;
			currNode = currNode.next;
		}

		if (minDistance == Integer.MAX_VALUE && maxDistance == 0)
			return new int[] { -1, -1 };

		return new int[] { minDistance, maxDistance };
	}
}
