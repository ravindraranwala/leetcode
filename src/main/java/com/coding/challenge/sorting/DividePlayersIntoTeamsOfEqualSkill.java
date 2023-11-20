package com.coding.challenge.sorting;

import java.util.Arrays;

class DividePlayersIntoTeamsOfEqualSkill {
	DividePlayersIntoTeamsOfEqualSkill() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] skillOne = { 3, 2, 5, 1, 3, 4 };
		assert dividePlayers(skillOne) == 22;

		final int[] skillTwo = { 3, 4 };
		assert dividePlayers(skillTwo) == 12;

		final int[] skillThree = { 1, 1, 2, 3 };
		assert dividePlayers(skillThree) == -1;
	}

	static long dividePlayers(int[] skill) {
		final int n = skill.length;
		Arrays.sort(skill);
		final int teamSkill = skill[0] + skill[n - 1];
		long chemistry = 0;
		for (int i = 0, j = n - 1; i < j; i++, j--) {
			if (skill[i] + skill[j] == teamSkill)
				chemistry = chemistry + skill[i] * skill[j];
			else
				return -1;
		}
		return chemistry;
	}
}
