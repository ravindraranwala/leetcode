package com.coding.challenge.fenwick.tree;

class CountGoodTripletsInAnArray {
	CountGoodTripletsInAnArray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 2, 0, 1, 3 };
		final int[] nums2 = { 0, 1, 2, 3 };
		assert goodTriplets(nums1, nums2) == 1;
		assert goodTripletsBruteForce(nums1, nums2) == 1;

		final int[] nums3 = { 4, 0, 1, 3, 2 };
		final int[] nums4 = { 4, 1, 0, 2, 3 };
		assert goodTriplets(nums3, nums4) == 4;
		assert goodTripletsBruteForce(nums3, nums4) == 4;

		final int len = 100000;
		final int[] nums5 = new int[len];
		final int[] nums6 = new int[len];
		for (int i = 0; i < len; i++) {
			nums5[i] = i;
			nums6[i] = i;
		}
		assert goodTriplets(nums5, nums6) == 166661666700000l;
		assert goodTripletsBruteForce(nums5, nums6) == 166661666700000l;
	}

	static long goodTriplets(int[] nums1, int[] nums2) {
		final int n = nums1.length;
		final int[] nums1ValToIdx = new int[n];

		for (int i = 0; i < n; i++)
			nums1ValToIdx[nums1[i]] = i;

		final FenwickTree nums1Pos = new FenwickTree(n);
		final FenwickTree pairs = new FenwickTree(n);
		long tripletCnt = 0;
		for (int j = n - 1; j >= 0; j--) {
			// read in nums2 from the end to the beginning.
			final int associatedNums1Idx = nums1ValToIdx[nums2[j]];
			nums1Pos.add(associatedNums1Idx, 1);
			final int validPairsCnt = (int) nums1Pos.rangeQuery(associatedNums1Idx + 1, n - 1);
			pairs.add(associatedNums1Idx, validPairsCnt);
			tripletCnt = tripletCnt + pairs.rangeQuery(associatedNums1Idx + 1, n - 1);
		}
		return tripletCnt;
	}

	static long goodTripletsBruteForce(int[] nums1, int[] nums2) {
		final int n = nums1.length;
		final int[] nums1ValToIdx = new int[n];
		for (int i = 0; i < n; i++)
			nums1ValToIdx[nums1[i]] = i;

		final int[] pairs = new int[n];
		long tripletCnt = 0;
		for (int j = n - 1; j >= 0; j--) {
			// read in nums2 from the end to the beginning.
			final int associatedNums1Idx = nums1ValToIdx[nums2[j]];
			for (int k = j + 1; k < n; k++) {
				if (nums1ValToIdx[nums2[k]] > associatedNums1Idx) {
					pairs[j] = pairs[j] + 1;
					tripletCnt = tripletCnt + pairs[k];
				}
			}
		}
		return tripletCnt;
	}
}
