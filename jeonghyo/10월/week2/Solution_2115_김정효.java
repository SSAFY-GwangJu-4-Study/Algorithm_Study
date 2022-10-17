import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * SWEA 2115 벌꿀 채취
 * 최대 수익 출력
 * @author kjh
 *
 */
public class Solution_2115_김정효 {
	static int N, M, C, _max, map[][], honey[];
	static boolean[][] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			honey = new int[M*2];
			visit = new boolean[N][N];
			_max = Integer.MIN_VALUE;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			comb(0);
			sb.append("#").append(tc).append(" ").append(_max).append("\n");
		}
		System.out.println(sb.toString());
	}
	// 가로로 연속되도록 벌통 M개 선택 => 최대 꿀양: C   (2세트 각각)
	private static void comb(int cnt) {
		if (cnt == 2) {	// 일꾼 2명이 선택을 마치면
			// 일꾼1
			result = 0;
			v1 = new boolean[M];
			pick(v1, 0, 0, 0, 0);
			int a = result;
			// 일꾼2
			result = 0;
			v2 = new boolean[M];
			pick(v2, 0, 0, 0, 0);
			int b = result;
			// 결과
			_max = Math.max(_max, a + b);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N-M+1; j++) {
				if (!visit[i][j]) {
					for (int k = 0; k < M; k++) {
						visit[i][j+k] = true;
						honey[cnt*M+k] = map[i][j+k];
						if (k==M-1) {
							comb(cnt+1);
							for (int h = 0; h < M; h++) {
								visit[i][j+h] = false;
							}
							// 
							if (cnt == 0) visit[i][j] = true;
						}
					}
				}
			}
		}
		
	}
	
	static boolean[] v1;
	static boolean[] v2;
	static int result;
	// 부분집합으로 (0~M // M~M*2) 채취할 꿀 선택
	private static void pick(boolean[] v, int index, int cnt, int sum, int max) {
		if (cnt == M) {
			result = Math.max(sum, result);
			return;
		}
		
		int arr = honey[index];
		if (v.equals(v2)) {
			arr = honey[index+M];
		}
		
		// 일꾼1 -> 일꾼2
		v[index] = true;
		if (max+arr <= C) {
			pick(v, index+1, cnt+1, (int)Math.pow(arr, 2)+sum, max+arr);
		}
		v[index] = false;
		pick(v, index+1, cnt+1, sum, max);
	}
}
