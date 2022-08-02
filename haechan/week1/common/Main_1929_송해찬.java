import java.util.Scanner;

public class Main_1929_송해찬 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		for(int i=m; i<=n; i++) {
			if(isPrimeNumber(i) > 0) {
				System.out.println(isPrimeNumber(i));
			}
		}
	}
	
	static int isPrimeNumber(int x) {
		if(x==1) return 0;
		if(x==2) return x;
		if(x>=3) {
			for(int i=2; i<Math.sqrt(x)+1; i++) {
				if(x%i==0) {
					return 0;
				}
			}
		}
		return x;
	}

}
