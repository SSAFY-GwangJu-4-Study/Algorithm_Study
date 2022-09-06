import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1063_최지성 {
	static int[] king = new int[2];
	static int[] rock = new int[2];
	// 위쪽부터 시계방향으로
	static int[][] delta = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line);

		String k = st.nextToken();
		king[0] = 7 - (k.charAt(1) - '1'); // 행
		king[1] = k.charAt(0) - 'A'; // 열

		String r = st.nextToken();
		rock[0] = 7 - (r.charAt(1) - '1'); // 행
		rock[1] = r.charAt(0) - 'A'; // 열

		int N = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			exec(br.readLine());
		}
	
		System.out.println((char) (king[1] + 'A') + "" + (char) ((7 - king[0]) + '1'));
		System.out.println((char) (rock[1] + 'A') + "" + (char) ((7 - rock[0]) + '1'));
	}

	public static void exec(String s) {
		switch (s) {
		case "T":
			move(0);
			break;
		case "RT":
			move(1);
			break;
		case "R":
			move(2);
			break;

		case "RB":
			move(3);
			break;

		case "B":
			move(4);
			break;

		case "LB":
			move(5);
			break;
			
		case "L":
			move(6);
			break;
			
		case "LT":
			move(7);
			break;
		}
	}

	public static void move(int d) {
		int knr = king[0] + delta[d][0];
		int knc = king[1] + delta[d][1];

		if (knr >= 0 && knr < 8 && knc >= 0 && knc < 8) {
			if (knr == rock[0] && knc == rock[1]) {
				int rnr = rock[0] + delta[d][0];
				int rnc = rock[1] + delta[d][1];
				if (rnr >= 0 && rnr < 8 && rnc >= 0 && rnc < 8) {
					rock[0] = rnr;
					rock[1] = rnc;

					king[0] = knr;
					king[1] = knc;
				}
			} else {
				king[0] = knr;
				king[1] = knc;
			}
		}
	}
}
