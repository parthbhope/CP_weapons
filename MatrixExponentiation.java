package templates;

import java.io.*;
import java.util.Arrays;

public class MatrixExponentiation {
	static int K;

	static long[][] matrixmul(long[][] a, long[][] b) {
		long[][] c = new long[K][K];
		for (int i = 0; i < K; i++) {
			for (int j = 0; j < K; j++) {
				for (int k = 0; k < K; k++) {
					c[i][j] += (a[i][k] * b[k][j]);
				}
			}
		}
		return c;
	}

	static long[][] pow(long[][] t, long p) {
		if (p == 1) {
			return t;
		} else if (p % 2 == 1) {
			return matrixmul(t, pow(t, p - 1));
		}
		long[][] mat = pow(t, p / 2);
		return matrixmul(mat, mat);

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = 2;
		long[][] t = new long[K][K]; // transformation matrix
		t[0][0] = 0;
		t[0][1] = 1;
		t[1][0] = 1;
		t[1][1] = 1;
		long[][] v = new long[2][1]; // vector;
		v[0][0] = 1;
		v[1][0] = 1;
		long N = Long.parseLong(br.readLine());
		if (N == 1 || N == 2)
			System.out.println("1");
		else {
			t = pow(t, N - 1);
			for (int i = 0; i < K; i++)
				System.out.println(Arrays.toString(t[i]));// transformation matrix

			long fib = 0;
			for (int i = 0; i < K; i++) {
				fib += (t[0][i] * v[i][0]);
			}
			System.out.println(fib % 10);

		}
	}

}
