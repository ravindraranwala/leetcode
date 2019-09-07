package com.coding.challenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TwoSum {

	public static void main(String[] args) {
//		final int target = 9;
//		final int[] nums = { 2, 7, 11, 15 };
		 final int target = 6;
//		 final int[] nums = { 3, 2, 4 };
		 final int[] nums = { 3, 3 };
		int[] indices = twoSumOnePass(nums, target);
		System.out.println(Arrays.toString(indices));
	}

	/**
	 * Given an array of integers, return indices of the two numbers such that they
	 * add up to a specific target.
	 * 
	 * You may assume that each input would have exactly one solution, and you may
	 * not use the same element twice.
	 * 
	 * Example:
	 * 
	 * Given nums = [2, 7, 11, 15], target = 9,
	 * 
	 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
	 * 
	 * 
	 * @param nums
	 * @param target
	 * @return indices of the two numbers such that they add up to a specific
	 *         target.
	 */
	public static int[] twoSum(int[] nums, int target) {
		final Map<Integer, Integer> valToIdxMap = IntStream.range(0, nums.length).boxed()
				.collect(Collectors.toMap(i -> nums[i], Function.identity(), (a, b) -> b));
		for (int i = 0, n = nums.length; i < n; i++) {
			int complementIdx = valToIdxMap.getOrDefault(target - nums[i], -1);
			// Check whether the complement exists in the map.
			if (complementIdx != -1 && complementIdx != i)
				return new int[] { i, complementIdx };
		}

		return new int[] { -1, -1 };
	}

	/**
	 * Given an array of integers, return indices of the two numbers such that they
	 * add up to a specific target.
	 * 
	 * You may assume that each input would have exactly one solution, and you may
	 * not use the same element twice.
	 * 
	 * Example:
	 * 
	 * Given nums = [2, 7, 11, 15], target = 9,
	 * 
	 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
	 * 
	 * 
	 * @param nums
	 * @param target
	 * @return indices of the two numbers such that they add up to a specific
	 *         target.
	 */
	public static int[] twoSumOnePass(int[] nums, int target) {
		final Map<Integer, Integer> valToIdxMap = new HashMap<>();
		for (int i = 0, n = nums.length; i < n; i++) {
			final int complement = target - nums[i];
			int complementIdx = valToIdxMap.getOrDefault(complement, -1);
			if (complementIdx != -1)
				return new int[] { complementIdx, i };

			valToIdxMap.put(nums[i], i);
		}

		return new int[] { -1, -1 };
	}
}
