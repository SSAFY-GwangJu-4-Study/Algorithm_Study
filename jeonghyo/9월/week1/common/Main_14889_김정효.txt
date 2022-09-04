import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_14889_김정효 {
	static int[][] arr;
	static int n, _min;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		visit = new boolean[n];
		_min = Integer.MAX_VALUE;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}	// -------- 입력 완료 --------
		comb(0, 0);
		System.out.println(_min);
	}

	private static void comb(int start, int cnt) {	
		if(cnt == n/2) {	// 팀 다 골랐을 때,
			int team1 = 0, team2 = 0, result = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (visit[i] && visit[j]) team1 += arr[i][j];			// 팀1의  능력치 더하기
					else if (!visit[i] && !visit[j]) team2 += arr[i][j];	// 팀2의  능력치  더하기
				}
			}
			result = Math.abs(team1-team2);	// 능력치 차이의 절댓값
			_min = Math.min(_min, result);	// 능력치 차이의 최솟값 찾기
			return;
		}
		
		// 팀 고르기
		for (int i = start; i < n; i++) {
			if(visit[i]) return;
			visit[i] = true;
			comb(i+1, cnt+1);
			visit[i] = false;
		}
		
	}


}
