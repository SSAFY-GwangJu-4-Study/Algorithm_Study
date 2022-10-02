import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SWEA 1952. [모의 SW 역량테스트] 수영장 - dfs
 * 가장 적은 비용으로 수영장을 이용
 * 최솟값 넣어 놓고, 이것보다 크면 중단
 * @author kjh
 *
 */
public class Solution_1952_김정효 {
	static int[] price, plan, visit;
	static int _min;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			price = new int[4];
			plan = new int[12];
			visit = new int[12];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				price[j] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 12; j++) {
				plan[j] = Integer.parseInt(st.nextToken());
			}

			_min = price[3];	// 최솟값에 1년 이용권 값을 넣어 놓고 비교
			dfs(0, 0);
			sb.append("#").append(i).append(" ").append(_min).append("\n");
		}
		System.out.print(sb);
	}
	
	private static void dfs(int index, int sum) {
		if (index >= 12) {		// index == 12 가 아닌 이유: 11월에 3달권을 하면 index=14 이므로
			_min = Math.min(_min, sum);
			return;
		}
		
		if (sum > _min) return;		// 현재까지 더한 값이 최솟값보다 크다면 리턴
		
		if (plan[index] != 0) {	// 이용일 수가 있을 때
			dfs(index+1, sum+plan[index]*price[0]); // 1일 권
			dfs(index+1, sum+price[1]); // 한 달 권
			dfs(index+3, sum+price[2]); // 3달 권
		} else {			// 이용일 수: 0
			dfs(index+1, sum);
		}
	}

}
