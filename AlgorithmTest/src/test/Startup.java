package test;

import java.util.Random;

public class Startup {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Algorithms a = new Algorithms();
		
		System.out.println("The GCD of 853 and 199 is " + a.gcd(853,199) + "\n");
		System.out.println("The Majority Element is "+ a.majority(0, a.a.length));
		
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		
		bst.add(9);
		bst.add(1);
		bst.add(8);
		bst.add(20);
		bst.add(100);
		
		Random num = new Random(System.nanoTime());
		for(int i = 0; i < 100; i++)
			bst.add(num.nextInt(100));
	
		bst.print();

		bst.print_breadth_first();
		
	   
		QuickSort q = new QuickSort(30);
		System.out.println(q);
		q.sort();
		System.out.println(q);
	}
}
