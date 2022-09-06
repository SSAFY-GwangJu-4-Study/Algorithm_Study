import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6603_송해찬 {

	static int N, R;
	static int[] numbers, input;
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if(N==0) break;
			input = new int[N];
			for(int i=0; i<N; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			R = 6;
			numbers = new int[R];
			sb = new StringBuilder();
			comb(0, 0);
			System.out.println(sb);
			
		}
	}

	private static void comb(int cnt, int start) {
		if (cnt == R) {
			for (int i = 0; i < numbers.length; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i < N; i++) {
			numbers[cnt] = input[i];
			comb(cnt + 1, i + 1);
		}
	}
}
