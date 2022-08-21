import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main_5307_키로거 {
	public static List<Character> s;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			s = new LinkedList<Character>();
			ListIterator<Character> it = s.listIterator(s.size());
			
			String st = br.readLine();			
			   
			for(int j = 0; j < st.length(); j++) {
				char c = st.charAt(j);
				switch(c){
				case '<':
					if(it.hasPrevious()) it.previous();
					break;
				
				case '>':
					if(it.hasNext()) it.next();
					break;
				
				case'-':
					if(it.hasPrevious()) {
						it.previous();
						it.remove();
					}
					break;
				
				default:{
					it.add(c);
				}
				
				}
			}
			
			StringBuilder sb = new StringBuilder();

		    for (Character ch : s) {
		        sb.append(ch);
		    }

		    System.out.println(sb);
			
		}	
	}
	

}
