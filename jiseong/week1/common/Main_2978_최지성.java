import java.util.Scanner;

public class Main_2978_최지성 {
	static int[] num;
	static boolean[] involved;
	static int N;
	static int M;
	static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		num = new int[N];
		involved = new boolean[N];

		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}

		blackjack(0, 0);

		System.out.println(max);
	}

	public static void blackjack(int sum, int numOfCard) {
		if (sum > M)
			return;

		if (numOfCard == 3) {
			max = Math.max(sum, max);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!involved[i]) {
				involved[i] = true;
				blackjack(sum + num[i], numOfCard + 1);
				involved[i] = false;
			}
		}
	}
}
