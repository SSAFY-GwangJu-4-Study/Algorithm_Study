import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1406_송해찬 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		String str = st.nextToken();

		
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		
		LinkedList<Character> list = new LinkedList<Character>();
		for(int i=0; i<str.length(); i++) {
			list.add(str.charAt(i));
		}
		int index = list.size();
		
		for(int i=0; i<M; i++) {
			String cmd = br.readLine();
			char c = cmd.charAt(0);
			
			if(c == 'L') {
				if(index != 0) {
					index--;
				}
			}
			else if(c == 'D') {
				if(index != list.size()) {
					index++;
				}
			}
			else if(c == 'B') {
				if(index != 0) {
					list.remove(index-1); // 커서 왼쪽 문자 삭제
					index--;          // 커서 한칸 왼쪽으로 따라가기
				}
			}
			else if(c == 'P') {
				char x = cmd.charAt(2); // 1하면 " " 들어옴
				list.add(index, x);  // 커서 자리에 x 추가
				index++; // 더하고 나서 index 더해줘야 커서 원위치
			}
		}
		
		for(char c : list) {
			System.out.print(c);
		}
	}
}
