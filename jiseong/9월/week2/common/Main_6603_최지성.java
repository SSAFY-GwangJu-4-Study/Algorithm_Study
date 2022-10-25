import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6603_최지성 {
	static int N;
	static int[] arr;
	static int[] combi;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = null;

		while (true) {
			st = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(st.nextToken());
			if (N == 0)
				return;

			arr = new int[N];
			combi = new int[6];

			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			comb(0, 0);
			System.out.println();
		}
	}

	public static void comb(int cnt, int start) {
		if (cnt == 6) {
			for (int i : combi) {
				System.out.print(i + " ");
			}
			System.out.println();

			return;
		}

		for (int i = start; i < N; i++) {
			combi[cnt] = arr[i];
			comb(cnt + 1, i + 1);
		}
	}
}
