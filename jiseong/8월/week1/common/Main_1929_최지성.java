import java.util.Scanner;

public class Main_1929_최지성 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = Math.max(2, sc.nextInt());
		int M = sc.nextInt();
		
		for(int i = N; i <= M; i++) {
			if(i > 2 && i % 2 == 0)
				continue;
			
			if(isPrime(i))
				System.out.println(i);
		}
	}

	private static boolean isPrime(int i) {
		for(int j = 2; j <= Math.sqrt(i); j++) {
			if(i % j == 0)
				return false;
		}
		return true;
	}

}
