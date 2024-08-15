package com.coding.challenge.greedy;

class LemonadeChange {
	LemonadeChange() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] bills1 = { 5, 5, 5, 10, 20 };
		assert lemonadeChange(bills1);

		final int[] bills2 = { 5, 5, 10, 10, 20 };
		assert !lemonadeChange(bills2);
	}

	static boolean lemonadeChange(int[] bills) {
		int five = 0;
		int ten = 0;
		for (int b : bills) {
			if (b == 5)
				five = five + 1;
			else if (b == 10) {
				ten = ten + 1;
				five = five - 1;
			} else {
				if (ten > 0) {
					ten = ten - 1;
					five = five - 1;
				} else
					five = five - 3;
			}

			if (five < 0)
				return false;
		}
		return true;
	}
}
