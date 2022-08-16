import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1780_최지성 {
	static int N;
	static int[][] map;
	static int minus;
	static int zero;
	static int plus;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		String input = null;
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			input = br.readLine();
			st = new StringTokenizer(input, " ");

			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0, N);

		System.out.println(minus);
		System.out.println(zero);
		System.out.println(plus);
	}

	public static void dfs(int y, int x, int size) {
		int result = checkBox(y, x, size);
//		System.out.println(y + " " + x + " " + size + " " + result);

		if (size == 1) {
			switch (result) {
			case -1:
				minus++;
				break;
			case 0:
				zero++;
				break;
			case 1:
				plus++;
				break;
			}

			return;
		}

		if (result != -2) {
			switch (result) {
			case -1:
				minus++;
				break;
			case 0:
				zero++;
				break;
			case 1:
				plus++;
				break;
			}
			return;
		} else {
			for (int i = y; i < y + size; i += size / 3) {
				for (int j = x; j < x + size; j += size / 3) {
					dfs(i, j, size / 3);
				}
			}
		}
	}

	public static int checkBox(int y, int x, int size) {
		int n = map[y][x];

		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				if (map[i][j] != n)
					return -2;
			}
		}

		return n;
	}
}
