package test;
import java.util.Random;

public class QuickSort {
	
	private int numarray[];
	private int numarray_size;
	
	public QuickSort(int n)
	{
		numarray = new int[n];
		numarray_size = n;
		Random random = new Random();
		for(int i=0;i<n;i++)
			numarray[i] = random.nextInt(255);
	}
	
	private void swap(int a[], int index1, int index2)	
	{
		int temp;
		temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
	}
	
	private int Partition(int[] A, int p, int r) {

		int x = A[p];
		int i = p - 1;
		int j = r + 1;
		while (true) {
			do {
				j--;
			} while (A[j] > x);
			do {
				i++;
			} while (A[i] < x);
			if (i < j)
				swap(A, i, j);
			else
				return j;
		}
	}
	
	public void sort(int numlist[], int start, int end)
	{
		int pivot_index;
		if(end <= start)
			return; 
		else
		{
			pivot_index = Partition(numlist, start, end);
			sort(numlist, start, pivot_index);
			sort(numlist, pivot_index+1, end);
		}
	}
	
	public void sort()
	{
		sort(numarray,0,this.numarray_size-1);	
	}
	
	public String toString()
	{
		String s = "";
		for(int i = 0; i < this.numarray_size;i++)
		{
			s += numarray[i]+",";
		}
		return "\nList: " + s + "\n";
	}
}

