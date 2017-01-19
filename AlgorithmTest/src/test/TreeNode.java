package test;

public class TreeNode<T extends Comparable<? super T>> {
	
	public TreeNode<T> parent;
	public TreeNode<T> leftChild;
	public TreeNode<T> rightChild;
	public T value;
	
	public TreeNode(TreeNode<T> Node) {
		this.parent = Node.parent;
		this.leftChild = Node.leftChild;
		this.rightChild = Node.rightChild;
		this.value = Node.value;
	}	
	
	public TreeNode(T value) {
		this.parent = null;
		this.leftChild = null;
		this.rightChild = null;
		this.value = value;
	}
	
	public TreeNode() {
		this.parent = null;
		this.leftChild = null;
		this.rightChild = null;
		this.value = null;
	}
	
}
