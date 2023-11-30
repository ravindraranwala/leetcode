package com.coding.challenge.sorting;

import java.util.Arrays;

class RankTeamsByVotes {
	private static final char FIRST_LETTER = 'A';

	RankTeamsByVotes() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String[] votesOne = { "ABC", "ACB", "ABC", "ACB", "ACB" };
		assert "ACB".equals(rankTeams(votesOne));

		final String[] votesTwo = { "WXYZ", "XYZW" };
		assert "XWYZ".equals(rankTeams(votesTwo));

		final String[] votesThree = { "ZMNAGUEDSJYLBOPHRQICWFXTVK" };
		assert "ZMNAGUEDSJYLBOPHRQICWFXTVK".equals(rankTeams(votesThree));

		final String[] votesFour = { "FVSHJIEMNGYPTQOURLWCZKAX", "AITFQORCEHPVJMXGKSLNZWUY", "OTERVXFZUMHNIYSCQAWGPKJL",
				"VMSERIJYLZNWCPQTOKFUHAXG", "VNHOZWKQCEFYPSGLAMXJIUTR", "ANPHQIJMXCWOSKTYGULFVERZ",
				"RFYUXJEWCKQOMGATHZVILNSP", "SCPYUMQJTVEXKRNLIOWGHAFZ", "VIKTSJCEYQGLOMPZWAHFXURN",
				"SVJICLXKHQZTFWNPYRGMEUAO", "JRCTHYKIGSXPOZLUQAVNEWFM", "NGMSWJITREHFZVQCUKXYAPOL",
				"WUXJOQKGNSYLHEZAFIPMRCVT", "PKYQIOLXFCRGHZNAMJVUTWES", "FERSGNMJVZXWAYLIKCPUQHTO",
				"HPLRIUQMTSGYJVAXWNOCZEKF", "JUVWPTEGCOFYSKXNRMHQALIZ", "MWPIAZCNSLEYRTHFKQXUOVGJ",
				"EZXLUNFVCMORSIWKTYHJAQPG", "HRQNLTKJFIEGMCSXAZPYOVUW", "LOHXVYGWRIJMCPSQENUAKTZF",
				"XKUTWPRGHOAQFLVYMJSNEIZC", "WTCRQMVKPHOSLGAXZUEFYNJI" };
		assert "VWFHSJARNPEMOXLTUKICZGYQ".equals(rankTeams(votesFour));

		// expected answer: ABC
		final String[] votesFive = { "BCA", "CAB", "CBA", "ABC", "ACB", "BAC" };
		assert "ABC".equals(rankTeams(votesFive));
	}

	static String rankTeams(String[] votes) {
		final char[] teamChars = votes[0].toCharArray();
		Arrays.sort(teamChars);
		final int[] letterToRow = new int[26];
		final int l = teamChars.length;
		for (int i = 0; i < l; i++)
			letterToRow[teamChars[i] - FIRST_LETTER] = i;
		final int[][] t = new int[l][l];
		for (String vote : votes)
			for (int i = 0; i < l; i++)
				t[letterToRow[vote.charAt(i) - FIRST_LETTER]][i] = t[letterToRow[vote.charAt(i) - FIRST_LETTER]][i] + 1;

		final Team[] teams = new Team[l];
		for (int i = 0; i < l; i++)
			teams[i] = new Team(teamChars[i], t[i]);

		for (int j = l - 1; j >= 0; j--) {
			final int k = j;
			// we must use a stable sort here.
			/*
			 * use of the sorting algorithm provided by the programming environment does not
			 * guarantee a stable sort. Thus, explicit merge sort is used. Please note that
			 * merge sort is a stable.
			 */
			Arrays.sort(teams, (a, b) -> Integer.compare(a.ranks[k], b.ranks[k]));
		}

		// handling the special case.
		Arrays.sort(teams, (a, b) -> Arrays.equals(a.ranks, b.ranks) ? Character.compare(b.letter, a.letter) : 0);
		final StringBuilder sb = new StringBuilder();
		for (int k = l - 1; k >= 0; k--)
			sb.append(teams[k].letter);
		return sb.toString();
	}

	static class Team {
		final char letter;
		final int[] ranks;

		Team(char letter, int[] ranks) {
			this.letter = letter;
			this.ranks = ranks;
		}
	}
}
