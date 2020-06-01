package com.tarun.main;

import com.tarun.other.Tree;

public class BinaryTree {
	
	public static void main(String[] args) {
		Tree intTree = new Tree();
		intTree.insert(1);
		intTree.insert(2);
		intTree.insert(3);
		intTree.insert(4);
		intTree.insert(5);
		intTree.insert(6);

		intTree.levelOrder();
		
		
		
	}
	
}