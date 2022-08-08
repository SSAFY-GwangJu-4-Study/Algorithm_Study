import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
//시간초과남
public class Main_1406_에디터 {
	public static List<Character> list = new LinkedList<Character>();
	public static int cursor = 0;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String s = st.nextToken();
		for(int i = 0; i < s.length(); i++) {
			list.add(s.charAt(i));
		}
		
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		cursor = s.length();
		char c = ' ';
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			char order = st.nextToken().charAt(0);
			if(order == 'P') {
				c = st.nextToken().charAt(0);
			}
			
			edit(list, order, c);
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(Character ch : list) {
			sb.append(ch);
		}
		
		System.out.println(sb);
	}
	
	public static void edit(List<Character> list, char a, char c) {
		switch(a) {
		case 'L' : 
			if(cursor>0) cursor--;
			break;
		case 'D' :
			if(cursor<list.size()) cursor++;
			break;
		case 'B' :
			if(cursor>0) {
				list.remove(--cursor);
			}
			break;
		case 'P':
			list.add(cursor, c);
			cursor++;
		}
	}

}
