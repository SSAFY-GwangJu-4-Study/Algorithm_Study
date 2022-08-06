import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//하는중
public class Main_1138_한_줄로_서기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];//자기보다 왼쪽에 "큰 사람이 몇명"있는지 저장하는 배열
		int[] turn = new int[n];//순서대로 된 "키" 저장하는 배열(결과)
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {//나중에 인덱스 +1 처리 해주기
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < n; i++) {
			int cnt = 0;			
			for(int j = 0; j < i; j++) {
				System.out.println(i + ", " + j + " ");
				if(turn[arr[j]] != 0 && turn[arr[j]] <= arr[i+cnt]) {//arr[j]번째 순서의 키가  내 키(i)보다 작다면 (즉 왼쪽에 있는 애들중에 키가 작은애가 있다면)
					cnt++;
					System.out.println(turn[arr[j]] + "가 " + i + "보다 작음");
				}
				
			}
			turn[arr[i] + cnt] = i + 1; // i+1 = 원래 키, cnt 
			System.out.println((arr[i] +cnt) + "번째에  " + turn[arr[i]+cnt ] + "저장");
			
		}
		
		for(int i = 0; i < n; i++) {
			System.out.print((turn[i]) + " ");
			
		}
		//키는 1인 사람이 가장 작으므로 이사람 말이 곧 자기 순서
		// 키가 2인 사람은 
		
		//키가 1인 사람부터 차례대로 
		//키 출력
	}

}
