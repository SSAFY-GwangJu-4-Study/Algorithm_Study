import java.util.Scanner;

public class Main_4948_송해찬 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(true) {
			int n = sc.nextInt();
			if(n==0) break;
			int cnt = 0;
			for(int i=n+1; i<=2*n; i++) {
				if(isPrimeNumber(i)) {
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
	
	static boolean isPrimeNumber(int x) {
		if(x==1) return false;
		if(x==2) return true;
		else {
			for(int i=2; i<Math.sqrt(x)+1; i++) {
				if(x%i==0) {
					return false;
				}
			}
		}
		return true;
	}

}
