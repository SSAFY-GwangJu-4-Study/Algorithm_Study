import java.math.BigInteger;
import java.util.Scanner;

public class Main_10826_이서정{
		public static void main(String[] args) {
		// TODO Auto-generated method stub
	Scanner input= new Scanner(System.in);
		int n=input.nextInt();
		BigInteger fib[]=new BigInteger[n+1];
		fib[0]=BigInteger.ZERO;
		if(n>0) {
			fib[1]=BigInteger.ONE;
		}
		
		for(int i=2; i<fib.length; i++) {
			fib[i]=fib[i-1].add(fib[i-2]);
		}
		System.out.println(fib[n]);
	}

}