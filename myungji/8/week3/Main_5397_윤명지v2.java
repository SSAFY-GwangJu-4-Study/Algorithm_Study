import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_5397_윤명지v2{

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for(int tc=0; tc<T; tc++) {
			String str = br.readLine();
			Stack<Character> stack = new Stack<>();
			Stack<Character> tmp = new Stack<>();
			StringBuilder sb = new StringBuilder();
			
			/*
			 * 스택사용
			 * stack이라는 1번 통과 tmp라는 2번 통을 생성
			 * 1번 통이 주인공
			 * 1번 통에 담다가, <를 만나게 되면 해당 횟수만큼 tmp로 이동시킴
			 * >를 만나면 해당 횟수만큼 다시 1번 통으로 이동
			 */
			for(int i=0; i<str.length(); i++) {
				switch(str.charAt(i)) {
				case '<':
					if(!stack.isEmpty()) tmp.push(stack.pop());
					break;
				case '>':
					if(!tmp.isEmpty()) stack.push(tmp.pop());
					break;
				case '-':
					if(!stack.isEmpty()) stack.pop();
					break;
				default:
					stack.push(str.charAt(i));
				}
			}
			while(!tmp.isEmpty()) {
				stack.push(tmp.pop());
			}
			for(int i=0; i<stack.size(); i++) {
				sb.append(stack.elementAt(i));	// 인덱스 값 확인
			}
			System.out.println(sb.toString());
		}

	}

}
