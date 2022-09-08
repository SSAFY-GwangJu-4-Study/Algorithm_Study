import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6603_로또 {
	static int k = 1;
	static int[] input, choice;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(k != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			k = Integer.parseInt(st.nextToken());
			input = new int[k];
			choice = new int[6];
			for (int i = 0; i < k; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			
			comb(0,0);
			System.out.println();
		}
		
	}
	
	static void comb(int cnt, int start) {
		if(cnt == 6) {
			for(int i = 0; i < 6; i++) {
				System.out.print(choice[i] +" ");
			}
			System.out.println();
			return;
		}
		for(int i = start; i < k; i++) {
			choice[cnt] = input[i];
			comb(cnt+1, i+1);
		}
	}

}
