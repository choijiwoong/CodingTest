import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        /*
            듣x 수 n, 보x 수 M
            듣보 수와 명단 사전순 출력

            Collection 2개 만들어 저장 후 겹치는 항목만 사전순 출력해야한다.
            중복은 차피 없다.

            어라? 만약 초기 두 입력에 중복이 없다면
            둘을 아까처럼 그냥 Map에 넣어두고 count를 같이 저장.
            그 후 count2인 값만 출력하면 된다.

            이 때 정렬이 필요하니 TreeMap을 사용해보자.
            키값 기준 정렬이어야 한다. 기본으로 키 오름차순이라고 한다.
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> count_map = new TreeMap();
        for(int i=0; i<n+m; i++){
            String name = br.readLine();
            if(count_map.containsKey(name))
                count_map.replace(name, count_map.get(name)+1);
            else
                count_map.put(name, 1);
        }

        // 결과 개수가 먼저 나와야 하기에 StringBuilder사용
        StringBuilder sb = new StringBuilder();
        int result_count = 0;
        for(Map.Entry<String, Integer> entry: count_map.entrySet()){
            String key = entry.getKey();
            int value = entry.getValue();
            if(value==1)
                continue;

            result_count++;
            sb.append(key);
            sb.append('\n');
        }
        sb.insert(0, result_count+"\n");
        System.out.println(sb);
        //bw.write(sb.toString());
        //bw.flush();
        //bw.close();
        br.close();
    }
}