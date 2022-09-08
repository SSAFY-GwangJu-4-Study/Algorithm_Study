import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/**
 * 소수인 팰린드롬 문제
 * 시간초과로 에라토스테네스의 체 사용 필수.
 * @author Kyungsam Kim
 *
 */
public class Main_1990_김경삼 {
	
	static int start;
	static int end;
	static boolean[] prime;
	static List <Integer> prime_numbers;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st= new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		prime= new boolean[end+1];
		prime_numbers = new ArrayList<>();
//		for(int i=start;i<=end;i++) {
//			if(isPallin(i)&&isPrime(i)) {
//				System.out.println(i);
//			}
//		}
		isPrimeAndPallin();
		System.out.println(-1);
	}
	
	private static void isPrimeAndPallin() {
		prime[0]=true;
		prime[1]=true;
		
		
		for(int i=2;i*i<=end;i++) {
			
			if(!prime[i]) {
				
				for(int j=i*i;j<=end;j+=i)prime[j]=true;
			}
		}
		for(int i=1;i<=end;i++) {
			if(!prime[i]&&isPallin(i)) {
				prime_numbers.add(i);
			}
		}
		for(int i=0;i<prime_numbers.size();i++) {
			if(prime_numbers.get(i)>=start) {
				System.out.println(prime_numbers.get(i));
			}
		}
	}
	
	private static boolean isPallin(int num) {
		StringBuilder sb = new StringBuilder();
		sb.append(num+"");
		if(sb.toString().equals(sb.reverse().toString())){
			return true;
		}
		return false;
	}
}
