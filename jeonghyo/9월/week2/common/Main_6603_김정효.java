import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * BOJ 6603 로또
 * 조합 사용
 * (실수)
 * - (line 44) 인덱스 값 잘 넣기!!!!
 * @author kjh
 *
 */
public class Main_6603_김정효 {
	static int k, s[], arr[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if (k == 0) break;
			s = new int[k];
			arr = new int[6];
			for (int i = 0; i < k; i++) {
				s[i] = Integer.parseInt(st.nextToken());
			}
			comb(0, 0);
			System.out.println();
		}
	}

	private static void comb(int start, int cnt) {
		if (cnt == 6) {		// 6개 고름
			for (int i = 0; i < arr.length; i++) {	// 어차피 순서대로 뽑기 때문에 오름차순 고려하지 않고 출력
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			return;
		}
		// k개 중 6개 선택
		for (int i = start; i < k; i++) {
			arr[cnt] = s[i];		// arr[start]로 해서 인덱스 에러 났었음 ㅠ
			comb(i+1, cnt+1);
		}
		
	}

}
