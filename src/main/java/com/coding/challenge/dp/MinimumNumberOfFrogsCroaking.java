package com.coding.challenge.dp;

class MinimumNumberOfFrogsCroaking {
	MinimumNumberOfFrogsCroaking() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert minNumberOfFrogs("croakcroak") == 1;
		assert minNumberOfFrogs("crcoakroak") == 2;
		assert minNumberOfFrogs("croakcrook") == -1;
		assert minNumberOfFrogs(
				"ccccccccccrrccccccrcccccccccccrcccccccccrcccccccccccrcccccrcccrrcccccccccccccrocrrcccccccccrccrocccccrccccrrcccccccrrrcrrcrccrcoccroccrccccccccorocrocccrrrrcrccrcrcrcrccrcroccccrccccroorcacrkcccrrroacccrrrraocccrrcrrccorooccrocacckcrcrrrrrrkrrccrcoacrcorcrooccacorcrccccoocroacroraoaarcoorrcrcccccocrrcoccarrorccccrcraoocrrrcoaoroccooccororrrccrcrocrrcorooocorarccoccocrrrocaccrooaaarrcrarooaarrarrororrcrcckracaccorarorocacrrarorrraoacrcokcarcoccoorcrrkaocorcrcrcrooorrcrroorkkaaarkraroraraarooccrkcrcraocooaoocraoorrrccoaraocoorrcokrararrkaakaooroorcororcaorckrrooooakcarokokcoarcccroaakkrrororacrkraooacrkaraoacaraorrorrakaokrokraccaockrookrokoororoooorroaoaokccraoraraokakrookkroakkaookkooraaocakrkokoraoarrakakkakaroaaocakkarkoocokokkrcorkkoorrkraoorkokkarkakokkkracocoaaaaakaraaooraokarrakkorokkoakokakakkcracarcaoaaoaoorcaakkraooaoakkrrroaoaoaarkkarkarkrooaookkroaaarkooakarakkooaokkoorkroaaaokoarkorraoraorcokokaakkaakrkaaokaaaroarkokokkokkkoakaaookkcakkrakooaooroaaaaooaooorkakrkkakkkkaokkooaakorkaroaorkkokaakaaaaaocrrkakrooaaroroakrakrkrakaoaaakokkaaoakrkkoakocaookkakooorkakoaaaaakkokakkorakaaaaoaarkokorkakokakckckookkraooaakokrrakkrkookkaaoakaaaokkaokkaaoakarkakaakkakorkaakkakkkakaaoaakkkaoaokkkakkkoaroookakaokaakkkkkkakoaooakcokkkrrokkkkaoakckakokkocaokaakakaaakakaakakkkkrakoaokkaakkkkkokkkkkkkkrkakkokkroaakkakaoakkoakkkkkkakakakkkaakkkkakkkrkoak") == 229;
	}

	static int minNumberOfFrogs(String croakOfFrogs) {
		final int n = croakOfFrogs.length();
		final int[] f = new int[5];
		int minFrogs = 0;
		for (int i = 0, c = 0; i < n; i++) {
			final char ch = croakOfFrogs.charAt(i);
			if (f[0] >= f[1] && f[1] >= f[2] && f[2] >= f[3] && f[3] >= f[4]) {
				if (ch == 'c') {
					c = c + 1;
					f[0] = f[0] + 1;
				} else if (ch == 'r')
					f[1] = f[1] + 1;
				else if (ch == 'o')
					f[2] = f[2] + 1;
				else if (ch == 'a')
					f[3] = f[3] + 1;
				else {
					f[4] = f[4] + 1;
					c = c - 1;
				}
				minFrogs = Math.max(minFrogs, c);
			} else
				return -1; // distorted input.
		}
		return f[0] == f[1] && f[1] == f[2] && f[2] == f[3] && f[3] == f[4] ? minFrogs : -1;

	}
}
