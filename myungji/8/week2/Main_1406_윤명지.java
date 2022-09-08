import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1406_윤명지 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int x = str.length();
		
		StringTokenizer st1 = new StringTokenizer(br.readLine()," ");
	
		int M = Integer.parseInt(st1.nextToken());
		
		for(int i=0; i<M; i++) {
			String str2 = br.readLine();
			switch(str2.charAt(0)){
			case 'L' :
				if(x-1>=0) {
					x = x-1;
				}
				break;
			case 'D' :
				if(x+1<=str.length()) {
					x = x+1;
				}
				break;
			case 'B' :
				if(x==1) {
					str = str.substring(x);
					x = x-1;
					break;
				}
				if(x-2>=0 && x<str.length()) {
					str = str.substring(0, x-1) + str.substring(x);
					x = x-1;
					break;
				}
				if(x==str.length()) {
					str = str.substring(0, x-1);
					x = x-1;
					break;
				}
				break;
			case 'P' :
				char b = str2.charAt(2);
				if(x==0) {
					str = b + str;
					x = x+1;
					break;
				} if(x == str.length()){
					str = str + b;
					x = x+1;
					break;
				} else {
					str = str.substring(0, x) + b + str.substring(x);
					x = x+1;
					break;
				}
			}
		}
		
		System.out.println(str);

	}

}
