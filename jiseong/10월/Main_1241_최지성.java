import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1241_최지성 {
	static int N;
	static int[] num;
	static int[] cntNum;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		num = new int[N];
		cntNum = new int[1000001];

		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine());
			cntNum[num[i]]++;
		}

		for (int i = 0; i < N; i++) {
			System.out.println(factorization(num[i]));
		}
	}

	public static int factorization(int n) {
		int sum = 0;

		for (int i = 1; i * i <= n; i++) {
			if (n % i == 0) {
				sum += cntNum[i];

				if (n / i != i) {
					sum += cntNum[n / i];
				}
			}
		}

		return sum - 1;
	}
}
