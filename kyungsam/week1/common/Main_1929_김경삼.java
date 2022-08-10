import java.util.Scanner;

public class Main_1929_김경삼 {
	static boolean isPrime(int n) {
		for(int i=2;i<=Math.sqrt(n);i++) {
			if(n%i==0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m =sc.nextInt();
		int n = sc.nextInt();
		for(int i=m;i<=n;i++) {
			if(isPrime(i)==true) {
				System.out.println(i);
			}
		}
	}

}
