import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main_12931_송해찬2 {

	static int N, cnt;
	static int[] B;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		B = new int[N];
		// B 받기
		for(int i=0; i<N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		// 그리디
		// 모두 2로 나누거나 1을 빼자
		// 모두 짝수일때는 2로 나누고 짝수가 아닌게 있으면 1 빼주면서 while 문 돌리기
		
		while(true) {
			boolean breakFlag = true;
			// 0이 아닌거 있으면 break 아직
			for(int i=0; i<N; i++) {
				if(B[i] != 0) {
					breakFlag = false;
				}
			}
			if(breakFlag) break;
			
			
			boolean allEvenFlag = true;
			for(int i=0; i<N; i++) {
				if(B[i] % 2 != 0) {
					allEvenFlag = false;
				}
			}
			
			// 모두 짝수면 다 2로 나누고 cnt 한번 더하기
			if(allEvenFlag) {
				for(int i=0; i<N; i++) {
					B[i] /= 2;
				}
				cnt++;
			}
			// 짝수 아닌거 있으면 1씩 빼고 cnt 매번 더하기
			else {
				for(int i=0; i<N; i++) {
					if(B[i] % 2 != 0) {
						B[i] -= 1;
						cnt++;
					}
				}
			}
		}
		
		sb.append(cnt);
		System.out.println(sb);
	}
}
