package templates;

import java.util.*;

public class DiffArrayPrefSum {
	static int[] arr,darr;
	static int n;
	static void prefixSum() {
		//int n = arr.length;
		for (int i = 1; i < n; i++) {
			arr[i] = arr[i - 1] + arr[i];
		}

	}

	static void initDiffArr()
	{
		 darr = new int[n + 1];
		 darr[0] =arr[0];
		 for(int i=1;i<n;i++)
		 {
			darr[i] =arr[i]-arr[i-1]; 
		 }
		 
	}
	static void updateRange(int l, int r,int k)
	{
		darr[l]+=k;
		darr[r+1]-=k;
		// always declare the darr as [n+1] or [n+2]
		//depending on the case the additional element is for the querry that updates th entire array
	}
	
	static void updatedList()
	{
		arr[0] = darr[0];
		for(int i=1;i<n;i++)
		{
		arr[i]= darr[i]+ arr[i-1];
		}
	}
	
	public static void main(String[] args) {
 ;
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		arr = new int[n];
		int q = sc.nextInt();
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		//sc.close();
		initDiffArr();// print explicitly
		while(q-->0)
		{
			int l =sc.nextInt();
			int r = sc.nextInt();
			int k = sc.nextInt();
			updateRange(l, r, k);
		}
		updatedList();
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		//prefixSum();
		//for (int i = 0; i < n; i++) {
			//System.out.print(arr[i]+" ");
		//}
	}

}
