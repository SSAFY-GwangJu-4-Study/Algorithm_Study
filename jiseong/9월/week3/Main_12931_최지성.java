import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12931_최지성 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		boolean[] zeros = new boolean[N];
		int count = 0; // 연산 횟수

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());

			if (arr[i] == 0)
				zeros[i] = true;
		}

		while (!allZero(zeros)) {
			for (int i = 0; i < N; i++) {
				if (arr[i] % 2 == 1) {
					arr[i]--;
					count++;
					
					if(arr[i] == 0)
						zeros[i] = true;
				}
			}
			if (allZero(zeros))
				break;

			for (int i = 0; i < N; i++) {
				arr[i] = arr[i] >> 1;
			}
			
			count++;
		}
		
		System.out.println(count);
	}

	public static boolean allZero(boolean[] zeros) {
		for (int i = 0; i < zeros.length; i++) {
			if (!zeros[i])
				return false;
		}
		return true;
	}
}
