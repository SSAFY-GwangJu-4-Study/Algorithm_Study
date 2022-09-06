import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1374_송해찬 {
    static class Lesson {
        int no, start, end;
        Lesson(int no, int start, int end) {
            this.no = no;
            this.start = start;
            this.end = end;
        }
    }
    static List<Lesson> list = new ArrayList<>();
    static PriorityQueue<Integer> queue = new PriorityQueue<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int no = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            // 리스트에 강의 객체 추가
            list.add(new Lesson(no, start, end));
        }

        // 강의 시작시간 오름차순 정렬
        Collections.sort(list, (l0, l1) -> l0.start - l1.start);

        int max = Integer.MIN_VALUE;

        // 모든 강의에 대해 반복
        for(int i = 0; i < n; i++) {
        	// 첫 강의가 끝나고 다음 강의가 시작된다면 들어있던 강의 제거
            while(!queue.isEmpty() && queue.peek() <= list.get(i).start) {
                queue.poll();
            }
            // 첫 강의가 끝나기 전에 강의가 시작된다면 강의실 추가하고 강의실 개수 갱신
            queue.add(list.get(i).end);
            max = Math.max(max, queue.size());
        }
        System.out.println(max);
    }
}