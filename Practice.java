package templates;

import java.util.*;
import templates.FastScanner;
/* class FastScanner {
  
    private InputStream mIs;
  private byte[] buf = new byte[1024];
  private int curChar;
  private int numChars;

  public FastScanner() {
    this(System.in);
  }

  public FastScanner(InputStream is) {
    mIs = is;
  }

  public int read() {
    if (numChars == -1)
      throw new InputMismatchException();
    if (curChar >= numChars) {
      curChar = 0;
      try {
        numChars = mIs.read(buf);
      } catch (IOException e) {
        throw new InputMismatchException();
      }
      if (numChars <= 0)
        return -1;
    }
    return buf[curChar++];
  }

  public String nextLine() {
    int c = read();
    while (isSpaceChar(c))
      c = read();
    StringBuilder res = new StringBuilder();
    do {
      res.appendCodePoint(c);
      c = read();
    } while (!isEndOfLine(c));
    return res.toString();
  }

  public String nextString() {
    int c = read();
    while (isSpaceChar(c))
      c = read();
    StringBuilder res = new StringBuilder();
    do {
      res.appendCodePoint(c);
      c = read();
    } while (!isSpaceChar(c));
    return res.toString();
  }

  public long nextLong() {
    int c = read();
    while (isSpaceChar(c))
      c = read();
    int sgn = 1;
    if (c == '-') {
      sgn = -1;
      c = read();
    }
    long res = 0;
    do {
      if (c < '0' || c > '9')
        throw new InputMismatchException();
      res *= 10;
      res += c - '0';
      c = read();
    } while (!isSpaceChar(c));
    return res * sgn;
  }

  public int nextInt() {
    int c = read();
    while (isSpaceChar(c))
      c = read();
    int sgn = 1;
    if (c == '-') {
      sgn = -1;
      c = read();
    }
    int res = 0;
    do {
      if (c < '0' || c > '9')
        throw new InputMismatchException();
      res *= 10;
      res += c - '0';
      c = read();
    } while (!isSpaceChar(c));
    return res * sgn;
  }

  public boolean isSpaceChar(int c) {
    return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
  }

  public boolean isEndOfLine(int c) {
    return c == '\n' || c == '\r' || c == -1;
  
  }  
}
*/
public class Practice {

	public static void main(String[] args) {
	//	Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int m  =sc.nextInt();
		sc.nextLine();
		String[] arr = new String[n];
		for(int i =0;i<n;i++)
		{
			arr[i] = sc.nextLine();
		}
		int[] p = new int[m];
		for(int i =0;i<m;i++)
		{
			p[i] =sc.nextInt();
		}
		int[][] count = new int[n][26];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				count[i][arr[i].charAt(j)-'A']++;
			}
		}
		int[] mx = new int[m];
		long total=0;
		for(int i=0;i<n;i++)
		{
			mx[i]=Arrays.stream(count[i]).max().getAsInt();
			total+=(mx[i]*p[i]);
		}
		System.out.println(Arrays.toString(mx));
		System.out.println(total);
	}
}
