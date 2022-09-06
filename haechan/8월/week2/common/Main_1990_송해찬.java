import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1990_송해찬 {

	static boolean[] isPrime = new boolean[100_000_001];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		getPrime();

//		StringBuilder sb = new StringBuilder();
		for(int i=a; i<=b; i++) {
			if(!isPrime[i] && isPalindrome(i)) {
				bw.write(i+"" +"\n");
//				sb.append(i).append('\n');
			}
		}
		bw.write(-1+"");
//		sb.append(-1);
//		System.out.println(sb);
		bw.flush();
		bw.close();
		br.close();
	}
	
	// 에라토스테네스의 체 사용
	// false로 초기화되기때문에 소수가 아닌 지워지는 숫자를 true로 함
	static void getPrime() {
		for(int i=2; i*i<=100_000_000; i++) {
			// 2부터 소수라면
			if(!isPrime[i]) {
				// 소수의 배수 지우기
				for(int j=i*i; j<=100_000_000; j+=i) {
					isPrime[j] = true;
				}
			}
		}
	}
	
	// 팰린드롬 체크
	static boolean isPalindrome(int x) {
		String num = String.valueOf(x);
		// 3→1 4→2 체크
		for(int i=0; i<num.length()/2; i++) {
			if(num.charAt(i) != num.charAt(num.length()-i-1)) {
				return false;
			}
		}
		return true;
	}
}
