import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static boolean[][] edges;
    public static int n, m, r;
    public static boolean[] is_visited;
    public static int[] result;

    public static void dfs(int node, int seq){
        /*
            잘 모를 땐 항상 기본을 생각하자. 기본 없인 심화가 없다.
            DFS는 순위 탐색 순서가 n->n1->n2이다.
            마찬가지로 종료조건. n에서 연결된 간선이 없거나, 간선이 있어도 모두 방문한 상태일 때.
            그 때 depth가 바로 순서를 의미한다.

            모든 정점 별 결과를 저장하기 위해 result[N]을 0으로 세팅해두고
            dfs에서 마주하는 노드의 순서를 result에 저장, 탐색하다 더 작은 값이 나오면 순서를 갱신만 해주면 된다.
            즉, 단순 탐색만 하면 됨. 우선 종료조건부터 세팅하자.
            만약 막다른 길에 도달했을 때,
        */
        if(is_visited[node])// 방문한 노드면 종료
            return;

        //방문을 지금 할 노드라면
        is_visited[node]=true;

        // 첫 방문인 노드이거나, 기존의 저장된 값이 더 크다면 갱신
        if(result[node]==0)// || result[node]>seq) 만약 각 접근 가능한 최소 경로를 구하는거면 이게 맞음.
            result[node]=seq;

        for(int i=1; i<=n; i++){
            if(edges[node][i]){
                dfs(i, seq+1);
            }
        }
        //한발 뺴기
        is_visited[node]=false;
    }

    public static void main(String[] args) throws IOException{
        /*
            DFS 연습예제.
            정점의 수 N, 간선의 수 M, 시작 정점 R이 주어지고,
            M개 줄에 간선 정보 u v가 주어지며 이는 가중치 1인 양방향 간선을 의미한다.

            인접 정점을 오름차순으로 방문했을 때, 시작 정점 1부터 깊이우선탐색을 수행하는 과정을 출력.
            이거 의미하는게 i번째 줄에서 i의 방문 순서를 말한다.
            즉,
            1~N까지의 정점이 몇번째로 지나치는지를 각각 출력하면 된다. 접근불가하다면 0을 출력.

            우선 M*M배열로 간선정보부터 표시.
            그리고 시작 정점으로 부터 각 연결된 곳들을 DF로 가면 되는데..
        */
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 기본정보 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        // 변수 초기화
        edges = new boolean[m+1][n+1];
        is_visited = new boolean[n+1];
        result = new int[n+1];

        // 간선정보 입력
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a =  Integer.parseInt(st.nextToken());
            int b =  Integer.parseInt(st.nextToken());
            edges[a][b]=edges[b][a]=true;
        }

        // 탐색
        dfs(r, 1);

        // 출력
        for(int i=1; i<=n; i++){
            bw.write(String.valueOf(result[i]));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}