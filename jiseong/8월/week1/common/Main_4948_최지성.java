import java.util.Scanner;

public class Main_4948_최지성 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			int count = 0;	// 소수의 개수
			int n = sc.nextInt();

			if (n == 0)
				break;

			for (int i = n + 1; i <= 2 * n; i++) {
				if(i > 2 && i % 2 == 0)
					continue;
				
				if(isPrimeNum(i)) {
					count++;
				}
			}
			
			System.out.println(count);
		}
	}
	
	public static boolean isPrimeNum(int i) {
		for(int j = 2; j <= Math.sqrt(i); j++) {
			if(i % j == 0)
				return false;
		}
		
		return true;
	}
}
