import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1541_송해찬 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 최솟값을 만들려면 - 연산에서 최대한 큰 값이 빠져야함
		// - 연산 전에 할 수 있는 + 연산을 모두 하기
		// ex) 55-50+40
		
		int sum = Integer.MAX_VALUE; // 맨처음 문자 안옴, 첫번째 토큰만 양수 처리
		StringTokenizer sub = new StringTokenizer(br.readLine(), "-");
		// sub next토큰 (55, 50+40)
		
		// while문 55로 한번, 50+40으로 한번, 총 두번 돈다
		while(sub.hasMoreTokens()) {
			int temp = 0;
			
			StringTokenizer add = new StringTokenizer(sub.nextToken(), "+");
			// add next토큰 (55, 50/40)
			
			while(add.hasMoreTokens()) {
				// + 연산
				temp += Integer.parseInt(add.nextToken());
			}
			
			if(sum==Integer.MAX_VALUE) {
				sum = temp;   // 첫번째 토큰만 양수 처리
			} else {
				sum -= temp;  // - 연산
			}
		}
		System.out.println(sum);
	}
}
