import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int n, m;
    static int[] result;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args){
        /*
            N과 M이 있을 때, 1부터 N까지 자연수 중 중복없이 M개를 고른 모든 수열을 출력.
            수열은 오름차순으로 출력.
            1~N까지 중 M개 중복없이 고른 경우.

            직관적으로 바로 M번의 반복문이 생각나지만 일반적인 방식으론 불가능하다. 이게 백트레킹이라 부르는거구나.
            컴공시절을 생각해보자. 어떻게 해결했지? 핵심은 M개를 고르는 것이다. 사실 난 이런경우 다 쌩까고 for로 풀긴했었다. 하지만 어케했는지 기억안남.

            시도 1.
            인덱스의 조합으로 생각을 해볼까 M개의 int배열로 각 숫자를 가리킴.
            오름차순 정렬 및 중복을 피하며 뒤에서부터 ++하며 조합의 경우를 출력.
            이 방법도 어떻게든 푸는 것이니 시도해보자. 조금 어렵다.... 나 과거에 배열 고수였구나.

            시도 2. gemini
            반복문을 중첩하기 어려울 경우 재귀를 사용하는 것이 보편적이다. 재귀파워!
            전체 흐름을 이해하기 어렵다. 문제를 조금만 다르게 생각하면 이해가 될 듯 하다.
            골라야하는 숫자의 크기 M은 트리의 깊이를 의미한다.
            편의를 위해 오름차순으로 정렬된 일차원 배열의 트리라고 생각할 때,
            왼쪽 아래 방향으로 끝까지 갔다가 하나씩 빼고 다음으로 넘어가는, DFS와 일치한다.
            즉, 그래프의 응용이다.
            M이 3이면, 1층으로 1을, 2층으로 2를, 3층으로 3을 선택하고, DEPTH를 만족했으니 3을 pop하고 다음 4를 넣는 것이다.

            dfs(depth+1)은 갈림길에서 한쪽 길로 쭉 가보는 것
            depth==m으로 return은 막다른 길에 도착해서 뒤로 돌아서는 것
            visited[i]=false는 막다른길에 다다른 마지막 발자국을 지우는 것. 으로 볼 수 이싿.

            아직은 낯설 수 밖에 없을 듯 하지만 모든 로직을 이해하기 어렵겠지만 아래 정도는 기억해보자.
            1. static변수로 설정하여 여러 함수에서 접근하기 편하게 하기. StringBuilder 포함
            2. 재귀(주로 그래프 DFS, BFS)에서 가장 먼저 종료조건 신경쓰기. 지금의 경우 result배열이 꽉 찬 경우(m)이며 이를 별도로 depth로 편하게 관리하는 것.
            3. 종료조건을 작성했다면 종료조건까지 가는 과정을 반복문, 재귀 등으로 설계하기.
            4. 과정을 주로 반복문으로 1차적으로 가능한 숫자의 모든 경우를 순회하게 하기.
            5. 그 후 visited를 통해 방문 여부를 확인한 후, 선택 가능한 후보군을 좁히기
            6. 선택 가능한 후보를 방문처리하고 실제 result에 해당 depth로 저장하기(수 추출)
            7. 이후 다음 depth탐색을 위해 재귀로 depth+1호출시켜 종료조건 까지 가게 진행시키기(중요. 무한루프 방지)
            8. 재귀 이후로 넘어왔다는 것은 m개의 모든 추출이 끝났다는 것으로 i++과 같이 후속 탐색을 위한 후처리를 해야한다.
            9. 지금과 같은 경우는 현재 사용한 수 중 제일 큰 값인 i의 방문처리를 끔으로써 초기 반복문 1~n까지의 visited처리를 꺼서 2~n까지 재탐색이 가능케 한다.

            지금 이해가 안되는 부분은 사실 9번 visited[i]=false이다. 방금 쓴 수만 내려놓아 추가적인 탐색이 가능케 한다는데..
            막다른 길 종료 직전에 한 딱 1번의 행동만 undo하기 위해 visited를 줄이고 다음 i++를 탐색하게 하는 듯 하다.
        */
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();

        // 결국 m개를 전부 뽑아야한다. 이 때 숫자를 가리키기 위한 result 배열과,
        // 후보 숫자를 마음 편하게 탐색할 수 있도록 result에 이미 들어있는지(방금 탐색했는지)를 확인할 visited배열을 보조로 사용한다.
        // 1~M까지의 숫자를 고를건데 몇번 째 숫자를 고르고있는지는 depth 인자를 이용해 구분한다.
        result = new int[m];// M개를 뽑을 예정
        visited = new boolean[n+1];//1부터 n까지 숫자의 사용 여부 기록

        dfs(0);
        System.out.println(sb);
        sc.close();
    }

    public static void dfs(int depth){
        //모든 depth(추출해야하는 개수 크기)를 만족한다면 출력.
        if(depth==m){
            for(int val : result)
                sb.append(val).append(' ');
            sb.append('\n');
            return;
        }

        for(int i=1; i<=n; i++){
            //1부터 시작해서 n범위 까지 방문하지 않은 숫자 하나를 발견하면, result에 append하여 저장.
            //그 후 depth를 늘려 재귀.
            //모든 크기가 만족되어 재귀가 풀린다면 visited를 false처리하여 다시 사용할 수 있도록 해제.
            if(!visited[i]){
                visited[i]=true;
                result[depth]=i;

                dfs(depth+1);
                visited[i]=false;
            }
        }
    }

}