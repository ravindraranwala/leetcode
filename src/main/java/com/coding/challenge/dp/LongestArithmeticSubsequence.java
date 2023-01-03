package com.coding.challenge.dp;

class LongestArithmeticSubsequence {
	LongestArithmeticSubsequence() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 3, 6, 9, 12 };
		assert longestArithSeqLength(numsOne) == 4;

		final int[] numsTwo = { 9, 4, 7, 2, 10 };
		assert longestArithSeqLength(numsTwo) == 3;

		final int[] numsThree = { 20, 1, 15, 3, 10, 5, 8 };
		assert longestArithSeqLength(numsThree) == 4;

		final int[] numsFour = { 6, 6, 7, 6, 8, 6 };
		assert longestArithSeqLength(numsFour) == 4;

		final int[] numsFive = { 12, 28, 13, 6, 34, 36, 53, 24, 29, 2, 23, 0, 22, 25, 53, 34, 23, 50, 35, 43, 53, 11,
				48, 56, 44, 53, 31, 6, 31, 57, 46, 6, 17, 42, 48, 28, 5, 24, 0, 14, 43, 12, 21, 6, 30, 37, 16, 56, 19,
				45, 51, 10, 22, 38, 39, 23, 8, 29, 60, 18 };
		assert longestArithSeqLength(numsFive) == 4;

		final int[] numsSix = { 225, 368, 110, 327, 305, 265, 499, 471, 140, 276, 411, 12, 158, 158, 378, 1, 500, 333,
				485, 239, 49, 153, 21, 37, 322, 367, 376, 345, 442, 398, 273, 97, 80, 469, 140, 40, 447, 212, 358, 434,
				215, 500, 487, 52, 119, 387, 320, 456, 378, 289, 277, 347, 185, 217, 260, 160, 497, 79, 229, 317, 426,
				413, 213, 216, 150, 259, 279, 479, 60, 163, 473, 196, 285, 345, 362, 280, 332, 265, 371, 137, 129, 403,
				419, 11, 346, 6, 394, 324, 291, 193, 241, 56, 50, 384, 421, 136, 266, 307, 252, 38, 303, 324, 214, 68,
				35, 374, 280, 69, 361, 175, 8, 373, 197, 286, 245, 152, 284, 89, 115, 407, 299, 218, 285, 308, 417, 274,
				246, 274, 171, 207, 415, 159, 471, 337, 497, 459, 451, 231, 213, 146, 489, 146, 283, 279, 494, 78, 120,
				212, 482, 103, 282, 368, 92, 160, 406, 129, 415, 228, 217, 412, 158, 285, 161, 367, 478, 295, 288, 52,
				314, 90, 140, 246, 420, 490, 286, 43, 156, 128, 99, 407, 467, 334, 284, 80, 61, 351, 448, 296, 276, 129,
				429, 140, 33, 106, 206, 491, 402, 231, 220, 445, 414, 448, 124, 187, 12, 379, 421, 473, 258, 400, 51,
				274, 26, 123, 301, 487, 153, 231, 108, 251, 169, 383, 231, 32, 80, 431, 45, 238, 274, 385, 38, 103, 214,
				197, 31, 400, 183, 428, 470, 370, 353, 323, 57, 392, 230, 36, 140, 359, 73, 415, 426, 454, 1, 316, 134,
				468, 123, 453, 27, 214, 85, 302, 249, 405, 88, 139, 382, 23, 348, 405, 56, 448, 128, 127, 54, 109, 182,
				322, 463, 222, 297, 306, 136, 406, 171, 68, 102, 327, 23, 398, 0, 242, 86, 286, 199, 285, 456, 220, 314,
				483, 400, 120, 27, 282, 436, 339, 176, 60, 469, 250, 59, 44, 300, 496, 94, 308, 185, 328, 275, 109, 216,
				136, 193, 247, 207, 317, 450, 330, 399, 430, 430, 238, 246, 189, 488, 272, 112, 192, 195, 495, 248, 116,
				160, 118, 71, 215, 150, 135, 201, 442, 30, 44, 0, 356, 21, 140, 174, 91, 299, 492, 445, 244, 224, 116,
				384, 407, 488, 475, 490, 291, 409, 195, 134, 400, 155, 500, 491, 148, 407, 7, 77, 62, 123, 29, 199, 452,
				242, 230, 177, 468, 328, 296, 282, 147, 205, 67, 88, 76, 66, 434, 72, 91, 192, 105, 437, 158, 500, 211,
				485, 222, 428, 368, 259, 0, 4, 186, 144, 13, 68, 348, 129, 183, 36, 411, 188, 30, 491, 251, 232, 314,
				56, 258, 397, 145, 249, 474, 340, 434, 384, 435, 346, 239, 434, 224, 394, 415, 312, 271, 258, 218, 184,
				85, 234, 289, 267, 185, 417, 475, 442, 497, 429, 16, 230, 180, 210, 468, 66, 334, 323, 81, 318, 228, 55,
				395, 393, 389, 413, 62, 476, 38, 327, 338, 442, 263, 66, 113, 10, 395, 466, 367, 351, 227, 39, 10, 212,
				338, 338, 71, 64, 166, 115, 219, 462, 257, 243, 320, 456, 6, 77, 415, 389, 142, 168, 89, 201, 98, 289,
				249, 391, 497, 438, 99, 420, 138, 146, 151, 333, 126, 166, 60, 152, 392, 150, 379, 239, 151, 431, 193,
				65, 69, 18, 234, 7, 478, 307, 27, 150, 358, 281, 280, 423, 17, 174, 55, 135, 58, 415, 211, 22, 420, 371,
				478, 400, 98, 216, 445, 470, 454, 173, 110, 106, 496, 278, 309, 275, 128, 240, 414, 327, 405, 270, 406,
				411, 302, 153, 107, 206, 184, 322, 332, 379, 179, 328, 292, 244, 459, 49, 303, 382, 287, 65, 243, 265,
				87, 319, 216, 77, 449, 105, 221, 312, 401, 72, 451, 278, 405, 426, 471, 312, 455, 388, 192, 79, 47, 63,
				486, 495, 234, 49, 352, 436, 327, 194, 235, 252, 67, 244, 92, 101, 230, 439, 93, 136, 496, 203, 378,
				400 };
		assert longestArithSeqLength(numsSix) == 8;

	}

	static int longestArithSeqLength(int[] nums) {
		final int n = nums.length;
		final int[][] t = new int[n][1001];
		int maxLength = 2;

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				final int d = nums[i] - nums[j];
				final int encodedKey = d <= 0 ? Math.abs(d) : d + 500;
				final int currentLength = t[j][encodedKey] == 0 ? 2 : t[j][encodedKey] + 1;
				t[i][encodedKey] = Math.max(currentLength, t[i][encodedKey]);
				maxLength = Math.max(maxLength, currentLength);
			}
		}
		return maxLength;
	}
}
