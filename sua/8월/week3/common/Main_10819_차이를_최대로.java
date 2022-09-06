import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10819_차이를_최대로 {
	public static int N, result, max, totalCnt;
	public static int[] input, choice;
	public static boolean[] isSelected;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		result = 0;
		max = 0;
		input = new int[N];
		choice = new int[N];
		isSelected = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		perm(0);
		
		System.out.println(max);

	}
	
	public static void perm(int cnt) {
		if(cnt == N) {
			result = 0;
			for(int i = 0; i < N-1; i++) {
				result += cal(choice[i], choice[i+1]);
			}
			if(max < result) max = result;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(isSelected[i]) continue;
			choice[cnt] = input[i];
			isSelected[i] = true;
			perm(cnt+1);
			isSelected[i] = false;
		}
		
	}
	public static int cal(int a, int b) {
		return Math.abs(a-b);
	}
}
