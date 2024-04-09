package com.coding.challenge.simulation;

class NumberOfStudentsUnableToEatLunch {
	NumberOfStudentsUnableToEatLunch() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] students1 = { 1, 1, 0, 0 };
		final int[] sandwiches1 = { 0, 1, 0, 1 };
		assert countStudents(students1, sandwiches1) == 0;

		final int[] students2 = { 1, 1, 1, 0, 0, 1 };
		final int[] sandwiches2 = { 1, 0, 0, 0, 1, 1 };
		assert countStudents(students2, sandwiches2) == 3;
	}

	static int countStudents(int[] students, int[] sandwiches) {
		int zeros = 0;
		int ones = 0;

		for (int choice : students)
			if (choice == 0)
				zeros = zeros + 1;
			else
				ones = ones + 1;

		final int n = sandwiches.length;
		for (int i = 0; i < n; i++) {
			if (sandwiches[i] == 0 && zeros == 0)
				return n - i;
			if (sandwiches[i] == 1 && ones == 0)
				return n - i;

			if (sandwiches[i] == 0 && zeros > 0)
				zeros = zeros - 1;
			else if (sandwiches[i] == 1 && ones > 0)
				ones = ones - 1;
		}
		return 0;
	}
}
