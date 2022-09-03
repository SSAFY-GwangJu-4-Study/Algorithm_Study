import java.math.BigInteger;
import java.util.Scanner;

public class Main_10826_윤명지 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		//int[] arr = new int[N+1];
		BigInteger[] arr = new BigInteger[N+1];
		
		if(N==0) {
			System.out.println("0");
		} else if(N==1){
			System.out.println("1");
		} else {
			arr[0] = BigInteger.ZERO;
			arr[1] = BigInteger.ONE;
			for(int i=2; i<N+1; i++) {
				arr[i] = arr[i-1].add(arr[i-2]);
			}
			System.out.println(arr[N]);
		}
		

	}

}
