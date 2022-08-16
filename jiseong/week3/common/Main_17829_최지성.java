import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17829_최지성 {
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		String line = null;
		StringTokenizer st = null;

		for (int i = 0; i < N; i++) {
			line = br.readLine();
			st = new StringTokenizer(line, " ");

			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = pooling(N, 0, 0);	// 맨 왼쪽 위 꼭짓점 좌표

		System.out.println(answer);
	}

	public static int pooling(int size, int r, int c) {
		if (size == 1) {
			return map[r][c];
		}

		int n1 = pooling(size / 2, r, c);
		int n2 = pooling(size / 2, r, c + size / 2);
		int n3 = pooling(size / 2, r + size / 2, c);
		int n4 = pooling(size / 2, r + size / 2, c + size / 2);

		int[] temp = new int[] { n1, n2, n3, n4 };
		
		Arrays.sort(temp);
		
		return temp[2];// 두 번쨰로 큰 값
	}
}
