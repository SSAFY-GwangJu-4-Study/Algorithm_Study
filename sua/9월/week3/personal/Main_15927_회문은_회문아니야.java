import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_15927_회문은_회문아니야 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		printPalindrome(s);
	}
	
	public static void printPalindrome(String s) {
		char[] arr = s.toCharArray();
		
		for (int i = 0, n = arr.length; i < n; i++) {
			if(arr[i] != arr[n-i-1]) {
				System.out.println(n);
				return;
			}
		}
		
		int a = arr[0];
		for (int i = 0, n = arr.length; i < n; i++) {
			if(arr[i] != a) {
				System.out.println(n-1);
				return;
			}
		}
		
		System.out.println("-1");
	}

}
