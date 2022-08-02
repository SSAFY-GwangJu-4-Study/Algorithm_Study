import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_10870_최지성 {
	public static int[] fibo = new int[21];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		init();
		bw.write("" + fibo[N]);

		bw.flush();
		br.close();
		bw.close();
	}

	public static void init() {
		fibo[0] = 0;
		fibo[1] = 1;

		for (int i = 2; i < 21; i++) {
			fibo[i] = fibo[i - 1] + fibo[i - 2];
		}
	}

	/*
	 * public static int fibo(int N) { if (N == 2 || N == 1) return 1;
	 * 
	 * return fibo(N - 1) + fibo(N - 2); }
	 */
}
