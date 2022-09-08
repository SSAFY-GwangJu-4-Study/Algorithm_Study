import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main_10819_송해찬 {

	static int N, maxDiff;
	static int[] arr, perm;
	static boolean[] isVisited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		perm = new int[N];
		isVisited = new boolean[N];
		dfs(0);

		sb.append(maxDiff);
		System.out.println(sb);
	}
	
	static void dfs(int idx) {
		if(idx == N) {
			int temp = 0;
			for(int i=1; i<N; i++) {
				temp += Math.abs(perm[i] - perm[i-1]);
			}
			maxDiff = Math.max(maxDiff, temp);
//			System.out.println(Arrays.toString(perm));
//			System.out.println(temp);
		}
		for(int i=0; i<N; i++) {
			if(!isVisited[i]) {
				perm[idx] = arr[i];
				isVisited[i] = true;
				dfs(idx+1);
				isVisited[i] = false;
			}
		}
	}
}
