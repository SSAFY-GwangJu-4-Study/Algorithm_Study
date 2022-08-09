import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/**
 * 강의실 배정하기 문제
 * 우선순위 큐 활용
 * @author 김경삼
 */
public class Main_1374_김경삼 {
	static class Lecture implements Comparable<Lecture> {
		int num;
		int startTime;
		int endTime;

		public Lecture() {
			super();
		}

		@Override
		public int compareTo(Lecture o) {
			if (this.startTime == o.startTime)
				return this.endTime - o.endTime;

			return this.startTime - o.startTime;
		}
	}

	public static PriorityQueue<Integer> pQue = new PriorityQueue<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		List<Lecture> list = new ArrayList<>(); //LinkedList로 구현하면 시간초과뜸..
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			Lecture lecture = new Lecture();
			lecture.num = Integer.parseInt(st.nextToken());
			lecture.startTime = Integer.parseInt(st.nextToken());
			lecture.endTime = Integer.parseInt(st.nextToken());
			list.add(lecture);
		}

		Collections.sort(list);

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			if (!pQue.isEmpty() && pQue.peek() <= list.get(i).startTime) {
				pQue.poll();
			}
			pQue.add(list.get(i).endTime);
			max = Math.max(max, pQue.size());
		}
		System.out.println(max);
	}
}
