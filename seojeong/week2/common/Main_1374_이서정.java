package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1374_이서정 {
    public static class Node {
        int o, s, e;
        Node(int o, int s, int e) {
            this.o = o;
            this.s = s;
            this.e = e;
        }
    }
    public static List<Node> list = new ArrayList<>();
    public static PriorityQueue<Integer> que = new PriorityQueue<>();
    public static Comparator<Node> comparator = new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            return Integer.compare(o1.s, o2.s);
        }
    };
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int o = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list.add(new Node(o, s, e));
        }

        Collections.sort(list, comparator);
       
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            while(!que.isEmpty() && que.peek() <= list.get(i).s) {
            	System.out.print("나가는거");
                System.out.println(que.poll());
                System.out.println();
            }

            que.add(list.get(i).e);
            System.out.printf("큐임"+que);
            System.out.println();
            max = Math.max(max, que.size());
        }

        System.out.println(max);
    }
}