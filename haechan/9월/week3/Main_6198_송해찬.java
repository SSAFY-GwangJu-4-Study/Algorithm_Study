import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_6198_송해찬 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		// list로 하나씩 확인하면 8만*8만+1/2 연산
		// 10 3 7 4 12 2
		// 7 들어올때 필요없는 3 없애고 싶다
		// 12 들어올때 다 지우려면 while문 필요
		// 갖고있을때 더하기 size 이용
		
		// 답 8만*8만+1/2 까지 가능
		long ans = 0;
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<n; i++) {
			// 스택에 들어간 빌딩 높이와 현재 빌딩 높이 비교
			while(!stack.isEmpty() && stack.peek() <= arr[i]) {
				stack.pop();
			}
			stack.push(arr[i]);
			ans += stack.size()-1;
		}
		
		System.out.println(ans);
	}
}