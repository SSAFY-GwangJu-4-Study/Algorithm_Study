import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class a1{
	int num; 
	int start;
	int fin;
	
}

public class Main_1374_윤명지 {
	
	
	public static void main(String[] args) throws IOException {
		 
		PriorityQueue<Integer> que = new PriorityQueue<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(str.nextToken());
		
		//a1 a = new a1();
		
		ArrayList<a1> list = new ArrayList<>();
		
		
//		int[][] arr = new int[N][3];
		int cnt = 0;
		
		for(int i=0; i<N; i++) {
			StringTokenizer str1 = new StringTokenizer(br.readLine()," ");
			a1 a = new a1();
			a.num = Integer.parseInt(str1.nextToken());
			a.start = Integer.parseInt(str1.nextToken());
			a.fin = Integer.parseInt(str1.nextToken());
			//a1 a = new a1(num, start,fin);
			list.add(a);
//			arr[i][2] = Integer.parseInt(str1.nextToken());
//			arr[i][0] = Integer.parseInt(str1.nextToken());
//			arr[i][1] = Integer.parseInt(str1.nextToken());		
		}
		
		Collections.sort(list, new Comparator<a1>() {

//			@Override
//			public int compare(a1 o1, a1 o2) {
//				if(o1.fin == o2.fin) {
//					return o1.start - o2.start;
//				}
//				return o1.fin - o2.fin;
//			}
			@Override
			public int compare(a1 o1, a1 o2) {
				return Integer.compare(o1.start, o2.start);
			}
		});
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).start + " "+list.get(i).fin );
		}
		
		int max = Integer.MIN_VALUE;

        for(int i = 0; i < N; i++) {
            while(!que.isEmpty() && que.peek() <= list.get(i).start) {
                que.poll();
            }

            que.add(list.get(i).fin);
            max = Math.max(max, que.size());
        }

        System.out.println(max);

//		
//		int res = 0;
//		while(true) {
//			int fin_time = 0;
//			int c = list.size();
//			for(int i=0; i<c; i++) {
//				if(fin_time<=list.get(i).start) {
//					cnt = cnt + 1;
//					fin_time = list.get(i).fin;
//					list.remove(i);
//					c--;
//				}
//			}
//			res = res+1;
//			if(cnt == N) {
//				break;
//			}
//		}
//		
//		System.out.println(res);
//		

	}

}
