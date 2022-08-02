import java.math.BigInteger;
import java.util.Scanner;

public class Main_10826_송해찬 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in); 
		int n = sc.nextInt();
		
		if(n==0) {
			System.out.println("0");
		}
		else if(n==1) {
			System.out.println("1");
		}
		else {
			BigInteger[] dp = new BigInteger[n+1];
			
			dp[0] = BigInteger.ZERO;
			dp[1] = BigInteger.ONE;
			for(int i=2; i<=n; i++) {
				dp[i] = dp[i-2].add(dp[i-1]);
			}
			System.out.println(dp[n]);
		}
	}
}
