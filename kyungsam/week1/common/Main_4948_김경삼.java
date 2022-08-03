import java.util.Scanner;
//소수 구하기 문제
public class Main_4948_김경삼 {
	static public boolean isPrime(int n) {
		for(int i=2;i<(int)(Math.sqrt(n)+1);i++) {
			if(n%i==0) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int cnt=0;
			int n= sc.nextInt();
			if(n==0) break;
			if(n==1) {
				System.out.println(1);
				continue;
			}
			for(int i=n+1;i<2*n;i++) {
				if(isPrime(i)==true) {
					cnt+=1;
				}
			}
			System.out.println(cnt);
		}
	}
}
