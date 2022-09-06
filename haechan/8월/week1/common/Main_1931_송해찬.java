import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1931_송해찬 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
//		System.out.println(Arrays.deepToString(arr));
		// 최대한 많이 넣기 위해 종료시간 기준으로 정렬
		Arrays.sort(arr, (a0, a1) -> {
			// 종료시간이 같을 때 시작시간도 정렬
			if(a0[1] == a1[1]) {
				return a0[0] - a1[0];
			}
			return a0[1] - a1[1];
		});
		
		// 맨 처음 종료되는 회의 넣고 시작
		int end = arr[0][1];
		int cnt = 1;
		
		// 그 다음 회의부터 시작시간과 종료시간 비교하면서 count 증가
		for(int i=1; i<N; i++) {
			if(arr[i][0] >= end) {
				cnt++;
				// 회의 개수 추가하면 end 갱신
				end = arr[i][1];
			}
		}
//		System.out.println(Arrays.deepToString(arr));
		System.out.println(cnt);
	}

}
