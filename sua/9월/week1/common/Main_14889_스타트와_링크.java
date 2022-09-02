import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14889_스타트와_링크 {
	public static int[][] ability;
	static boolean[] selected;
	static int[] choice, other;
	static int N, min;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		min = Integer.MAX_VALUE;
		
		N = Integer.parseInt(st.nextToken());
		ability = new int[N][N];
		
		selected = new boolean[N];
		choice = new int[N/2];
		other = new int[N/2];
		
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				ability[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		comb(0, 0);
		
		System.out.println(min);

	}
	
	static void comb(int cnt, int start) {
		if(cnt == N/2) {
			int sum = 0;
			int otherSum = 0;
			int a = 0;
			int b = 0;
			for (int i = 0; i < N; i++) {
				if(selected[i]) {
					choice[a++] = i;
				}else {
					other[b++] = i;
				}
			}
			
			for(int i = 0; i < N/2; i++) {
				for (int j = 0; j < N/2; j++) {
					sum += ability[choice[i]][choice[j]];
					otherSum += ability[other[i]][other[j]];
				}
			}
			int cha = Math.abs(sum-otherSum);
			if(cha < min) min = cha;
			return;
		}
		for(int i = start; i < N; i++) {;
			selected[i] = true;
			comb(cnt+1, i+1);
			selected[i] = false;
		}
		
	}

}
