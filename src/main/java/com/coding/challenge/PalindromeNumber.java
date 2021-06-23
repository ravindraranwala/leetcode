package com.coding.challenge;

public class PalindromeNumber {

	private PalindromeNumber() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int num = 1000000001;
		final boolean palindrome = isPalindrome(num);
		System.out.println(palindrome);
	}

	public static boolean isPalindrome(int x) {
		// negative numbers are not palindrome.
		if (x < 0)
			return false;
		// reverse the integer
		int rem = x;
		int reverse = 0;
		int n = x;
		while (n > 0) {
			rem = n % 10;
			n = n / 10;
			reverse += rem;
			if (n != 0)
				reverse = reverse * 10;
		}

		return x == reverse;
	}
}
