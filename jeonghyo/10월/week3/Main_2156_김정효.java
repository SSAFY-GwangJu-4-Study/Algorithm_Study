import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 포도주 잔을 선택하면 그 잔에 들어있는 포도주는 모두 마셔야 하고, 마신 후에는 원래 위치에 다시 놓아야 한다.
 * 연속 3잔을 모두 마실 수는 없다.
 * (출력) 가장 많은 양의 포도주를 마심
 * @author kjh
 *
 */
public class Main_2156_김정효 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] dp = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = arr[0];	// 처음엔 무조건 선택한게 최대
		
		// 1 <= n <= 10,000 이기 때문에 i=1, 2일 때도 for문 안에 넣어줌
		for (int i = 1; i < n; i++) {
			/*
			 * 0	1
			 * -------
			 * o	o	dp[0] + arr[1]
			 */
			if (i == 1)	dp[1] = dp[0]+arr[1];
			/*
			 * 0	1	2
			 * -----------
			 * o	o	x	dp[1]
			 * o	x	o	dp[0] + arr[2]
			 * x	o	o	arr[1] + arr[2]
			 */
			else if (i == 2) dp[2] = Math.max(dp[1], Math.max(dp[0]+arr[2], arr[1]+arr[2])); 
			/*
			 * i-3	i-2	i-1	i
			 * ---------------
			 * 	?	o	o	x	dp[i-1]
			 * 	?	o	x	o	dp[i-2] + arr[i]
			 * 	o	x	o	o	dp[i-3] + arr[i-1] + arr[i]
			 */
			else dp[i] = Math.max(dp[i-3]+arr[i-1]+arr[i], Math.max(dp[i-1], dp[i-2]+arr[i]));
		}
		System.out.println(dp[n-1]);
	}

}
