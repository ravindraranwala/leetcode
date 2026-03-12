package com.coding.challenge.bit.manipulation;

class ComplementOfBase10Integer {
	ComplementOfBase10Integer() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert bitwiseComplement(5) == 2;
		assert bitwiseComplement(7) == 0;
		assert bitwiseComplement(10) == 5;
		assert bitwiseComplement(1) == 0;
		assert bitwiseComplement(0) == 1;
	}

	static int bitwiseComplement(int n) {
		int d = 2;
		for (int num = n; num > 1; num = num / 2)
			d = d + d;

		return d - 1 - n;
	}
}
