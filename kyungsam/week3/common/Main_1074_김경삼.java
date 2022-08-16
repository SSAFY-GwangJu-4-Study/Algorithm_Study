import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1074_김경삼 {
	static int N,r,c,cnt;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st= new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		int size = (int)Math.pow(2, N);
//		map = new int[size][size];
		find(size,r,c);
		System.out.println(cnt);
	}
	
	private static void find(int size, int curR,int curC) {
		if(size ==1 ) {
			return;
		}
		
		int half = size/2;
		
		if(curR/half==0&&curC/half==0) {
			cnt+=half*half*0;
			find(half,curR%half,curC%half);
		}else if(curR/half==0&&curC/half==1) {
			cnt+=half*half*1;
			find(half,curR%half,curC%half);
		}else if(curR/half==1&&curC/half==0) {
			cnt+=half*half*2;
			find(half,curR%half,curC%half);
		}else if(curR/half==1&&curC/half==1) {
			cnt+=half*half*3;
			find(half,curR%half,curC%half);
		}
	}
}
