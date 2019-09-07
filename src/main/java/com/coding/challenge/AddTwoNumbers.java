package com.coding.challenge;

public class AddTwoNumbers {
	public static void main(String[] args) {
		ListNode numOneFirstDigit = new ListNode(2);
		final ListNode numOneSecondDigit = new ListNode(4);
		final ListNode numOneThirdDigit = new ListNode(3);
		numOneFirstDigit.next = numOneSecondDigit;
		numOneSecondDigit.next = numOneThirdDigit;

		final ListNode numTwoFirstDigit = new ListNode(5);
		final ListNode numTwoSecondDigit = new ListNode(6);
		final ListNode numTwoThirdDigit = new ListNode(4);
		numTwoFirstDigit.next = numTwoSecondDigit;
		numTwoSecondDigit.next = numTwoThirdDigit;
		//
		// System.out.println(numOneFirstDigit.toString());
		// System.out.println(numTwoFirstDigit.toString());

		// ListNode numOneFirstDigit = new ListNode(5);
		// final ListNode numOneSecondDigit = new ListNode(2);
		// numOneFirstDigit.next = numOneSecondDigit;
		//
		// final ListNode numTwoFirstDigit = new ListNode(2);

		// ListNode numOneFirstDigit = new ListNode(8);
		// final ListNode numOneSecondDigit = new ListNode(7);
		// final ListNode numOneThirdDigit = new ListNode(6);
		// numOneFirstDigit.next = numOneSecondDigit;
		// numOneSecondDigit.next = numOneThirdDigit;
		//
		// final ListNode numTwoFirstDigit = new ListNode(4);
		// final ListNode numTwoSecondDigit = new ListNode(7);
		// final ListNode numTwoThirdDigit = new ListNode(5);
		// numTwoFirstDigit.next = numTwoSecondDigit;
		// numTwoSecondDigit.next = numTwoThirdDigit;

		// ListNode numOneFirstDigit = new ListNode(9);
		// final ListNode numOneSecondDigit = new ListNode(9);
		// numOneFirstDigit.next = numOneSecondDigit;
		//
		// final ListNode numTwoFirstDigit = new ListNode(1);

		ListNode addition = addTwoNumbers(numOneFirstDigit, numTwoFirstDigit);
		System.out.println(addition);
	}

	public static ListNode addTwoNumbersRecursive(ListNode l1, ListNode l2) {
		// base case of the recurrence
		if (l1 == null && l2 == null)
			return null;
		else if (l1 != null && l2 == null)
			return l1;
		else if (l1 == null && l2 != null)
			return l2;

		final int sum = l1.val + l2.val;
		// modular division
		final int remainder = sum % 10;
		final int carryForward = sum / 10;
		// create a new link node.
		ListNode currentNode = new ListNode(remainder);
		ListNode newNode = addTwoNumbersRecursive(l1.next, l2.next);
		if (carryForward > 0) {
			if (newNode != null)
				newNode = addTwoNumbersRecursive(newNode, new ListNode(carryForward));
			else {
				newNode = new ListNode(carryForward);
			}
		}

		currentNode.next = newNode;
		return currentNode;
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carryOver = 0;
		ListNode dummyHead = new ListNode(0);
		ListNode currentNode = dummyHead;
		for (ListNode n1 = l1, n2 = l2; n1 != null || n2 != null;) {
			int sum = 0;
			if (n1 != null) {
				sum = n1.val;
				n1 = n1.next;
			}
			if (n2 != null) {
				sum += n2.val;
				n2 = n2.next;
			}
			sum += carryOver;
			int remainder = sum % 10;
			carryOver = sum / 10;

			currentNode.next = new ListNode(remainder);
			currentNode = currentNode.next;

		}
		if (carryOver == 1)
			currentNode.next = new ListNode(carryOver);
		return dummyHead.next;
	}

	/**
	 * Definition for singly-linked list.
	 */
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			if (next == null)
				return val + "";

			return val + next.toString();
		}

	}
}
