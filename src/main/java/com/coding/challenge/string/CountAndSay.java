package com.coding.challenge.string;

class CountAndSay {
	CountAndSay() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert "1211".equals(countAndSay(4));
		assert "111221".equals(countAndSay(5));
		assert "1".equals(countAndSay(1));
		assert "11".equals(countAndSay(2));
	}

	static String countAndSay(int n) {
		String s = "1";
		for (int i = 2; i <= n; i++) {
			// Do the Run Length Encoding of s
			final int l = s.length();
			char ch = s.charAt(0);
			int freq = 0;
			final StringBuilder currAns = new StringBuilder();
			for (int j = 0; j < l; j++) {
				if (s.charAt(j) == ch)
					freq = freq + 1;
				else {
					currAns.append(freq).append(ch);
					ch = s.charAt(j);
					freq = 1;
				}
			}
			s = currAns.append(freq).append(ch).toString();
		}
		return s;
	}
}
