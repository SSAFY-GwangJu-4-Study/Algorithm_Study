import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14620 {
//	S2 꽃길
	static int N;
	static int[][] map;
	static boolean[][] isSelected;
	static int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int cnt;
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		isSelected = new boolean[N][N];
		min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		comb(0, 1, 1);
		System.out.println(min);
	}

	private static void comb(int c, int x, int y) {
		if (c == 3) {
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(isSelected[i][j] == true ? 1 : 0);
//					System.out.print(" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			flower();
			return;
		}
		for (int i = x; i < N - 1; i++) {
			for (int j = i > x ? 1 : y; j < N - 1; j++) {
				if (!isSelected[i][j]) {
					isSelected[i][j] = true;
					if (j + 1 == N - 1) {
						comb(c + 1, i + 1, 1);
					} else {
						comb(c + 1, i, j + 1);
					}
					isSelected[i][j] = false;
				}
			}
		}

	}

	private static void flower() {
		boolean[][] plant = new boolean[N][N];
		cnt = 0;
		for (int i = 1; i < N - 1; i++) {
			for (int j = 1; j < N - 1; j++) {
				if (isSelected[i][j]) {
					plant[i][j] = true;
//					꽃 심고 상하좌우 꽃잎 펼치기
					for (int d = 0; d < 4; d++) {
						int nx = i + delta[d][0];
						int ny = j + delta[d][1];
//						꽃잎이 겹치는 경우
						if (plant[nx][ny] == true) {
							return;
						} else {
							plant[nx][ny] = true;
						}

					}
				}
			}
		}
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(plant[i][j] == true ? 1 : 0);
//			}
//			System.out.println();
//		}
//		System.out.println();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (plant[i][j]) {
					cnt += map[i][j];
				}
			}
		}
//		System.out.println(cnt);
		min = Math.min(min, cnt);
	}

}
