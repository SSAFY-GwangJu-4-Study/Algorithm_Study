import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1920_최지성 {
	public static int N;
	public static int[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];

		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line, " ");

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int M = Integer.parseInt(br.readLine());
		int[] find = new int[M];

		line = br.readLine();
		st = new StringTokenizer(line, " ");

		for (int i = 0; i < M; i++) {
			find[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {
			sb.append(search(find[i]) + "\n");
		}

		System.out.println(sb.toString());
	}

	
	public static int search(int n) {
		int hi = N - 1;
		int lo = 0;
		
		while (lo <= hi) {
			int mid = (hi + lo) / 2;
			
			if (arr[mid] == n)
				return 1;
			else if (arr[mid] > n)
				hi = mid - 1;
			else if (arr[mid] < n)
				lo = mid + 1;
		}
		
		return 0;
	}
}
