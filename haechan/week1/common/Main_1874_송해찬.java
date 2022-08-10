import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_1874_송해찬 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 수열 받기
		int n = Integer.parseInt(st.nextToken());
		List<Integer> arr = new ArrayList<Integer>();
		for(int i=0; i<n; i++) {
			arr.add(Integer.parseInt(br.readLine()));
		}
		
		// 스택으로 만들 수 있는지 없는지 확인
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<Integer>();
		int cnt = 1;
		boolean errorFlag = false;
		
		// 수열의 각 숫자에 대해 for문을 돌린다 → while부터 돌리면 idx, cnt 고려할게 많아지고 더 복잡함
		for(int num : arr) {
			// 수열 원소까지 cnt 증가시키면서 스택에 add
			while(cnt <= num) {
				stack.add(cnt);
				sb.append("+\n");
				cnt++;
			}
			// num이 stack 맨 위값과 같다면 pop
			if(num == stack.peek()) {
				stack.pop();
				sb.append("-\n");
			}
			// 그렇지 않으면 에러
			else {
				errorFlag = true;
				break;
			}
		}
		
		if(errorFlag) System.out.println("NO");
		else System.out.println(sb);
	}
}
