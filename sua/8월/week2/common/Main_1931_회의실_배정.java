import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1931_회의실_배정 {
	public static class Meeting {
		int start, finish;

		Meeting(int start, int finish) {
			this.start = start;
			this.finish = finish;
		}

		int getFinish() {
			return finish;
		}

		int getStart() {
			return start;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		Meeting[] m = new Meeting[n];
				
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int finish = Integer.parseInt(st.nextToken());
			m[i] = new Meeting(start, finish);			
			
		}
		
		Arrays.sort(m, new Comparator<Meeting>() {
			@Override
			public int compare(Meeting o1, Meeting o2) {
				if(o1.getFinish() == o2.getFinish())
					return o1.getStart() - o2.getStart();
				else return o1.getFinish() - o2.getFinish();
			}
		});


		int cnt = 0;
		int end = 0;
		
		for(int i = 0; i < n; i++) {
			if(end <= m[i].getStart()) {
				cnt++;
				end = m[i].getFinish();
			}
		}
		
		System.out.println(cnt);
	}

}
