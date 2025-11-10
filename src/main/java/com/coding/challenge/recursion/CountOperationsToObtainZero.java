package com.coding.challenge.recursion;

class CountOperationsToObtainZero {

	CountOperationsToObtainZero() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert countOperations(2, 3) == 3;
		assert countOperations(10, 10) == 1;
	}

	static int countOperations(int num1, int num2) {
		if (num1 == 0 || num2 == 0)
			return 0;

		if (num1 >= num2)
			return countOperations(num1 % num2, num2) + num1 / num2;

		return countOperations(num1, num2 % num1) + num2 / num1;
	}
}
