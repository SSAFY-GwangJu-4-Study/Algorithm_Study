import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main_12865_송해찬 {

	static int ans;
	static Integer[][] dp;
	static int[] W;
	static int[] V;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		W = new int[N];
		V = new int[N];
		// N 개의 물건 * K 무게 표를 만들어서 가치 저장
		dp = new Integer[N][K+1];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
//		System.out.println(Arrays.toString(W));
//		System.out.println(Arrays.toString(V));
		ans = knapsack(N-1, K);
		sb.append(ans);
		System.out.println(sb);
	}
	
	// 배낭 문제 - knapsack 알고리즘 이용
	// 짐을 쪼갤수 없는 경우 - 0/1 knapsack 문제 - DP 풀이 필요
	// DP Top-Down 방식 (하향식)
	static int knapsack(int i, int k) {
		// i가 0 미만일때, 즉 범위 밖이 되면
		if(i<0) {
			return 0;
		}
		// 탐색하지 않은 위치라면?
		if(dp[i][k] == null) {
			// 현재 물건(i)을 추가로 못담는 경우 (이전 i값 탐색)
			if(W[i] > k) {
				dp[i][k] = knapsack(i-1, k);
			}
			// 현재 물건(i)을 담을 수 있는 경우
			else if(W[i] <= k) {
				// 가치 누적 탐색
				// 이전 i값과 이전 i값에 대한 k-W[i] 값 + 현재 가치(V[i]) 중 큰 값을 저장
				dp[i][k] = Math.max(knapsack(i-1, k), knapsack(i-1, k-W[i]) + V[i]);
//				System.out.println(W[i] + " " + k + " " + dp[i][k]);
			}
		}
		return dp[i][k];
	}
}
