import java.util.Scanner;

public class Main_1074_최지성 {
	static int N;
	static int r;
	static int c;
	static int[][] start; // 4등분의 맨 왼쪽 위의 y,x좌표, 순서는 z
	static int answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		start = new int[4][];

		find(N, 0, 0);

		System.out.println(answer);
	}

	public static void find(int size, int startY, int startX) {
		if (size == 0)
			return;

		boolean row = r >= startY + Math.pow(2, size - 1);
		boolean col = c >= startX + Math.pow(2, size - 1);

		if (!row && !col) {
			// 2사분면
			find(size - 1, startY, startX);
		} else if (!row && col) {
			// 1사분면
			answer += (int)Math.pow(Math.pow(2, size - 1), 2);
			find(size - 1, startY, startX + (int)Math.pow(2, size - 1));
		} else if (row && !col) {
			// 3사분면
			answer += Math.pow(Math.pow(2, size - 1), 2) * 2;
			find(size - 1, startY + (int)Math.pow(2, size - 1), startX);
		} else if (row && col) {
			// 4사분면
			answer += Math.pow(Math.pow(2, size - 1), 2) * 3;
			find(size - 1, startY + (int)Math.pow(2, size - 1), startX + (int)Math.pow(2, size - 1));
		}
	}
}
