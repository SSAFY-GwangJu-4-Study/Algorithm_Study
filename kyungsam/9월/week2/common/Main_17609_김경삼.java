import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 회문 문제 골드5
 * @author Kyungsam Kim
 *
 */
public class Main_17609_김경삼 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st= null;
	
	int T = Integer.parseInt(br.readLine());
	
	for(int tc=0;tc<T;tc++) {
		String line = br.readLine();
		System.out.println(find(line));
	}
	}
	private static int find(String line) {
		if(isPallin(line)) {
			return 0;
		}
		if(isPallin2(line)) {
			return 1;
		}
		return 2;
	}
	
	private static boolean isPallin(String line) {
		
	for(int i=0;i<line.length()/2;i++) {
		if(line.charAt(i)!=line.charAt(line.length()-1-i)) return false;
	}
	return true;
	}
	
	private static boolean isPallin2(String line){
		int cnt = line.length();
		for(int i=0;i<cnt;i++) {
			
		}
		for(int i=0;i<cnt;i++) {
			if(line.charAt(i)!=line.charAt(cnt-1-i)) {
				StringBuilder left = new StringBuilder(line.substring(i+1, cnt-i));
				StringBuilder right = new StringBuilder(line.substring(i, cnt-1-i));
				if(left.toString().equals(left.reverse().toString())||
						right.toString().equals(right.reverse().toString()))return true;
				else return false;
			}
		}
		return false;
	}
}
