import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1946_송해찬 {

	static int T, N;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for(int tc=0; tc<T; tc++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			arr = new int[N][2];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr, (a0, a1) -> a0[0] - a1[0]);
//			System.out.println(Arrays.deepToString(arr));
			int cnt = 1; // 서류 1등 넣고 시작
			int min = arr[0][1]; // 면접 성적 최소 기준 등수
			
			for(int i=1; i<N; i++) {
				if(arr[i][1] < min) { // 최소등수는 넘은 경우
					// 햅격
					cnt++;
					// 서류 뒤쪽 점수 사람들 넘어야 할 최소등수 갱신
					min = arr[i][1];
				}
			}
			System.out.println(Arrays.deepToString(arr));
			System.out.println(cnt);
		}
	}
}
