package com.coding.challenge.string;

class NumberOfSeniorCitizens {
	private static final int ZERO = '0';

	NumberOfSeniorCitizens() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String[] details1 = { "7868190130M7522", "5303914400F9211", "9273338290F4010" };
		assert countSeniors(details1) == 2;

		final String[] details2 = { "1313579440F2036", "2921522980M5644" };
		assert countSeniors(details2) == 0;
	}

	static int countSeniors(String[] details) {
		int c = 0;
		for (String d : details) {
			final int age = (d.charAt(11) - ZERO) * 10 + (d.charAt(12) - ZERO);
			if (age > 60)
				c = c + 1;
		}
		return c;
	}
}
