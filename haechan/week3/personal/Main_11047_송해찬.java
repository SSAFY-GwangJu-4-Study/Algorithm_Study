import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11047_송해찬 {

	static int[] coin;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		coin = new int[n];
		for(int i=0; i<n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		int cnt = 0;
		for(int i=n-1; i>=0; i--) {
			if(k>=coin[i]) {
				// 동전 개수 몇개 들어가는지 확인
				cnt += k/coin[i];
				// 동전 값 빼주기
				k %= coin[i];
			}
		}
		System.out.println(cnt);
	}

}
