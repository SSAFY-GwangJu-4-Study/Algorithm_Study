import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_10773_송해찬 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<k; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num != 0) {
				stack.push(num);
			}
			else {
				stack.pop();
			}
		}
		
		int ans = 0;
		for(int num : stack) {
			ans += num;
		}
		System.out.println(ans);
	}

}
