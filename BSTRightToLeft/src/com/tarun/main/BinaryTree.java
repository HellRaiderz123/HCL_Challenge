package com.tarun.main;

import com.tarun.other.Tree;

public class BinaryTree {
	
	public static void main(String[] args) {
		Tree intTree = new Tree();
		intTree.insert(8);
		intTree.insert(3);
		intTree.insert(10);
		intTree.insert(1);
		intTree.insert(6);
		intTree.insert(14);
		intTree.insert(7);
		intTree.insert(4);
		intTree.insert(13);
		
		intTree.traverseLeaves();
		
	}
	
}