import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        /*
            N개의 상근이 카드 개수
            N개의 정수 입력
            M개의 구해야할 정수 개수
            M개의 정수 입력

            M 정수에 대해 상근이가 몇개 가지고 있는지 출력.
            이거.. 각 수 별로 중복 제거한 값을 저장하고 해당 값 별로 count를 ++해야할 듯 한데

            map으로 하는게 관리하긴 편할 듯 하다.
            map<int, int>로 해서 containsKeys인지 확인하고 있으면 value+1, 없으면 value=0으로 삽입 후 탐색.

            사실 count를 배열을 이용해서 별도로 관리하거나
            map에서의 원리를 그냥 배열 크게 때려서 index해당 숫자로 value를 찾는 법도 있겠지만
            전자는 동적할당 해야할 것 같고(숫자 카드 개수 최대 500,000이라 힘들거같음)
            후자는 숫자 범위가 -10억~+10억이기에 map이 좋을 것 같다.

            map에도 여러 종류가 있을까?
            일반적으로 사용하는 HashMap외에도
            순서보장 LinkedHashMap
            정렬 TreeMap
            레거시 Hashtable
            고성능동시성 CurrentHashMap
            약한참조 WeakHashMap
            참조동등성 IdentityHashMap
            Enum전용 EnumMap
            등이 있다.

            복잡도 O(log n) TreeMap을 제외하고 나머지 다 O(1)이다.
            HashMap을 우선 사용해보고 TLE나 MLE가 발생하면 다른 구현체로 접근해보자.
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Map<Integer, Integer> dic = new HashMap();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());

            // 키 값 확인 여부는 아래처럼
            if(dic.containsKey(num)){
                dic.replace(num, dic.get(num)+1);
            } else{
                // 일단 하나가 나왔단 거니 1로 초기화
                dic.put(num, 1);
            }
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            int num = Integer.parseInt(st.nextToken());
            // 널일 경우 옵셔널로 받기
            Optional<Integer> value = Optional.ofNullable(dic.get(num));
            bw.write(String.valueOf(value.orElse(0)));
            bw.write(" ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}