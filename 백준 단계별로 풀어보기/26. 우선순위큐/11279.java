import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        /*
            최대 힙은 내가 기억하기로.. 트리..이진정렬트리였던거로 기억한다. max가 알아서 위에 오는.. 우선순위큐도 어렴풋이 생각나는데..
            자연수가 들어오면 add 0이 들어오면 가장 큰 값을 출력하고 제거.
            비어있으면 0 출력.

            잠시 개념 블로그 탐색.
            Heap: 완전 이진 트리로, 최대/최소 값을 빠르게 찾아내는 데 유용한 자료구조로 중복을 허용한다. 형제 간 정렬은 보장하지 않는 반 정렬 상태
            최소/최대 힙: 루트 노드가 최소/최대값으로 트리 말단에 데이터 삽입 후, 부모과 비교하며 교체하는 것을 반복.

            자바의 우선순위 큐 자료구조를 이용할 수 있다. Queue와 비슷하지만 선입 선출이 아닌 크기값이라는 우선순위로 사용가능하다.

            자연수는 2^31 이하. 21억. int로 처리가능하다.

            잠시 개념 정리.
            add()는 큐의 맨 뒤에 추가(용량넘치면 예외)
            offer()는 큐의 맨 뒤에 추가(용량넘치면 false)
            push()는 큐의 맨 앞에 추가(구현제마다 다름)

            poll()은 큐의 맨 앞 꺼내며 제거(비면 null반환)
            remove()는 큐의 맨 앞 꺼내며 제거(비면 예외 발생)

            데이터 확인
            peek()은 맨앞확인(비면 null반환)
            element()는 맨앞확인(비면 예외발)

            정리: 가급적 offer, poll, peek을 사용하여 null처리로 통일하자.
            Queue는 push가 없고, Deque에만 있다.

            기본 PriorityQueue는 최소힙이므로 최대힙사용 시 Collections.reverseOrder()넣어줘야한다.
        */
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Integer> max_heap = new PriorityQueue<>(Collections.reverseOrder());//기본 오름차순이라 거꾸로해줘야함

        int n = Integer.parseInt(br.readLine());
        while(n-->0){
            int i = Integer.parseInt(br.readLine());

            if(i==0){
                if(!max_heap.isEmpty())
                    bw.write(String.valueOf(max_heap.poll()));
                else
                    bw.write("0");

                bw.newLine();
            } else {
                max_heap.add(i);
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}