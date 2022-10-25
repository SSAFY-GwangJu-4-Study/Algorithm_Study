import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12931_김선규 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// input end

		int ans = 0;

		while (true) {
			// 나누기 2가 횟수 줄이는데 훨씬 효율적이다. 모든 요소가 짝수인지 확인 후 나누기 2를 해주자
			int cnt = 0;
			for (int i = 0; i < N; i++) {

				if (arr[i] % 2 == 0) 
					cnt++;

			}
			
			if(zeroCheck(arr, N))
				break;

			// 모두 짝수라면?
			if (cnt == N) {
				for (int i = 0; i < N; i++) {
					arr[i] /= 2;
				}
				ans++;
			}
			// 홀수가 있다면 그녀석을 1빼주고 정답 1증가
			else {
				for (int i = 0; i < N; i++) {
					if (arr[i] % 2 != 0) {
						arr[i]--;
						break;
					}
				}
				ans++;
			}
			
			if(zeroCheck(arr, N))
				break;
		}

		System.out.println(ans);

	}
	
	public static boolean zeroCheck(int[] arr, int N) {
		int zeroCnt = 0;
		for(int i=0; i<N; i++) {
			if(arr[i] == 0) zeroCnt++;
		}
		
		if(zeroCnt == N) return true;
		else return false;
	}

}
