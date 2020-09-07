package templates;

import java.util.*;

public class KadanesAlgo {
//	private static long msum(int[] nums) {
//		long m = Long.MIN_VALUE;
//
//		long s = 0;
//		int r = 0,l= 0,sr = 0,sl = 0;
//		
//		for (int num : nums) {
//			s += num;
//			
//			if(s > m) {
//				m = s;
//				sl = l;
//				sr = r;
//			}
//			
//			if (s < 0) {
//				s = 0;
//				l=r+1;
//			}
//			r++;
//		}
//		return m;
//	}

	static int n;
	static long[] arr;

// [-2,1,-3,4,-1,2,1,-5,4]
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new long[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextLong();
		// sc.close();
		// in
		boolean flag = false;
		int r = 0, l = 0, s = 0;
		long runsum = 0;
		long maxsum = Long.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			runsum += arr[i];
			if (runsum > maxsum) {
				maxsum = runsum;
				r = i;
				s = l;
			}
			if (runsum < 0) {
				l = i + 1; // when rs <0 l points to the current sum starting index
				runsum = 0;
				// if runsum becomes 0 then you to get a smaller subarr change the condition to
				// rs<=0
			}
		}
		System.out.println(s + " " + r + " " + maxsum);
	}
}
//10
//10 5 -12 7 -10 20 30 -10 50 60
