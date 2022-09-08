import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main_17609_송해찬 {

	static int ans, idx1, idx2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			ans = 0;
			String str = br.readLine();
			
			palindromeCheck1(str);
			if(ans>0) {
				String str1 = str.substring(0, idx1) + (str.substring(idx1+1, str.length()));
				String str2 = str.substring(0, idx2) + (str.substring(idx2+1, str.length()));
//				System.out.println(str1);
//				System.out.println(str2);
				if(palindromeCheck2(str1) || palindromeCheck2(str2)) {
				}
				else {
					ans++;
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
	
	static void palindromeCheck1(String str) {
		for(int i=0; i<str.length()/2; i++) {
			if(str.charAt(i) != str.charAt(str.length()-1-i)) {
				ans++;
				idx1 = i;
				idx2 = str.length()-1-i;
				break;
			}
		}
	}
	
	static boolean palindromeCheck2(String str) {
		for(int i=0; i<str.length()/2; i++) {
			if(str.charAt(i) != str.charAt(str.length()-1-i)) {
				return false;
			}
		}
		return true;
	}
}
