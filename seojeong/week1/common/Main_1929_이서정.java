

import java.util.Scanner;

public class Main_1929_이서정 {
	public static boolean[] prime;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input= new Scanner(System.in);
		int m = input.nextInt();
		int n = input.nextInt();
		prime = new boolean[n+1];
		get_prime();
		for(int i = m; i <= n; i++) {
			// false = 소수 
			if(!prime[i]) System.out.println(i);
		}
	}
	
	static void get_prime() {
		prime[0] = prime[1] = true;
		for(int j=2; j<Math.sqrt(prime.length)+1; j++) {
			if(prime[j])continue;
			for(int i = j*j; i<prime.length; i+=j) {
				prime[i]=true;
			}
		}
		

	}

}
