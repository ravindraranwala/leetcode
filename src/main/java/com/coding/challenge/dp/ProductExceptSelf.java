package com.coding.challenge.dp;

import java.util.Arrays;

class ProductExceptSelf {

	ProductExceptSelf() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 2, 3, 4 };
		int[] prd = productExceptSelf(nums1);
		assert Arrays.toString(prd).equals("[24, 12, 8, 6]");
		System.out.println(Arrays.toString(prd));

		final int[] nums2 = { -1, 1, 0, -3, 3 };
		prd = productExceptSelf(nums2);
		assert Arrays.toString(prd).equals("[0, 0, 9, 0, 0]");
		System.out.println(Arrays.toString(prd));
		
		final int[] nums3 = {-1, 5};
		prd = productExceptSelf(nums3);
		assert Arrays.toString(prd).equals("[5, -1]");
		System.out.println(Arrays.toString(prd));
	}

	static int[] productExceptSelf(int[] nums) {
		final int n = nums.length;
		final int[] p = new int[n];
		for (int i = 0; i < n; i++)
			p[i] = 1;
		int fp = 1;
		int bp = 1;
		for (int i = 0; i < n; i++) {
			p[i] = p[i] * fp;
			p[n - i - 1] = p[n - i - 1] * bp;
			fp = fp * nums[i];
			bp = bp * nums[n - i - 1];
		}
		return p;
	}
}