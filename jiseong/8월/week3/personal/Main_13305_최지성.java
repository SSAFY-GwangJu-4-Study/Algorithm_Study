import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13305_최지성 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line = null;
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		long[] road = new long[N - 1];
		long[] price = new long[N];

		line = br.readLine();
		st = new StringTokenizer(line, " ");
		for (int i = 0; i < N - 1; i++) {
			road[i] = Long.parseLong(st.nextToken());
		}

		line = br.readLine();
		st = new StringTokenizer(line, " ");
		for (int i = 0; i < N; i++) {
			price[i] = Long.parseLong(st.nextToken());
		}

		int ridx = 0; // road index
		int pidx = 0; // price index
		int cnt = 0;
		long roadSum = 0;
		long total = 0; // 최종 비용

		while (ridx < N - 1 && pidx < N) {
			// 다음 거 보기
			cnt++;
			if (price[pidx] <= price[pidx + cnt]) {
				roadSum += road[ridx++];
			} else {
				roadSum += road[ridx++];
				total += roadSum * price[pidx];
				pidx += cnt;
				cnt = 0;
				roadSum = 0;
			}
		}
		total += roadSum*price[pidx];

		System.out.println(total);
	}
}
