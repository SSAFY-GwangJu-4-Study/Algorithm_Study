import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 이모티콘
 * 
 * @author 김경삼
 *
 */
public class Main_14226_김경삼 {
	static int ans;

	static class Emoticon {
		int count;
		int time;
		int clip;
		public Emoticon(int count,int time,int clip) {
			this.count = count;
			this.time = time;
			this.clip= clip;
		}
		@Override
		public String toString() {
			return "Emoticon [count=" + count + ", time=" + time + ", clip=" + clip + "]";
		}
		
	}

	static boolean visited[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		visited = new boolean[1001][1001];
		find(N);
	}

	private static void find(int n) {
		Queue<Emoticon> queue = new LinkedList<>();
		queue.add(new Emoticon(1,0,0));

		while (!queue.isEmpty()) {
			Emoticon cur = queue.poll();
//			System.out.println(cur);
			visited[cur.count][cur.clip] = true;
			if (cur.count+cur.clip>1000)continue;
			if (cur.count<=0) continue;
			//현재 클립보드에 최신값이 복사되어있으면 복사하지 않기 --> 이것때문에 메모리오류 났었다.
			if(cur.count!=cur.clip) {
				queue.add(new Emoticon(cur.count,cur.time+1,cur.count));
			}
			if (!visited[cur.count+cur.clip][cur.clip]) {
				if(cur.count+cur.clip==n) {
					System.out.println(cur.time+1);
					return;
				}else {
					queue.add(new Emoticon(cur.count+cur.clip, cur.time + 1,cur.clip));
				}
			}
			if (cur.count - 1 >= 0 && !visited[cur.count-1][cur.clip]){
				if(cur.count-1==n) {
					System.out.println(cur.time+1);
					return;
				}else {
					queue.add(new Emoticon(cur.count - 1, cur.time + 1,cur.clip));
				}
			}
		}

	}
}
