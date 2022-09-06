import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1747_소수앤팰린드롬 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		while(true) {
			String s = String.valueOf(n);
			if(isPellindrom(s)) {
				if(isSosu(n)) {
					System.out.println(n);
					break;
				}
			}
			n++;
		}
	}
	
	static boolean isPellindrom(String s) {
		char[] arr = s.toCharArray();
		int n = arr.length;
		for(int i = 0; i < n/2; i++){// 0 1 2 3 4
			if(arr[i] != arr[n-i-1]) return false;
		}
		return true;
	}
	
	static boolean isSosu(int n) {
		if(n == 1) return false;
		for(int i = 2; i*i <= n; i++) {
			if(n%i == 0) return false;
		}
		return true;
	}

}
