//피보나치 문제
public class Main_10870_김경삼 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fibo(10));
	}
	
	static int fibo(int num) {
		if(num==0)  return 0;
		else if(num==1) return 1;
		
		return  fibo(num-1)+ fibo(num-2);
		
	}
}
