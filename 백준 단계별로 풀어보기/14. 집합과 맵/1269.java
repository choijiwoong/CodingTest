import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        /*
            차집합 개수를 구해야한다.
            집합A 3개, 집합B 5개, 중복 2개일 경우
            차집합 개수 A = 3-2=1, B = 5-2=3
            즉, 전체 A B 원소 개수 합에서 중복 개수를 2번 빼면 된다.
            List를 만들고 size에서 Set변환시 size로 중복 개수 구해서 계산하자.
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());

        Set<Integer> set = new HashSet();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n1; i++)
            set.add(Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n2; i++)
            set.add(Integer.parseInt(st.nextToken()));

        System.out.println(n1+n2-2*(n1+n2-set.size()));
        //bw.flush();
        //bw.close();
        br.close();
    }
}