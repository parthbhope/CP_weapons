
package templates;
import java.util.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class FastScanner {
  
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
class TestClass{
    static long[] arr;
    public static void main(String args[] ) throws Exception {
        FastScanner s = new FastScanner();
        StringBuilder sb= new StringBuilder();
        int n = s.nextInt();
        int qd= s.nextInt();
        arr= new long[n+4];
        while(qd-->0)
        {
            int a= s.nextInt();
            int b= s.nextInt();
            int k= s.nextInt();
            arr[a]+=k;
            arr[b+1]-=k;
        }
        long x=0;
        long max=0;
        for(int i=1;i<=n;i++)
        {
            x+=arr[i];
            arr[i]=x;
            max=Math.max(max ,arr[i]);
        }
    
    System.out.print(max);
}

    
}