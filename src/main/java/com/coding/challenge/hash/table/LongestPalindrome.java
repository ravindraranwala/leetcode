package com.coding.challenge.hash.table;

import java.util.HashMap;
import java.util.Map;

class LongestPalindrome {
	LongestPalindrome() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert longestPalindrome("abccccdd") == 7;

		assert longestPalindrome("a") == 1;

		final String s1 = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
		assert longestPalindrome(s1) == 983;

		assert longestPalindrome("bb") == 2;
	}

	static int longestPalindrome(String s) {
		final Map<Character, Integer> f = new HashMap<>();
		for (char ch : s.toCharArray())
			f.merge(ch, 1, Integer::sum);

		int l = 0;
		int oddCnt = 0;
		for (char key : f.keySet()) {
			final int freq = f.get(key);
			l = l + freq;
			if (freq % 2 == 1)
				oddCnt = oddCnt + 1;
		}
		return oddCnt == 0 ? l : l - oddCnt + 1;
	}
}
