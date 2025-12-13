package com.coding.challenge.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class CouponCodeValidator {
	CouponCodeValidator() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String[] code1 = { "SAVE20", "", "PHARMA5", "SAVE@20" };
		final String[] businessLine1 = { "restaurant", "grocery", "pharmacy", "restaurant" };
		final boolean[] isActive1 = { true, true, true, true };
		assert Arrays.asList("PHARMA5", "SAVE20").equals(validateCoupons(code1, businessLine1, isActive1));

		final String[] code2 = { "GROCERY15", "ELECTRONICS_50", "DISCOUNT10" };
		final String[] businessLine2 = { "grocery", "electronics", "invalid" };
		final boolean[] isActive2 = { false, true, true };
		assert Arrays.asList("ELECTRONICS_50").equals(validateCoupons(code2, businessLine2, isActive2));
	}

	static List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
		final int n = code.length;
		final List<CouponCode> validCouponCodes = new ArrayList<>();
		for (int i = 0; i < n; i++)
			if (validateCode(code[i]) && isActive[i] && validateBusinessLine(businessLine[i]))
				validCouponCodes.add(new CouponCode(code[i], lineNum(businessLine[i])));

		final Comparator<CouponCode> cmp = new Comparator<CouponCode>() {
			@Override
			public int compare(CouponCode o1, CouponCode o2) {
				final int v = Integer.compare(o1.lineNum, o2.lineNum);
				if (v != 0)
					return v;

				return o1.code.compareTo(o2.code);
			}
		};

		validCouponCodes.sort(cmp);
		final List<String> validCodes = new ArrayList<>();
		for (CouponCode couponCode : validCouponCodes)
			validCodes.add(couponCode.code);

		return validCodes;
	}

	private static boolean validateCode(String code) {
		for (char ch : code.toCharArray())
			if ((ch < 'a' || ch > 'z') && (ch < 'A' || ch > 'Z') && (ch < '0' || ch > '9') && ch != '_')
				return false;
		return code.length() > 0;
	}

	private static boolean validateBusinessLine(String businessLine) {
		return "electronics".equals(businessLine) || "grocery".equals(businessLine) || "pharmacy".equals(businessLine)
				|| "restaurant".equals(businessLine);
	}

	private static int lineNum(String businessline) {
		if ("electronics".equals(businessline))
			return 1;
		if ("grocery".equals(businessline))
			return 2;
		if ("pharmacy".equals(businessline))
			return 3;
		if ("restaurant".equals(businessline))
			return 4;

		throw new AssertionError();
	}

	private static class CouponCode {
		private final String code;
		private final int lineNum;

		CouponCode(String code, int lineNum) {
			this.code = code;
			this.lineNum = lineNum;
		}
	}
}
