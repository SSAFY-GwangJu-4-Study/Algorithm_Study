import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1018_최지성 {
	public static int N;
	public static int M;
	public static char[][] board;
	public static int min;

	public static char[][] bBoard = { { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
			{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
			{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
			{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
			{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' } };

	public static char[][] wBoard = { { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
			{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
			{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
			{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
			{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line, " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];

		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
		}

		min = 64;

		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				min = Math.min(min, checkBoard(i, j));
			}
		}
		
		System.out.println(min);
	}

	public static int checkBoard(int y, int x) {
		// 맨 위가 W라면
		int wDiff = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board[y + i][x + j] != wBoard[i][j])
					wDiff++;
			}
		}

		// 맨 위가 B라면
		int bDiff = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board[y + i][x + j] != bBoard[i][j])
					bDiff++;
			}
		}

		return Math.min(wDiff, bDiff);
	}
}
