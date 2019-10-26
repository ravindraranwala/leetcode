package com.coding.challenge;

public class MedianSortedArrays {

	public static void main(String[] args) {
		final int[] nums1 = new int[] { 1, 2 };
		final int[] nums2 = new int[] { 3, 4 };
		final double median = findMedianSortedArrays(nums1, nums2);
		System.out.println(median);
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length, n = nums2.length;
		if (m > n) {
			int[] temp = nums1;
			nums1 = nums2;
			nums2 = temp;
			int tmp = m;
			m = n;
			n = tmp;
		}

		int iMin = 0, iMax = m;
		final int halfLength = (m + n + 1) / 2;
		for (int i = (iMin + iMax) / 2, j = halfLength - i; iMin <= iMax; i = (iMin + iMax) / 2, j = halfLength - i) {
			if (i < m && nums2[j - 1] > nums1[i])
				// i is too smaller, we have to increase i.
				iMin = i + 1;
			else if (i > 0 && nums1[i - 1] > nums2[j])
				// i is too big, we must decrease it
				iMax = i - 1;
			else {
				// i is perfect, so stop searching
				final int leftMax = i == 0 ? nums2[j - 1]
						: j == 0 ? nums1[i - 1] : Math.max(nums1[i - 1], nums2[j - 1]);
				if ((n + m) % 2 == 1)
					return leftMax;
				final int rightMin = i == m ? nums2[j] : j == n ? nums1[i] : Math.min(nums1[i], nums2[j]);
				return (leftMax + rightMin) / 2.0;
			}
		}
		return 0.0;
	}
}
