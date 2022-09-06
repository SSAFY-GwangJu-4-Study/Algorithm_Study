import java.math.BigInteger;
import java.util.Scanner;

public class Main_10826_피보나치_수_4 {

static BigInteger[] fibarr = new BigInteger[10001];

public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner sc = new Scanner(System.in);
    

    int n = sc.nextInt();

    fibarr[0] = BigInteger.ZERO;
    fibarr[1] = BigInteger.ONE;
    fibarr[2] = BigInteger.ONE;
    
    fib(n);
    
    System.out.println(fibarr[n]);

}

public static void fib(int n) {
    for(int i = 3; i <= n; i++) {
        fibarr[i] = fibarr[i-1].add(fibarr[i-2]) ;
    }

}
}