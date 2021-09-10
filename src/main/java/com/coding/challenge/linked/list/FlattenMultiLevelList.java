package com.coding.challenge.linked.list;

import java.util.StringJoiner;

class FlattenMultiLevelList {

	FlattenMultiLevelList() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final Node one = new Node(1);
		final Node two = new Node(2);
		final Node three = new Node(3);
		one.next = two;
		two.prev = one;
		two.next = three;
		three.prev = two;
		final Node four = new Node(4);
		three.next = four;
		four.prev = three;
		final Node five = new Node(5);
		four.next = five;
		five.prev = four;
		final Node six = new Node(6);
		five.next = six;
		six.prev = five;

		final Node seven = new Node(7);
		final Node eight = new Node(8);
		seven.next = eight;
		eight.prev = seven;
		final Node nine = new Node(9);
		eight.next = nine;
		nine.prev = eight;
		final Node ten = new Node(10);
		nine.next = ten;
		ten.prev = nine;
		three.child = seven;

		final Node eleven = new Node(11);
		final Node twelve = new Node(12);
		eleven.next = twelve;
		twelve.prev = eleven;
		eight.child = eleven;

		Node head = flatten(one);
		System.out.println(head);

		final Node one2 = new Node(1);
		final Node two2 = new Node(2);
		final Node three2 = new Node(3);
		one2.child = two2;
		two2.child = three2;
		head = flatten(one2);
		System.out.println(head);
	}

	static Node flatten(Node head) {
		flattenRec(head);
		return head;
	}

	static Node flattenRec(Node head) {
		Node prev = null;
		for (; head != null; head = head.next) {
			if (head.child != null) {
				final Node t = flattenRec(head.child);
				t.next = head.next;
				if (head.next != null)
					head.next.prev = t;
				head.next = head.child;
				head.child.prev = head;
				head.child = null;
				head = t;
			}
			prev = head;
		}
		return prev;
	}

	static class Node {
		public int val;
		public Node prev;
		public Node next;
		public Node child;

		public Node(int val) {
			this.val = val;
		}

		@Override
		public String toString() {
			final StringJoiner str = new StringJoiner(", ", "[", "]");
			Node head = this;
			while (head != null) {
				str.add(head.val + "");
				head = head.next;
			}
			return str.toString();
		}
	};
}
