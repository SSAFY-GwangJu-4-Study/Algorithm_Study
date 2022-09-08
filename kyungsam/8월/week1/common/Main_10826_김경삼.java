import java.util.Scanner;

public class Main_10826_김경삼 {
	//메모이제이션 기법 사용안하면 시간초과
	//
	static long[] arr ;
	static long fibo(int n) {
		if(arr[n]!=0) return arr[n];
		if(n==0) return arr[0]=0;
		if(n==1) return arr[1]=1;
		return arr[n] = fibo(n-1)+(fibo(n-2));
		
	}
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int n =sc.nextInt();
		arr = new long[(n+1)];
		System.out.println(fibo(n)+"");
	}
}
