import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13300_방배정 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st= new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] students = new int[7][2];
		int result =0;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			
			students[grade][gender] +=1;
		}
		
		for(int i=1;i<=6;i++) {
			for(int j=0;j<2;j++) {
				if(students[i][j]==0) continue;
				else if(students[i][j]<=K) result+=1;
				else {
					int tmp =students[i][j];
					if(tmp%K==0) result+=(tmp/K);
					else result+= (tmp/K)+1;
				}
			}
		}
		System.out.println(result);
	}
}
