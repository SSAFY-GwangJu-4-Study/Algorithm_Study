import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4112_이서정{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int test=0; test<T; test++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int temp=0;
			if(a>b) { //a와 b바꿔주기
				temp=a;
				a=b;
				b=temp;
			}
			
			int num=0;
			int ah=0;
			int aw=0;
			while(num<a) {
				num=num+ah;
				ah++; //a의 높이 구하기
			}
			
			ah=ah-1;
			aw=a-(num-ah); //a의 위치 구하기
			
			num=0;
			int bh=0;
			int bw=0;
			while(num<b) {
				num=num+bh;
				bh++; //b의 높이 구하기
			}
			
			bh=bh-1;
			bw=b-(num-bh); //b의 위치 구하기
			
			int result=0;
			int rh=0;
			int rw=0;
			rh = Math.abs(ah-bh); //a, b 높이의 차 구하기
			
			if(aw<=bw) {
				if(Math.abs(aw-bw)>rh) {
					rw=Math.abs(aw-bw)-rh;
				}	
			}
			else {
				rw=Math.abs(aw-bw);
			}
			
			result=rh+rw;
			
			
			System.out.printf("#%d %d",test+1,result);
			System.out.println();
		}
		
		
	}
	
	
}
