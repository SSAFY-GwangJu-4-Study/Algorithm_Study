import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_Shuffle_O_Matic_최지성 {
	static int N;
	static int[] card;
//	static boolean[] canMove; // 움직일 수 있는지 체크
//	static boolean[] cantSwap; // 바꿀 수 있는지 체크
//	static int movePoint;
	static int minCount;	// 결과

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			card = new int[N];
//			movePoint = N / 2 - 1;
			minCount = Integer.MAX_VALUE;

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				card[i] = Integer.parseInt(st.nextToken());
			}

			dfs(0, card);

			System.out.println("#" + tc + " " + (minCount == Integer.MAX_VALUE ? -1 : minCount));
		}
	}

	public static void dfs(int cnt, int[] card) {
		if (cnt >= minCount) {
			return;
		}

		if (cnt > 5) {
			return;
		}

		if (isSorted(card)) {
			minCount = Math.min(cnt, minCount);
			return;
		}

		int[] temp = new int[card.length];

		for (int i = 0; i < card.length; i++) {
			temp[i] = card[i];
		}

//		boolean res = false;

		boolean[] canMove = new boolean[N];
		boolean[] cantSwap = new boolean[N];
		int movePoint = N / 2 - 1;

		for (int i = 0; i < N; i++) {
			if (movePoint >= 0) {
				canMove[movePoint--] = true;
			}

			shuffle(temp, canMove, cantSwap);
//			System.out.println(cnt + " " + "temp = " + Arrays.toString(temp));

			dfs(cnt + 1, temp);
		}
	}

	public static void shuffle(int[] card, boolean[] canMove, boolean[] cantSwap) {
		for (int i = 0; i < N; i++) {
			if (canMove[i]) {
				swap(card, i, canMove, cantSwap);
				i++;
			}
		}
	}

	public static boolean swap(int[] card, int pos, boolean[] canMove, boolean[] cantSwap) {
		if (pos == N - 1) {
			canMove[pos] = false;
			cantSwap[pos] = true;
			return false;
		}

		if (cantSwap[pos + 1]) {
			canMove[pos] = false;
			cantSwap[pos] = true;
			return false;
		}

		int tempI = card[pos];
		card[pos] = card[pos + 1];
		card[pos + 1] = tempI;

		boolean tempB = canMove[pos];
		canMove[pos] = canMove[pos + 1];
		canMove[pos + 1] = tempB;

		return true;
	}

	public static boolean isSorted(int[] card) {
		if (card[0] > card[1]) {
			for (int i = 1; i < card.length - 1; i++) {
				if (card[i] < card[i + 1])
					return false;
			}
		} else {
			for (int i = 1; i < card.length - 1; i++) {
				if (card[i] > card[i + 1])
					return false;
			}
		}

		return true;
	}
}
