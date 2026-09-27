/*
    입력:
        - 지갑의 가로, 세로 크기를 담은 배열 wallet
        - 지폐의 가로, 세로 크기를 담은 배열 bill
    출력:
        - 지갑에 넣기 위해 쵯고 몇 번 접어야 하는가? 정수
    사고:
        - 과정이 명시돼있기에 해당 과정을 따라 구현해보자.
*/
import java.lang.Math;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int w_x=wallet[0], w_y =  wallet[1];
        int b_x = bill[0], b_y = bill[1];

        // 요구사항 1
        int answer = 0;

        // 요구사항 2
        while(Math.min(b_x,b_y)>Math.min(w_x,w_y)
                || Math.max(b_x, b_y)>Math.max(w_x, w_y)){
            if(b_x>b_y)
                b_x/=2;
            else
                b_y/=2;
            answer++;
        }

        return answer;
    }
}