package templates;

import java.util.*;

public class StringHashing {
	static long p = 31;
	static String t,s;
	static long m = 1000000009;
	static long[] mis,pfxhash;
	static void precompinv()
	{
		for(int i=0;i<mis.length;i++)
			mis[i] = modinverse((long)Math.pow(p,i),m-2);
		System.out.println(Arrays.toString(mis));
	}
	
	static long modinverse(long x,long y) //y = m-2
	{
		// using fermat's theorem a inv = a^m-2 %m
		if(y==0)
			return 1;
		long p = modinverse(x, y/2)%m;
		if(y%2==0)
			return (p*p+m)%m;
		else
			return (x*p +m)%m;
	}
	static long stringhash(String s) {
		long hashval = 0;
		long ppow = 1;
		for (int i = 0; i < s.length(); i++) {
			hashval = (hashval + ppow * (s.charAt(i) - 'a'+1)) % m;
			ppow = (ppow * p) % m;
		}
		return hashval;
	}
	static void calcprefixhash()
	{
		pfxhash[0] = 0;
		for(int i=0;i<pfxhash.length;i++)
		{
			pfxhash[i+1] = pfxhash[i] + (t[i]-'a'+1) *
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		sc.nextLine();
//		while (n-- > 0) {
//			String str = sc.nextLine();
//			System.out.println(stringhash(str));
//		}
//		sc.close();
		mis = new long[15];
		precompinv();
	}

}
