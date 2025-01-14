package com.coding.challenge;

import java.util.Comparator;

public class BinarySearch {

	BinarySearch() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums = { -1, 0, 3, 5, 9, 12 };
		int target = 9;
		int idx = search(nums, target);
		System.out.println(idx);
		int i = successor(nums, 1);
		System.out.println(nums[i]);

		final int[] a = { 1, 2, 3, 4, 7, 8, 10, 11, 13, 14, 15 };
		target = 5;
		idx = predecessor(a, target);
		System.out.println(String.format("%d is the predecessor of %d", a[idx], target));
	}

	/**
	 * Given an array of integers nums which is sorted in ascending order, and an
	 * integer target, this function searches target in nums. If target exists, then
	 * return its index. Otherwise, return -1.
	 * 
	 * @param nums   an array of integers
	 * @param target integer target
	 * @return index of the target if it exists in the array. Otherwise, return -1
	 */
	public static int search(int[] nums, int target) {
		return search(nums, target, 0, nums.length - 1);
	}

	public static int search(int[] nums, int target, int i, int j) {
		int l = i;
		int r = j;
		while (l <= r) {
			final int m = (l + r) / 2;
			if (nums[m] < target)
				l = m + 1;
			else if (nums[m] > target)
				r = m - 1;
			else
				return m;
		}
		return -1;
	}

	public static int successor(int[] nums, int target) {
		return successor(nums, target, 0, nums.length - 1);
	}

	public static int successor(int[] nums, int target, int i, int j) {
		int l = i;
		int r = j + 1;
		while (l < r) {
			final int mid = (l + r) / 2;
			if (nums[mid] > target)
				r = mid;
			else
				l = mid + 1;
		}
		return r;
	}

	public static int predecessor(int[] a, int target) {
		int l = 0;
		int r = a.length;
		while (l < r) {
			final int mid = (l + r) / 2;
			if (a[mid] < target)
				l = mid + 1;
			else
				r = mid;
		}
		return l - 1;
	}
	
	public static int predecessor(int[] a, int target, int i, int j) {
		int l = i;
		int r = j + 1;
		while (l < r) {
			final int mid = (l + r) / 2;
			if (a[mid] < target)
				l = mid + 1;
			else
				r = mid;
		}
		return l - 1;
	}

	/**
	 * Finds the position of the element in the input array that appears before the
	 * target.
	 * 
	 * @param a      input array, this should be a sorted array.
	 * @param target search key.
	 * @param cmp    Comparator for comparing array elements against the target.
	 *               When constructing a comparator, make sure you pass the target
	 *               as the second argument.
	 * @return position of the predecessor of the target in the input array.
	 */
	public static int predecessor(int[][] a, int[] target, Comparator<int[]> cmp) {
		int l = 0;
		int r = a.length;
		while (l < r) {
			final int mid = (l + r) / 2;
			if (cmp.compare(a[mid], target) < 0)
				l = mid + 1;
			else
				r = mid;
		}
		return l - 1;
	}

	/**
	 * Finds the position of the element in the input array that appears after the
	 * target.
	 * 
	 * @param a      input array, this should be a sorted array.
	 * @param target search key.
	 * @param i      lower bound in the input array to search
	 * @param j      upper bound of the input array to search
	 * @param cmp    Comparator for comparing array elements against the target.
	 *               When constructing a comparator, make sure you pass the target
	 *               as the second argument.
	 * @return position of the successor of the target in the input array.
	 */
	public static int successor(int[][] a, int[] target, int i, int j, Comparator<int[]> cmp) {
		int l = i;
		int r = j + 1;
		while (l < r) {
			final int mid = (l + r) / 2;
			if (cmp.compare(a[mid], target) > 0)
				r = mid;
			else
				l = mid + 1;
		}
		return r;
	}
}
