import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15961_회전초밥 {
	static int N, d, k, c;
	static int[] sushi;
	static int[] eaten;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());// 총 접시수
		d = Integer.parseInt(st.nextToken());// 초밥 가짓수
		k = Integer.parseInt(st.nextToken());// 연속해 먹는 수
		c = Integer.parseInt(st.nextToken())-1;// 쿠폰 번호
		
		sushi = new int[N+k-1];
		eaten = new int[d];//0~d-1
		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine())-1;
		}
		
		for (int i = N; i < N+k-1; i++) {
			sushi[i] = sushi[i-N];
		}
		
		eaten[c] = 1;
		
		int result = eat();
		
		System.out.println(result);
		//연속해 k개를 먹고 쿠폰도 써야함
	}
	
	//다음으로 갈 때 겹치는만큼의 개수를 기억해놨다가 거기서 +?
	public static int eat() {
		int max = 0;
		int now = 0;
		for (int i = 0; i < k; i++) {
			eaten[sushi[i]]++;
		}
		
		now = max = cal(); // 맨 처음 가짓수
		
		for (int i = k; i < N+k-1; i++) {//맨 처음꺼 빼고 새거 더하고
			eaten[sushi[i-k]]--;
			if(eaten[sushi[i-k]] == 0) now--; // 빼서 없어지면 개수 빼주기
			
			eaten[sushi[i]]++;
			if(eaten[sushi[i]] == 1) {
				now++;
				if(max < now) max = now;
			} // 처음보는거면 개수 더하기
		}		
		
		return max;
	}
	
	public static int cal() {
		int cnt = 0;
		for (int i = 0; i < d; i++) {
			if(eaten[i] != 0) cnt++;
		}
		return cnt;
	}

}
