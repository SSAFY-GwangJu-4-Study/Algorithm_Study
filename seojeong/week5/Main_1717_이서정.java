package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Main_1717_이서정 {
	static class Edge{
		int go, from, to;
		
		public Edge(int go, int from, int to) {
			this.go = go;
			this.from = from;
			this.to = to;
		}
	}

	static int n,m;
    static int[] parents;
    static Edge[] edgeList;

    static void make() {//크기가 1인 서로소집합 생성
        parents = new int[n+1];
        for(int i=0; i<=n; i++) { //모든 노드가 자신을 부모로하는(대표자) 집합으로 만듦
            parents[i]=i;

        }
    }

    static int find(int a) { //a의 대표자 찾기
        if(parents[a]==a) return a;
        return parents[a]=find(parents[a]); //우리의 대표자를 나의 부모로 ..:path compression
    }

    static boolean union(int a, int b) { //리턴값: true ==> union성공
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot == bRoot) return false;

        parents[bRoot] = aRoot;
        return true;
    }
    
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			StringTokenizer st = new StringTokenizer(br.readLine());
			
			n=Integer.parseInt(st.nextToken());
			m=Integer.parseInt(st.nextToken());
			
			edgeList = new Edge[m];
			make();

			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int go=Integer.parseInt(st.nextToken());
				int a=Integer.parseInt(st.nextToken());
			    int b=Integer.parseInt(st.nextToken());

				edgeList[i] = new Edge(go,a,b);

			}
			
			for(int i=0; i<m; i++) {

			    if(edgeList[i].go==0) {
			    	union(edgeList[i].from,edgeList[i].to);
			    }
			    if(edgeList[i].go==1) {
			    	if(find(edgeList[i].from) == find(edgeList[i].to)) {
			    		System.out.println("YES");
			    	}
			    	else {
			    		System.out.println("NO");
			    	}
			    }
			}

	

	}
	
}
