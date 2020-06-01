package com.tarun.other;

public class Node {

	private int data;
	
	private Node leftChild;
	
	private Node rightChild;
	
	public void insert(int value) {
		
		if(value==this.data) {
			return;
		}
		
		if(value < data) {
			if(leftChild == null) {
				leftChild = new Node(value);
			}
			else {
				leftChild.insert(value);
			}
		} else {
			if(rightChild == null) {
				rightChild = new Node(value);
			}
			else {
				rightChild.insert(value);
			}
		}
	}
	
	public void traverseInOrder() {
		if(leftChild!=null) {
			leftChild.traverseInOrder();
		}
		System.out.println("Data" + data + ",");
		if(rightChild!=null) {
			rightChild.traverseInOrder();
		}
	}
	
	public void traverseLeaves() {
		
		if (leftChild == null && rightChild == null)  
	    {  
	        System.out.print( data + " " );  
	        return;  
	    }  
 
	    if (rightChild != null)  
	    	rightChild.traverseLeaves();  
	  
 
	    if (leftChild != null)  
	    	leftChild.traverseLeaves();
		
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}

	public Node(int data) {
		super();
		this.data = data;
	}
	
	
}
