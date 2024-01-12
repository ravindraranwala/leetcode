package com.coding.challenge.binary.search;

class PeakIndexInMountainArray {
	PeakIndexInMountainArray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] arr1 = { 0, 1, 0 };
		assert peakIndexInMountainArray(arr1) == 1;

		final int[] arr2 = { 0, 2, 1, 0 };
		assert peakIndexInMountainArray(arr2) == 1;

		final int[] arr3 = { 0, 10, 5, 2 };
		assert peakIndexInMountainArray(arr3) == 1;

		final int[] arr4 = { 3, 5, 3, 2, 0 };
		assert peakIndexInMountainArray(arr4) == 1;
	}

	static int peakIndexInMountainArray(int[] arr) {
		int l = 0;
		int r = arr.length - 1;

		while (r > l) {
			final int mid = (l + r) / 2;
			if (arr[mid] < arr[mid + 1])
				l = mid + 1;
			else
				r = mid;
		}
		return l;
	}
}
