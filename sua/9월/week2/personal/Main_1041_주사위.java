import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1041_주사위 {
	static long N, one, two, three;
	static int[] dice, index = {0, 1, 2, 3, 4, 5};
	static int[] selected;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long result;
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		dice = new int[6];
		
		one = Integer.MAX_VALUE;
		two = Integer.MAX_VALUE;
		three = Integer.MAX_VALUE;
		
		int max = 0;
		for (int i = 0; i < 6; i++) {
			dice[i] = Integer.parseInt(st.nextToken());
			one = Math.min(one, dice[i]);
			max = Math.max(max, dice[i]);
		}
		
		//1일 때 따로 처리
		if(N == 1) {
			int sum = 0;
			for (int i = 0; i < 6; i++) {
				sum+= dice[i];
				
			}
			System.out.println(sum-max);
			return;
		}
		
		selected = new int[2];
		twoComb(0, 0);		
		
		selected = new int[3];
		threeComb(0, 0);
		
		//2면 노출 : 밑 4면 + 모서리제외기둥 (n-2)*8 -> 8n - 12
		//3면 노출 : 상면4개
		//1면 노출 : 5*(n-2)^2 + 4*(n-2)
		result = two*(8*N-12) + three*4 + one*(5*(N-2)*(N-2) + 4*(N-2));
		
		
		System.out.println(result);
	}
	
	static void twoComb(int cnt, int start) {
		if(cnt == 2) {
			if(isMaz(selected[0], selected[1])) return;
			long sum = dice[selected[0]] + dice[selected[1]];
			two = Math.min(two, sum);
			return;
		}
		for (int i = start; i < 6; i++) {
			selected[cnt] = index[i];
			twoComb(cnt+1, i+1);
		}
	}
	
	static void threeComb(int cnt, int start) {
		if(cnt == 3) {
			if(isMaz(selected[0], selected[1])) return;
			if(isMaz(selected[0], selected[2])) return;
			if(isMaz(selected[1], selected[2])) return;
			
			int sum = dice[selected[0]] + dice[selected[1]] + dice[selected[2]];

			three = Math.min(three, sum);
			return;
		}
		for (int i = start; i < 6; i++) {
			selected[cnt] = index[i];
			threeComb(cnt+1, i+1);
		}
	}
	
	static boolean isMaz(int a, int b) {//a랑 b는 인덱스
		if(a == 0 && b == 5) return true;
		if(a == 5 && b == 0) return true;
		if(a == 1 && b == 4) return true;
		if(a == 4 && b == 1) return true;
		if(a == 2 && b == 3) return true;
		if(a == 3 && b == 2) return true;
		return false;
	}

}
