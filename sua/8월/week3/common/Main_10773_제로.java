import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_10773_Á¦·Î{

	public static void main(String[] args) throws IOException{
		int sum = 0;
		Stack<Integer> s = new Stack<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x != 0) {
				s.push(x);
			}
			else s.pop();
			
		}
		
		while(!s.isEmpty()) {
			sum += s.pop();
		}
		
		System.out.println(sum);
	}

}
