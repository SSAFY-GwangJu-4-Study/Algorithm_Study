import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * BOJ 17609. 회문
 * 구현 문제, 더 좋은, 깔끔한 방법이 있을 것 같음
 * (실수)
 * equals를 사용해서 문자열 비교해야 하는데 == 로 비교해서 답 안나옴
 * @author kjh
 *
 */
public class Main_17609_김정효 {
	static String[] str;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			str = br.readLine().split("");
			
			if(search(0, str.length-1)) {
				System.out.println(0);
				continue;
			}
			if (search2(0, str.length-1)) {
				System.out.println(1);
			}
			else {
				System.out.println(2);
			}
		}

	}

	private static boolean search(int left, int right) {
		while(left <= right) {
			if(str[left].equals(str[right])) {
				left+=1;
				right-=1;
				continue;
			}
			return false;
		}
		return true;
	}

	private static boolean search2(int left, int right) {	// 다시 처음부터 문자열 확인하는 과정
		while(left <= right) {
			if(!str[left].equals(str[right])) {
				boolean a = search(left+1, right);	// 왼쪽 삭제
				boolean b = search(left, right-1);	// 오른쪽 삭제
				if (!a && !b) {		// 회문, 유사회문 둘 다 아닌 경우
					return false;
				}
				else return true;	// 검사한 위치까지의 문자열이 유사회문인 경우
			}
			left+=1;		// 끝까지 유사회문인지 확인
			right-=1;
		}
		return true;
	}
}
