import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1990_소수인팰린드롬 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		for(int i = a; i <= b; i++) {
			if(isPellin(i)) {
				if(isPrime(i)) {
					sb.append(i+"\n");
				}
			}		
		}
		sb.append(-1);
		System.out.println(sb);
		
	}
	public static boolean isPellin(int a) {
		String s = Integer.toString(a);
		int n = s.length();
			
			for(int i = 0; i < n/2; i++) {
				if(s.charAt(i) != s.charAt(n-1-i)) return false;
			}
			return true;

		
	}
	public static boolean isPrime(int a) {
		for(int i = 2; i*i <= a; i++) {
			if(a%i == 0) return false;
		}
		return true;
	}

}
