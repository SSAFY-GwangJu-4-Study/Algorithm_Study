import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1074_Z {
	public static int cnt;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		solve((int) Math.pow(2, N), r, c);
		
		System.out.println(cnt);
	}
	
	public static void solve(int n, int r, int c) {//n : 한 변의 길이
		if(n==1) {
			return;
		}
		if(r < n/2 && c < n/2) {
			solve(n/2, r, c);
		}
		else if(r < n/2 && c >= n/2) {
			cnt += (n/2)*(n/2); 
			solve(n/2, r, c-n/2);
		}
		else if(r >= n/2 && c < n/2) {
			cnt += (n/2)*(n/2)*2; 
			solve(n/2, r-n/2, c);
		}
		else if(r >= n/2 && c >= n/2) {
			cnt += (n/2)*(n/2)*3; 
			solve(n/2, r-n/2, c-n/2);
		}
		
	}

}
