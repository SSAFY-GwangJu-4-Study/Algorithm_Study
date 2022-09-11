import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_17609_회문 {
	static int result;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int cnt = Integer.parseInt(br.readLine());
		for (int i = 0; i < cnt; i++) {
			String s = br.readLine();
			
			isPalindrome(s);
			sb.append(result+"\n");
			
		}
		System.out.println(sb);
	}
	
	static void isPalindrome(String s) {
		char[] arr = s.toCharArray();
		for (int i = 0, n = arr.length; i < n/2; i++) {
			if(arr[i] != arr[n-1-i]) {//펠린드롬이 아니면 유사 검사
				isUsa(arr, i, n-1-i);
				return;
			}
		}
		result = 0;
	}
	
	static void isUsa(char[] arr, int r1, int r2) {//r1, r2를 지워본 후 팰린드롬 검사
		result = 0;
		List<Character> list = new ArrayList<Character>();
		for (int i = 0, n = arr.length; i < n; i++) {
			list.add(arr[i]);
		}
		list.remove(r1);
		
		for (int i = 0, n = list.size(); i < n/2; i++) {
			if(list.get(i) != list.get(n-1-i)) {
				result = 2;
				break;
			}
		}
		if(result != 2) {
			result = 1;
			return;
		}
		
		List<Character> list2 = new ArrayList<Character>();
		for (int i = 0, n = arr.length; i < n; i++) {
			list2.add(arr[i]);
		}
		list2.remove(r2);
		
		for (int i = 0, n = list2.size(); i < n/2; i++) {
			if(list2.get(i) != list2.get(n-1-i)) {
				result = 2;
				return;
			}
		}
		
		result = 1;
	}

}
