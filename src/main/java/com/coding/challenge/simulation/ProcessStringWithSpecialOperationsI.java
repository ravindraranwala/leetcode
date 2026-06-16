package com.coding.challenge.simulation;

class ProcessStringWithSpecialOperationsI {
	private static final char STAR = '*';
	private static final char POUND = '#';
	private static final char PERCENTAGE = '%';

	ProcessStringWithSpecialOperationsI() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert "ba".equals(processStr("a#b%*"));
		assert "".equals(processStr("z*#"));
	}

	static String processStr(String s) {
		final StringBuilder ans = new StringBuilder();
		for (char ch : s.toCharArray()) {
			if (ch == STAR) {
				if (ans.length() > 0)
					ans.deleteCharAt(ans.length() - 1);
			}
			else if (ch == POUND)
				ans.append(ans.toString());
			else if (ch == PERCENTAGE)
				ans.reverse();
			else
				ans.append(ch);
		}
		return ans.toString();
	}
}
