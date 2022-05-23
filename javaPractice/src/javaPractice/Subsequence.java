package javaPractice;

import java.util.ArrayList;
import java.util.Iterator;
public class Subsequence {

	public static void main(String[] args) {

		int arr[]= {3,1,2};
		int n=3;
		ArrayList<Integer> ds=new ArrayList<Integer>();
		
		Subsequence obj=new Subsequence();
		
		obj.printSeq(0,ds,arr,n);
	}

	private void printSeq(int i, ArrayList<Integer> ds, int[] arr, int n) {
		
		if(i==n)
		{
			for(Integer it : ds)
			{
				System.out.print(it+" ");
			}
			if(ds.size()==0)
				System.out.println("{}");
		
		System.out.println();
		return;
		}
		
		ds.add(arr[i]);
		printSeq(i+1, ds, arr, n);
		ds.remove(ds.size()-1);
		printSeq(i+1, ds, arr, n);
	}

}
