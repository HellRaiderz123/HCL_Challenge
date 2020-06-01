package com.tarun.other;

public class Tree {
	
	private Node root;
	
	public void insert(int value) {
		if (root == null) {
			root = new Node(value);
		} else {
			root.insert(value);
		}
	}
	
	public void traverseInOrder() {
		if (root != null) {
			root.traverseInOrder();
		}
	}
	
	public void traverseLeaves() {
		if (root != null) {
			root.traverseLeaves();
		}
	}
	
	public boolean printLevel(Node root, int level)
	{
		if (root == null) {
			return false;
		}

		if (level == 1)
		{
			System.out.print(root.getData() + " ");
			return true;
		}

		boolean left = printLevel(root.getLeftChild(), level - 1);
		boolean right = printLevel(root.getRightChild(), level - 1);

		return left || right;
	}

	public void levelOrder()
	{
		int level = 1;

		while (printLevel(root, level)) {
			level++;
		}
	}

}
