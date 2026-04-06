import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        /*
            문제를 조금 쪼개자. 우선 모두 다른 문자열일 때 규칙성이 있다.
            길이 1->1, 2->2+1, 3->3+2+1, 4->4+3+2+1, 5->5+4+3+2+1
            문제는 같은 문자열이 있는 경우다. 이 경우 중복의 수가 매우 다양해서
            최대한 수학적으로 풀어보고 싶지만 한계가 있어보인다.

            bruteforce하게 접근하면 모든 경우를 set에 넣어 중복을 제거해버리면 된다.
            사실 더 생각해보고 싶지만 졸리기에 하자
        */
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        int n = text.length();

        Set<String> hub = new HashSet();

        for(int i=1; i<=n; i++){//뭉텡이 길이
            for(int j=0; j<n-i+1; j++){//시작 인덱스
                hub.add(text.substring(j, j+i));//끝인덱스 미포함
            }
        }

        System.out.println(hub.size());
        sc.close();
    }
}