import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_5397_윤명지{

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		for(int tc=0; tc<T; tc++) {
			String str = br.readLine();
			ArrayList<Character> list = new ArrayList<>();
			int x = 0;
			for(int i=0; i<str.length(); i++) {
				switch(str.charAt(i)) {
				case '<':
					if(x-1>=0) {
						x = x-1;
					}
					break;
				case '>':
					if(x+1<=list.size()) {
						x = x+1;
					}
					break;
				case '-':
					if(list.size()>0 && x>0 ) {
						list.remove(x-1);
						x = x-1;
					}
					break;
				default:
					list.add(x, str.charAt(i));
					x = x+1;
				}
			}
			for(char i : list) {
				System.out.print(i);
			}

			System.out.println();
		}

	}

}
