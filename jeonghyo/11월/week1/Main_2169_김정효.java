import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2169_김정효 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][m];
		int[][] dp = new int[n][m];
		int[][] temp = new int[2][m+2];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0] = arr[0][0];
		for(int i=1; i<m; i++) dp[0][i] = dp[0][i-1] + arr[0][i];

		for (int i = 1; i < n; i++) {
			temp[0][0] = dp[i-1][0];
			for (int j = 1; j < m; j++) {	// 좌->우, 위->아래
				temp[0][j] = Math.max(temp[0][j-1], dp[i-1][j]) + arr[i][j];
			}
			
			for (int j = m-1; j >= 0; j--) {	// 우->좌, 위->아래
				temp[1][j] = Math.max(temp[0][j+1], dp[i-1][j]) + arr[i][j];
			}
			
			for (int j = 0; j < temp.length; j++) {
				dp[i-1][j-1] = Math.max(temp[0][j], temp[1][j]);
			}
		}

		System.out.println(dp[n-1][m-1]);
	}

}
