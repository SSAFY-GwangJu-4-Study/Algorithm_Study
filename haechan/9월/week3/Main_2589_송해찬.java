import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Main_2589_송해찬 {
    static int N, M, ans;
    static int[][] deltas = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    static char grid[][];
    static boolean visit[][];
    
    public static class Pos{
        int x;
        int y;
        int cnt;
        public Pos(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new char[N][M];
        visit = new boolean[N][M];
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                grid[i][j] = str.charAt(j);
            }
        }
        
        // 모든 L에 대해 bfs 탐색
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(grid[i][j] == 'L') {
                    visit = new boolean[N][M];
                    int val = bfs(i,j);
                    ans = Math.max(ans, val);
                }
            }
        }
        
        System.out.println(ans);
        
    }
    private static int bfs(int i, int j) {
        Queue<Pos> queue = new LinkedList<>();
        int val = 0;
        // 첫 시작 방문표시 해줘야됌!!
        visit[i][j] = true;
        queue.add(new Pos(i,j,0));
        while(!queue.isEmpty()) {
            Pos p = queue.poll();
            for(int d=0; d<deltas.length; d++) {
                int nr = p.x + deltas[d][0];
                int nc = p.y + deltas[d][1];
                if(isInside(nr, nc) && !visit[nr][nc] && grid[nr][nc]=='L') {
                    visit[nr][nc] = true;
                    queue.add(new Pos(nr, nc, p.cnt+1));
                    val = Math.max(val, p.cnt+1);
                }
            }
        }
        return val;
    }
    
    static boolean isInside(int nr, int nc) {
    	return nr>=0 && nr<N && nc>=0 && nc<M;
    }
}
 