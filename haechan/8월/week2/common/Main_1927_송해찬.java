import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_1927_송해찬 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
//		PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				// TODO Auto-generated method stub
//				return o1-o2;
//			}
//		});
		PriorityQueue<Integer> queue = new PriorityQueue<>(); // 기본 comparator가 오름차순 뽑기
		
		for(int i=0; i<n; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x>0) {
				queue.add(x);
			}
			else {
				if(queue.isEmpty()) System.out.println(0);
				else System.out.println(queue.poll());
			}
		}
	}

}
