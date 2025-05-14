package com.coding.challenge.simulation;

class TotalCharactersInStringAfterTransformationsI {
	private static final char FIRST_LETTER = 'a';
	private static final int MOD = 1000000007;

	TotalCharactersInStringAfterTransformationsI() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert lengthAfterTransformations("abcyy", 2) == 7;
		assert lengthAfterTransformations("azbk", 1) == 5;
	}

	static int lengthAfterTransformations(String s, int t) {
        final int[] f = new int[26];
        for (char ch : s.toCharArray()) 
        	f[ch - FIRST_LETTER] = f[ch - FIRST_LETTER] + 1;
        
        for (int i = 1; i <= t; i++) {
        	final int zFreq = f[25];
        	for (int j = 25; j > 1; j--)
        		f[j] = f[j - 1];
        	
        	f[1] = (f[0] + zFreq) % MOD;
        	f[0] = zFreq;
        }
        int l = 0;
        for (int freq : f) 
        	l = (l + freq) % MOD;
        
        return l;
    }
}
