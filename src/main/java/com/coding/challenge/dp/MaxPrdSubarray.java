package com.coding.challenge.dp;

class MaxPrdSubarray {

	MaxPrdSubarray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 2, 3, -2, 4 };
		int p = maxProduct(nums1);
		System.out.println(p);

		final int[] nums2 = { -2, 0, -1 };
		p = maxProduct(nums2);
		System.out.println(p);

		final int[] nums3 = { 2, 3, -2, 10 };
		p = maxProduct(nums3);
		System.out.println(p);

		final int[] nums4 = { -2, 0, -1, -4 };
		p = maxProduct(nums4);
		System.out.println(p);

		final int[] nums5 = { 2, 3, -2, 10, -1 };
		p = maxProduct(nums5);
		System.out.println(p);

		final int[] nums6 = { 7 };
		p = maxProduct(nums6);
		System.out.println(p);

		final int[] nums7 = { 2, -5, -2, -4, 3 };
		p = maxProduct(nums7);
		System.out.println(p);

		final int[] nums8 = { -2 };
		p = maxProduct(nums8);
		System.out.println(p);
	}

	static int maxProduct(int[] nums) {
		final int n = nums.length;
		int mp = Integer.MIN_VALUE;
		int curr = Integer.MIN_VALUE;
		int np = Integer.MIN_VALUE;
		int ns = Integer.MIN_VALUE;
		boolean nf = false;
		for (int i = 0; i < n; i++) {
			if (nums[i] == 0) {
				mp = Math.max(Math.max(mp, 0), Math.max(np, ns));
				np = Integer.MIN_VALUE;
				ns = Integer.MIN_VALUE;
				curr = Integer.MIN_VALUE;
				nf = false;
			} else {
				if (nf) {
					if (ns == Integer.MIN_VALUE)
						ns = nums[i];
					else
						ns = ns * nums[i];
				}
				if (nums[i] < 0) {
					np = curr;
					nf = true;
				}
				if (curr == Integer.MIN_VALUE)
					curr = nums[i];
				else
					curr = curr * nums[i];
				mp = Math.max(mp, Math.max(curr, nums[i]));
			}
		}
		mp = Math.max(mp, Math.max(np, ns));
		return mp;
	}
}
