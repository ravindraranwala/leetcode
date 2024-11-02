package com.coding.challenge.dp;

class MaximumNumberOfMovesInGrid {
	MaximumNumberOfMovesInGrid() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] g1 = { { 2, 4, 3, 5 }, { 5, 4, 9, 3 }, { 3, 4, 2, 11 }, { 10, 9, 13, 15 } };
		assert maxMoves(g1) == 3;

		final int[][] g2 = { { 3, 2, 4 }, { 2, 1, 9 }, { 1, 1, 7 } };
		assert maxMoves(g2) == 0;

		final int[][] g3 = {
				{ 1000000, 92910, 1021, 1022, 1023, 1024, 1025, 1026, 1027, 1028, 1029, 1030, 1031, 1032, 1033, 1034,
						1035, 1036, 1037, 1038, 1039, 1040, 1041, 1042, 1043, 1044, 1045, 1046, 1047, 1048, 1049, 1050,
						1051, 1052, 1053, 1054, 1055, 1056, 1057, 1058, 1059, 1060, 1061, 1062, 1063, 1064, 1065, 1066,
						1067, 1068 },
				{ 1069, 1070, 1071, 1072, 1073, 1074, 1075, 1076, 1077, 1078, 1079, 1080, 1081, 1082, 1083, 1084, 1085,
						1086, 1087, 1088, 1089, 1090, 1091, 1092, 1093, 1094, 1095, 1096, 1097, 1098, 1099, 1100, 1101,
						1102, 1103, 1104, 1105, 1106, 1107, 1108, 1109, 1110, 1111, 1112, 1113, 1114, 1115, 1116, 1117,
						1118 } };
		assert maxMoves(g3) == 49;
	}

	static int maxMoves(int[][] grid) {
		final int m = grid.length;
		final int n = grid[0].length;
		final int[][] moves = new int[m][n];

		for (int c = n - 2; c >= 0; c--) {
			if (grid[0][c + 1] > grid[0][c])
				moves[0][c] = moves[0][c + 1] + 1;
			if (grid[1][c + 1] > grid[0][c])
				moves[0][c] = Math.max(moves[0][c], moves[1][c + 1] + 1);

			for (int r = 1; r < m - 1; r++) {
				if (grid[r - 1][c + 1] > grid[r][c])
					moves[r][c] = moves[r - 1][c + 1] + 1;
				if (grid[r][c + 1] > grid[r][c])
					moves[r][c] = Math.max(moves[r][c], moves[r][c + 1] + 1);
				if (grid[r + 1][c + 1] > grid[r][c])
					moves[r][c] = Math.max(moves[r][c], moves[r + 1][c + 1] + 1);
			}

			if (grid[m - 2][c + 1] > grid[m - 1][c])
				moves[m - 1][c] = moves[m - 2][c + 1] + 1;
			if (grid[m - 1][c + 1] > grid[m - 1][c])
				moves[m - 1][c] = Math.max(moves[m - 1][c], moves[m - 1][c + 1] + 1);
		}
		// solve original problem.
		int c = 0;
		for (int i = 0; i < m; i++)
			c = Math.max(c, moves[i][0]);

		return c;
	}
}
