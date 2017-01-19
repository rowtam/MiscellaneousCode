package test;

import java.util.LinkedList;

public class BinarySearchTree<T extends Comparable<? super T>> {
	
	TreeNode<T> root;
	
	public BinarySearchTree() {
		this.root = new TreeNode<T>();
	}
	
	public void add(T value) {
		insert(this.root, value);
	}
	
	private void insert(TreeNode<T> node, T value) {
		if(node.value == null) {
			node.value = value;
			return;
		}
		if(node.value.compareTo(value) == 0) {
			return;
		}
		if(node.leftChild == null && node.value.compareTo(value) > 0) {
			node.leftChild = new TreeNode<T>(value);
			return;
		}
		if(node.rightChild == null && node.value.compareTo(value) < 0) {
			node.rightChild = new TreeNode<T>(value);
			return;
		}
		if(node.value.compareTo(value) > 0) {
			insert(node.leftChild, value);
		} else if (node.value.compareTo(value) < 0) {
			insert(node.rightChild, value);
		}			
	}
	
	public void print() {
		System.out.println("\nPrinting In-Order Tree\n");
		print_in_order(root);
	}
	
	private void print_in_order(TreeNode<T> node) {
		if(node != null) {
			print_in_order(node.leftChild);
			System.out.println(node.value.toString());
			print_in_order(node.rightChild);
		}		
	}
	
	private boolean isPowerOfTwo(int x) {
	    return (x != 0) && ((x & (x - 1)) == 0);
	}

	public void print_breadth_first() {
		int linecount = 1;
		LinkedList<TreeNode<T>> queue = new LinkedList<TreeNode<T>>();		
		TreeNode<T> traverse = new TreeNode<T>();
		System.out.println("\nPrinting Breadth First Tree\n");
		queue.addLast(this.root);		
		while(!queue.isEmpty()) {
			traverse = queue.removeFirst();
			System.out.print(traverse.value);
			if(this.isPowerOfTwo(linecount+1))
				System.out.println("");
			else
				System.out.print(",");
			linecount++;
			if(traverse.leftChild != null)
				queue.addLast(traverse.leftChild);
			if(traverse.rightChild != null)
				queue.addLast(traverse.rightChild);
		}		
	}
}
