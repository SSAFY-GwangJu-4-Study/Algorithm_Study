import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_6198_옥상_정원_꾸미기  {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long cnt = 0;
		
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < n; i++) {
			int h = Integer.parseInt(br.readLine());
			
			while(!stack.isEmpty() && stack.peek() <= h) {//현재 건물 높이보다 같거나 작은 층
				
				stack.pop();
			}
			cnt += stack.size();
			stack.push(h);
		}
		
		System.out.println(cnt);
	}

}
