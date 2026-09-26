package com.coding.challenge.hash.table;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class EvaluateTheBracketPairsOfString {
	private static final char OPEN_BRACKET = '(';
	private static final char CLOSE_BRACKET = ')';
	private static final char WILDCARD = '?';

	EvaluateTheBracketPairsOfString() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final List<List<String>> knowledge1 = List.of(List.of("name", "bob"), List.of("age", "two"));
		assert "bobistwoyearsold".equals(evaluate("(name)is(age)yearsold", knowledge1));

		final List<List<String>> knowledge2 = List.of(List.of("a", "b"));
		assert "hi?".equals(evaluate("hi(name)", knowledge2));

		final List<List<String>> knowledge3 = List.of(List.of("a", "yes"));
		assert "yesyesyesaaa".equals(evaluate("(a)(a)(a)aaa", knowledge3));
	}

	static String evaluate(String s, List<List<String>> knowledge) {
		final int n = s.length();
		final Map<String, String> knowledgeBase = new HashMap<>();
		for (List<String> k : knowledge)
			knowledgeBase.put(k.get(0), k.get(1));

		final StringBuilder ans = new StringBuilder();
		int currOpeningBracketIdx = -1;
		for (int i = 0; i < n; i++) {
			final char ch = s.charAt(i);
			if (ch == OPEN_BRACKET)
				currOpeningBracketIdx = i;
			else if (ch == CLOSE_BRACKET) {
				final String key = s.substring(currOpeningBracketIdx + 1, i);
				if (knowledgeBase.containsKey(key))
					ans.append(knowledgeBase.get(key));
				else
					ans.append(WILDCARD);

				currOpeningBracketIdx = -1;
			} else if (currOpeningBracketIdx == -1)
				ans.append(s.charAt(i));
		}
		return ans.toString();
	}
}
