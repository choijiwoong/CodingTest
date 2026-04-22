import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static ArrayList<Integer>[] adj;//인접리스트 간선저장용 공간효율위함
    static int[] result;
    static boolean[] is_visited;
    static int n, m, r;
    static int count=1;

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

            시도1. 기초 기반 + 백트레킹 경험
            MLE가 발생했다. is_visited를 제거하자. 방문을 안했다면 result가 엄.. 필요하네?

            시도2. gemini
            boolean[][] edges는 간선 저장 시 N이 100,000개일 때 10,000,000,000개를 저장해야해서 매우매우 비효율적이다.
            ArrayList<Integer>[]를 사용하자. 즉 어래이리스트 배열로 2차원을 구현하는 것이다.

            또한 백 트레킹 문제에서는 다시 돌아와서 다른 길을 찾아야 하기에 방문 처리를 해야하지만
            단순한 그래프 탐색 문제에서는 한번 방문한 노드를 다시 방문할 필요가 없다.

            dfs(i, seq+1)로 넘기면, 재귀를 타고 들어갔다가 돌아왔을 때, 다음 형제 노드에게도 같은 seq+1 즉,
            2와 3을 방문하기 위해 각각 3번쨰라는 동일한 순서를 부여해버린다.
            문제를 잘못 이해한 것인데 만약 같은 순서로 접근 가능한 경우 오름차순 순으로 순서를 확정짓는게 문제의 규칙이다.
            즉, 뭘 하던지간에 한번만 탐색하면 되며 순서는 같은 계층에서도 오름차순으로 지정되어있다.
            dfs는 이미 어느정도 이해한 듯 하니 코드를 gemini픽으로 타이핑하며 주석으로 정리하자.

            정리.
            1. bw보다 sb사용하는게 String.valueOf안써도 되서 편함.
            2. 2차원 배열로 간선 표시하는 것 보다 ArrayList를 배열로 만들어 사용하는게 효율적. (초기화 하며 ArrayList 반복 생성 필수)
            3. ArrayList들을 Collections.sort(adj[i])를 이용하여 오름차순 정렬, 따로 순서 구분 필요없이 앞에서 부터 접근하면 오름차순 조건 만족
            4. 순서를 표시하기 위해 전역 count사용하며 result에 노드 별 값을 ++로 저장

            문제를 잘 이해해야함. 그래야 백트레킹인지 DFS인지 알 수 있음.
            이전 백트레킹은 5개 중 3개 조합을 찾는 문제였기에 이전으로 돌아가는게 필요했음.
            지금은 그냥 타고타고 거치는 순서, 즉 그냥 DFS탐색 노드 순으로 번호만 매기는 문제인거임. 같으면 오름차순하고.
            애매하면 Collections.sort()나 기억하삼
        */
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        adj = new ArrayList[n+1];
        for(int i=1; i<=n; i++)
            adj[i] = new ArrayList<>();
        is_visited = new boolean[n+1];
        result = new int[n+1];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        //인접 접점을 오름차순으로 변환
        for(int i=1; i<=n; i++)
            Collections.sort(adj[i]);

        dfs(r);

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++)
            sb.append(result[i]).append("\n");

        System.out.println(sb);
        br.close();
    }

    public static void dfs(int node){
        is_visited[node]=true;
        result[node]=count++;

        for(int next: adj[node])
            if(!is_visited[next])
                dfs(next);
    }
}