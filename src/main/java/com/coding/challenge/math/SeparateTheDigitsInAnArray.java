package com.coding.challenge.math;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class SeparateTheDigitsInAnArray {
	SeparateTheDigitsInAnArray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 13, 25, 83, 77 };
		final int[] ans1 = { 1, 3, 2, 5, 8, 3, 7, 7 };
		assert Arrays.equals(ans1, separateDigits(nums1));

		final int[] nums2 = { 7, 1, 3, 9 };
		final int[] ans2 = { 7, 1, 3, 9 };
		assert Arrays.equals(ans2, separateDigits(nums2));
	}

	static int[] separateDigits(int[] nums) {
		final int n = nums.length;
		final Deque<Integer> s = new ArrayDeque<>();
		for (int i = n - 1; i >= 0; i--) {
			int curr = nums[i];
			while (curr > 0) {
				s.push(curr % 10);
				curr = curr / 10;
			}
		}

		final int l = s.size();
		final int[] a = new int[l];
		for (int j = 0; j < l; j++)
			a[j] = s.pop();

		return a;
	}
}
