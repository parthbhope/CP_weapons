package templates;
import java.io.*;

//import jdk.internal.jline.internal.InputStreamReader;
public class SubarrOR {
static int n,k,count =0;;
static int[][] dp;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		int t= Integer.parseInt(br.readLine());
		while(t-->0)
		{
			int[] nk = new int[2];
			int i=0;
			for(String s: br.readLine().split(" ") )
			{
				nk[i++] = Integer.parseInt(s);
			}
			 n = nk[0];
			 k = nk[1];
			 dp = new int[n+1][n+1];
			 i=0;
			 for(String s : br.readLine().split(" "))
			 {
				 dp[1][i] = Integer.parseInt(s);
				 if(dp[1][i]>=k)
					 count++;
				 i++;
			 }
			 solve();
		}
	}
	private static void solve() {
		// TODO Auto-generated method stub
		for(int i=1;i<n+1;i++)
		{
		//	dp[][]
		}
		
	}

}
