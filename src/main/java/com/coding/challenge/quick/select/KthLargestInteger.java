package com.coding.challenge.quick.select;

class KthLargestInteger {
	KthLargestInteger() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String[] numsOne = { "3", "6", "7", "10" };
		assert kthLargestNumber(numsOne, 4).equals("3");

		final String[] numsTwo = { "2", "21", "12", "1" };
		assert kthLargestNumber(numsTwo, 3).equals("2");

		final String[] numsThree = { "0", "0" };
		assert kthLargestNumber(numsThree, 2).equals("0");
	}

	static String kthLargestNumber(String[] nums, int k) {
		final int n = nums.length;
		return GenericQuickSelect.randomizedSelect(nums, 0, n - 1, n - k + 1,
				(s1, s2) -> s1.length() == s2.length() ? s1.compareTo(s2) : Integer.compare(s1.length(), s2.length()));
	}
}
