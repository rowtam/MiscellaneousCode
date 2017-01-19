package test;

public class Algorithms {
	
	public int[] a = {1, 2, 4, 5, 5, 5, 5, 5, 5, 5};
	public int[] b = {9, 6, 5, 43, 8, 1, 2, 4, 5, 5, 5, 5, 5, 5, 5};
	
	public Algorithms()
	{
	}
	
	int gcd(int a, int b) {
		if(b!=0)
			return gcd(b, a%b);
		else
			return Math.abs(a);
	}
	
	int majority(int begin, int size) {
		int count = 0;
		if(size == 1)
			return a[begin];
		int end_element = begin+size-1;
		System.out.println("Begin: "+ begin+" End: "+ end_element);	
		int pivot = (int) (begin+Math.floor(size/2)-1);
		
		int ml = majority(begin, (int)(size/2));
		int mr = majority(pivot+1, (int)(size/2));
		
		count = 0;		
		for(int i = begin; i < begin+size; i++) {
			if(a[i] == ml)
				count++;
		}
		if (count > Math.round(size/2))
				return ml;
		
		count = 0;
		
		for(int i = begin; i < begin+size; i++) {
			if(a[i] == mr)
				count++;
		}
		if (count > Math.round(size/2))
				return mr;
		
		return -1;
	}
	
	

}
