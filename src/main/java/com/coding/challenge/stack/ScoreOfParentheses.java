package com.coding.challenge.stack;

import java.util.ArrayDeque;
import java.util.Deque;

class ScoreOfParentheses {
	ScoreOfParentheses() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert scoreOfParentheses("()") == 1;
		assert scoreOfParentheses("(())") == 2;
		assert scoreOfParentheses("()()") == 2;
		assert scoreOfParentheses("(()(()))") == 6;
	}

	static int scoreOfParentheses(String s) {
		int score = 0;
		final Deque<Integer> stack = new ArrayDeque<>();
		for (char ch : s.toCharArray()) {
			if (ch == '(')
				stack.push(0);
			else {
				int newScore = stack.pop();
				if (newScore == 0)
					newScore = 1;
				else
					newScore = newScore * 2;

				if (stack.isEmpty())
					score = score + newScore;
				else
					stack.push(stack.pop() + newScore);
			}
		}
		return score;
	}
}
