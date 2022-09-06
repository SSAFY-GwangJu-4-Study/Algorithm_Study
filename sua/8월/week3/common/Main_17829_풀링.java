import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17829_풀링 {
	public static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(pooling(N, 0, 0));
	}

	public static int pooling(int n, int r, int c) {
		if (n == 1) {
			return arr[r][c];
		}
		int e1 = pooling(n / 2, r, c);
		int e2 = pooling(n / 2, r + n / 2, c);
		int e3 = pooling(n / 2, r, c + n / 2);
		int e4 = pooling(n / 2, r + n / 2, c + n / 2);
		
		int[] temp = {e1, e2, e3, e4};
		Arrays.sort(temp);
		
		return temp[2];

	}
}
