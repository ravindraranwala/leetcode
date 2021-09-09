package com.coding.challenge.bst;

class BSTValidator {
	private static double v = Double.NEGATIVE_INFINITY;
	private static boolean s = true;

	BSTValidator() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final TreeNode two = new TreeNode(2);
		two.left = new TreeNode(1);
		two.right = new TreeNode(3);
		boolean v = isValidBST(two);
		System.out.println(v);

		final TreeNode five = new TreeNode(5);
		five.left = new TreeNode(1);
		final TreeNode four = new TreeNode(4);
		four.left = new TreeNode(3);
		four.right = new TreeNode(6);
		five.right = four;
		v = isValidBST(five);
		System.out.println(v);

		// Usecase 3.
		final TreeNode five2 = new TreeNode(5);
		five2.left = new TreeNode(4);
		final TreeNode six = new TreeNode(6);
		six.left = new TreeNode(3);
		six.right = new TreeNode(7);
		five2.right = six;
		v = isValidBST(five2);
		System.out.println(v);

		isValidBST(new TreeNode(0));
		System.out.println(s);

	}

	static boolean isValidBST(TreeNode root) {
		v = Double.NEGATIVE_INFINITY;
		s = true;
		isValidBSTRec(root);
		return s;
	}

	static void isValidBSTRec(TreeNode root) {
		if (root != null) {
			isValidBSTRec(root.left);
			if (v >= root.val) {
				s = false;
				return;
			}
			v = root.val;
			isValidBSTRec(root.right);
		}
	}
}
