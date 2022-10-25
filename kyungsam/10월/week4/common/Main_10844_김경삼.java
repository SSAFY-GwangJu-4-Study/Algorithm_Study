import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 쉬운 계단 수 문제
 * N=2 일떄,
 * 10 12 21 23 32 34 43 45 54 56 65 67 76 78 87 89 98
 * @author 김경삼
 *
 */
public class Main_10844_김경삼 {
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N= Integer.parseInt(br.readLine());
		ans=9;
		if(N==1) {
			System.out.println(9);
		}else {
			for(int i=1;i<N;i++) {
				ans=ans*2-1*(int)Math.pow(2, i-1);
			}
			System.out.println(ans);
		}
	}
}
