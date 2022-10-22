import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_6603_이서정 {

	static int num[];
	static int k;
	static int result[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if(k==0) break;
			
			num=new int[k];
			for(int i=0; i<k; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			result=new int[6];
			comb(0,0);
			System.out.println();
		}
	}
	
	static void comb(int start, int cnt) {
		if(cnt==6) {
			for(int i=0; i<6; i++) {
				System.out.print(result[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=start; i<k; i++) {
			result[cnt]=num[i];
			comb(i+1, cnt+1);
		}
		
	}

}
