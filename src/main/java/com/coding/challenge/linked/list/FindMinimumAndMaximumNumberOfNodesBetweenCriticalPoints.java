package com.coding.challenge.linked.list;

import java.util.Arrays;

import com.coding.challenge.ListNode;

class FindMinimumAndMaximumNumberOfNodesBetweenCriticalPoints {
	FindMinimumAndMaximumNumberOfNodesBetweenCriticalPoints() {
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
		int firstCriticalPoint = -1;
		int lastCriticalPoint = -1;
		int minDist = Integer.MAX_VALUE;
		int beforePrev = head.val;
		int prev = head.next.val;
		int count = 2;

		for (ListNode<Integer> curr = head.next.next; curr != null; curr = curr.next) {
			count = count + 1;
			if ((prev < beforePrev && prev < curr.val) || (prev > beforePrev && prev > curr.val)) {
				if (firstCriticalPoint == -1)
					firstCriticalPoint = count;
				else
					minDist = Math.min(minDist, count - lastCriticalPoint);
				lastCriticalPoint = count;
			}
			beforePrev = prev;
			prev = curr.val;
		}

		final int[] a = { -1, -1 };
		if (minDist != Integer.MAX_VALUE)
			a[0] = minDist;
		if (lastCriticalPoint - firstCriticalPoint > 0)
			a[1] = lastCriticalPoint - firstCriticalPoint;

		return a;
	}
}
