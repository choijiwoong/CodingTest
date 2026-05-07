/*
    [규칙]
    GYR순. 신호마다 지속시간(최소1초) 다름.
    각 신호등이 초록불 상태로 시작.
    모두 노란불이 되면 정전.
    [입력]
    신호등 n개의 신호 주기를 담은 2차원 배열
    [출력]
    모두 노란불이 되는 최소공배수를 구하는 함수 제작.
    만약 존재하지 않을 경우 -1리턴.
    [고민]
    제한사항을 잘 이해해야할 듯 하다.
    각 지속시간은 18이하이고, 모든 지속시간의 합은 20이하이다. 즉 이론적으로 최소공배수가 없다는 것은 말이 안되기에(전부 곱하면 되니) 해당 최소공배수를 구한 뒤 저 제한사항을 만족하지 않으면 -1을 리턴하게 하면 될 듯 하다.

    오늘은 많이 피곤하니 문제 이해에서 그치고, 내일 최소 어떻게 접근 방법을 설계하면 좋을지라도 시도해보자.

    [시도]
    짧게라고 시도해보려한다. 확실히 백준이랑은 좀 다르다. 문제가 길기에 위에 내 방식대로 정한 규칙을 구현해보자.
    목적은 TDD이다. 초록시작, 모두노란불 정전, GYR순, 각 시간은 18이하, 합은 20이하.
    핵심은 노란불이 몇분 이후부터 몇분 간격으로 켜지는지.
*/
class Solution {
    public int solution(int[][] signals) {
        int answer = -1;
        // GG GG YG RG RG    GY GR YG RG RG   GG GG YY RR RG
        // signals lenght만큼 char[]를 만들기. 각 초별 상태를 갱신. 20까지 진행하며 Y가 전부 되는 조건 체크.
        // 상태 갱신의 효율을 좀 따져봐야하는데, 가장 쉬워보이는건 GYR이니 int 3개 두고 --하며 사용.

        // int len = signals.length;
//         char[] cur = new char[len];
//         for(int i=0; i<len; i++)
//             cur = 'G';

//         // 초별 상태변화 처리
//         for(int i=1; i<=20; i++){
//             // 리스트 별 처리
//             for(int j=0; j<len; j++){
//                 int g = signals[j][0];
//                 int y = signals[j][1];
//                 int r = signals[j][2];

//             }
        // 하려했는데 좀 for 문이 많아져 복잡해진다. 아주 쉽게 수학적으로 해결할 수 있을 듯 한데..
        // 일단 리스트 별 Y가 되는 시간대를 계산해야한다. 이를 대충 a+b*i ~ a+b*i+c 라고 해보자.
        // 조금 더 간단화 해보자. 처음 Y가 되는 시간대만 확인해보자. 현재 Y가 중간에 있기에 조금 거슬린다.
        // 안되겠다 직접 샤프로 끄적여보자.

        // 최소공배수가 아니다. len만큼 int두고 작은것을 규칙에 의거, 더해가며 모두가 같아지는 시점을 찾는 것.
        // 순서가 상관있기에(규칙) 매번 작은걸 찾아야 함.
        int len = signals.length;
        int[] cur = new int[len];
        for(int i=0; i<len; i++)
            cur[i]=1;



        return answer;
    }

    public boolean is_same(int[] input){
        boolean result = true;
        int n = input[0];
        for(int i=1; i<input.length; i++){
            if(n!=input[i]){
                result = false;
                break;
            }
        }
        return result;
    }
}