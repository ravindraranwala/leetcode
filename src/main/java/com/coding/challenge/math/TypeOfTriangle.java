package com.coding.challenge.math;

class TypeOfTriangle {
	TypeOfTriangle() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 3, 3, 3 };
		assert "equilateral".equals(triangleType(nums1));

		final int[] nums2 = { 3, 4, 5 };
		assert "scalene".equals(triangleType(nums2));
	}

	static String triangleType(int[] nums) {
		// check for triangle inequality.
		if (nums[0] + nums[1] > nums[2] && nums[0] + nums[2] > nums[1] && nums[1] + nums[2] > nums[0]) {
			if (nums[0] == nums[1] && nums[1] == nums[2])
				return "equilateral";
			if (nums[0] == nums[1] || nums[1] == nums[2] || nums[0] == nums[2])
				return "isosceles";
			
			return "scalene";
		}
		return "none";
	}
}
