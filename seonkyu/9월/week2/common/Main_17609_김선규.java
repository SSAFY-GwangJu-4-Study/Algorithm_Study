import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_17609_김선규 {

	static int ans = 0;
	static StringBuilder sb = new StringBuilder();
	static boolean check, yusa;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			// 문자열의 길이 최대 10만. 중간까지만 비교하면 되니까 최대 5만. 최대 30개의 문자열이 있으므로 총 경우의 수는 150만번
			String str = br.readLine();

			ans = 0; // 0=회문, 1=유사회문, 2=일반문자열
			check = false;
			yusa = false;

			check(str, 0, str.length() - 1);
		}

		System.out.print(sb);

	}

	public static void check(String str, int start, int end) {

		if (ans == 1 || ans == 2) { // -> 유사회문인지 판단

			for (int i = start, j = end; i <= j; i++, j--) {

				if (str.charAt(i) == str.charAt(j)) // 유사회문이 맞는지 for문
					continue;

				else { // 유사회문도 아니라면
					if (ans == 2)
						return;
					ans = 2;
					check(str, start - 1, end - 1);
					return;
				}
			}

			sb.append(1).append('\n'); // 유사회문임
			yusa = true;
			return;
		}

		// 처음과 끝 비교. 처음은 +1, 끝은 -1 해가며 끝이 처음보다 작아지면 회문
		if (ans == 0) {
			for (int i = start, j = end; i <= j; i++, j--) {

				if (str.charAt(i) == str.charAt(j))
					continue;

				// 회문이 아닌 경우 발생 시, 유사회문 혹은 일반 문자열.
				// 유사회문이라면 start나 end 둘 중 하나가 제외할 문자
				else {

					// 일단 회문은 아님
					ans++;
					check = true;

					check(str, i + 1, j); // start가 제외할 문자라면? 2 4

					if (yusa) { // start가 제외할 문자 -> 유사회문
						return;
					}
					else { // 회문도, 유사회문도 아니므로 일반문자열
						sb.append(ans).append('\n');
						return;
					}
				}

			}
		}

		if (!check) // 회문이라면
			sb.append(ans).append('\n');
	}

}
