package com.coding.challenge.simulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class DistributeElementsIntoTwoArraysI {
	DistributeElementsIntoTwoArraysI() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 2, 1, 3 };
		final int[] ans1 = { 2, 3, 1 };
		assert Arrays.equals(ans1, resultArray(nums1));

		final int[] nums2 = { 5, 4, 3, 8 };
		final int[] ans2 = { 5, 3, 4, 8 };
		assert Arrays.equals(ans2, resultArray(nums2));
	}

	static int[] resultArray(int[] nums) {
		final List<Integer> arr1 = new ArrayList<>();
		arr1.add(nums[0]);
		final List<Integer> arr2 = new ArrayList<>();
		arr2.add(nums[1]);
		final int n = nums.length;
		for (int i = 2; i < n; i++) {
			if (arr1.get(arr1.size() - 1) > arr2.get(arr2.size() - 1))
				arr1.add(nums[i]);
			else
				arr2.add(nums[i]);
		}

		final int[] ans = new int[nums.length];
		for (int i = 0; i < arr1.size(); i++)
			ans[i] = arr1.get(i);

		for (int j = 0; j < arr2.size(); j++)
			ans[arr1.size() + j] = arr2.get(j);

		return ans;
	}
}
