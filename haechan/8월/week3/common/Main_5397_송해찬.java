import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.io.IOException;

public class Main_5397_송해찬 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			String str = br.readLine();
			StringBuilder sb = new StringBuilder();
			// 왼/오 스택 만들어서 커서 대신에 문자열을 움직이기
			Stack<Character> left = new Stack<>();
			Stack<Character> right = new Stack<>();
			for(char ch : str.toCharArray()) {
				// <일때 왼쪽스택에 뭐 있으면 오른쪽스택으로 넘기기
				if(ch == '<' && !left.isEmpty()) {
					right.push(left.pop());
				}
				// >일때 오른쪽스택에 뭐 있으면 왼쪽스택으로 넘기기
				if(ch == '>' && !right.isEmpty()) {
					left.push(right.pop());
				}
				// -일때 왼쪽스택에 뭐있으면 지우기
				if(ch == '-' && !left.isEmpty()) {
					left.pop();
				}
				// <, >, - 빼고 왼쪽에 다 넣기
				if(ch != '<' && ch != '>' && ch != '-') {
					left.push(ch);
				}
			}
			
			// 테케는 맞는데 제출하면 틀림..
//			if(!left.isEmpty()) {
//				for(int i=0; i<left.size(); i++) {
//					sb.append(left.get(i));
//				}
//			}
//			if(!right.isEmpty()) {
//				for(int i=0; i<right.size(); i++) {
//					sb.append(right.get(i));
//				}
//			}
			while(!right.isEmpty()) {
				left.push(right.pop());
			}
			for(int i=0; i<left.size(); i++) {
				sb.append(left.get(i));
			}
			System.out.println(sb);
		}
	}
}
