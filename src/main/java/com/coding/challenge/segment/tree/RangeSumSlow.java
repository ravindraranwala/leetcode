package com.coding.challenge.segment.tree;

import java.util.Arrays;

public class RangeSumSlow {
	final int[] arr;

	public RangeSumSlow(int n) {
		arr = new int[n];
	}

	public static void main(String[] args) {
		final int[][] shifts = { { 4, 8, 0 }, { 4, 4, 0 }, { 2, 4, 0 }, { 2, 4, 0 }, { 6, 7, 1 }, { 2, 2, 1 },
				{ 0, 2, 1 }, { 8, 8, 0 }, { 1, 3, 1 } };
		final int n = shifts.length;
		final RangeSumSlow st = new RangeSumSlow(n);
		final SegmentTreeSum st2 = new SegmentTreeSum(n);
		for (int[] shift : shifts)
			if (shift[2] == 1) {
				st.increment(shift[0], shift[1], 1);
				st2.increment(shift[0], shift[1], 1);
			} else {
				st.increment(shift[0], shift[1], -1);
				st2.increment(shift[0], shift[1], -1);
			}

		final int[] a = new int[n];
		final int[] a2 = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = st.sum(i, i);
			a2[i] = st2.sum(i, i);
		}

		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(a2));
		if (Arrays.equals(a, a2))
			System.out.println("Arrays are identical !");
		else
			System.out.println("Arrays are different !");
	}

	public void increment(int i, int j, int val) {
		for (int k = i; k <= j; k++)
			arr[k] = arr[k] + val;
	}

	public int sum(int i, int j) {
		int res = 0;
		for (int k = i; k <= j; k++)
			res = res + arr[i];
		return res;
	}
}
