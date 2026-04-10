import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        /*
            첫줄엔 이미 존재하는 가로수의 수.
            둘째 줄부터 N개에는 각 줄마다 심어져있는 가로수의 위치가 양의정수. (1,000,000,000이하)10억
            가로수 위치는 모두 다르며, N개의 가로수는 기준점에서 거리가 가까운 순서대로(정렬. 이진탐색?) 입력됨
            모든 가로수가 같은 간격이 되도록 새로 심어야 하는 가로수의 최소수 출력.

            최고의 방법은 현시점 짧은 간격의 배수로만 나머지 간격이 이루어져 있는 것.
            안되면 --해가며 모든 간격이 나누어 떨어질 때(최악 1로 나누어 떨어짐) 개수를 카운트.
            각 간격을 별도의 배열에 저장하자. 배열의 크기는 n-1이 된다. 입력은 3개 이상이니 문제없음
            어차피 모든 간격에 대해 매번 %연산을 해야하기에 별도로 정렬은 불필요해보인다.

            만약 k간격으로 통일할 수 있다면 추가되는 나무는 기준점을 고려하지 않아도 된다(간격만 맞추면 되니)
            (마지막 나무 위치 - 첫 나무 위치 +1)/n -n을 하여 계산가능하다.

            1차 제출 틀렸다. 보통 이런 경우 버퍼 오버플로우이다. 하지만 마땅한게 없어보여 케이스 몇개를 넣어보았다.
            그 결과 이미 같은 간격인 경우 마지막 +1 로직 때문에 오류가 발생한다.
            간격을 미리 확인하고 전부 같다면 0을 반환하게끔 처리하자.

            2차 제출 틀렸다. Gemini의 도움을 빌린 결과 3차 제출 성공. 기본수학지식 부족에 있었다.
            추가나무 계산식에서 거리를 min_dist로 나눌 때 최고거리-최단거리 가 거리 그 자체인데 개수식과 햇갈려 +1한 값을 final_dist로 나누었다.
            몇가지 테스트 케이스에서는 발견하지 못하다가 gemini로 알아차린 거리식 오류인 것이다.
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] sorted_pos = new int[n];
        int[] dist = new int[n-1];

        // 1. 입력값 및 간격 저장
        // 간격 저장을 위해 do while 대신 미리 1회 실행 최소 3개 입력이니 별도 체크 x
        // 간격의 최솟값을 계산에 사용해야하기에 저장하면서 바로 정렬되는 Collections사용.
        // TreeSet을 사용하면 간격 개수 정보가 사라져 몇개를 더 심어야하는지 어려워진다.
        // TreeMap은 불필요한 값이 추가되기에 단순 정렬을 이용해 해결해보자.
        int pos = Integer.parseInt(br.readLine());
        sorted_pos[0]=pos;
        int prev_pos = pos;

        for(int i=1; i<n; i++){
            pos = Integer.parseInt(br.readLine());
            sorted_pos[i]=pos;
            dist[i-1]=pos-prev_pos;
            prev_pos=pos;
        }

        // 2. 최소 간격 계산
        // 이미 같은 간격인지 확인
        Arrays.sort(dist);
        int dist1 = dist[0];
        int dist2 = dist[n-2];
        if(dist1==dist2){
            System.out.println(0);
            return;
        }

        int final_dist;
        for(final_dist = dist[0]; final_dist>1; final_dist--){// 최종 탈출 시 1이 되게끔
            boolean is_pass = true;
            for(int i=0; i<n-1; i++){
                if(dist[i]%final_dist!=0){
                    is_pass = false;
                    break;
                }
            }
            if(is_pass)
                break;
        }

        // 3. 추가 나무 계산
        int result = (sorted_pos[n-1]-sorted_pos[0])/final_dist - n + 1;
        //전체 나무의 개수는 1개 많기에 +1을 해야하는데 전체를 거리 기준으로 계산한 다음에 +1해야한다.
        System.out.println(result);
        br.close();
    }
}