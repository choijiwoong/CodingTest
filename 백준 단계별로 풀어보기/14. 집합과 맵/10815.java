import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        /*
            숫자맞추기.
            정수 배열 2개에서 일치하면 1을 아니면 0을. 배열1을 기준으로 배열2가 배열1의 숫자인지 계산.

            중복은 필요없으니 Set에 넣고 contains로 비교
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n1 = Integer.parseInt(br.readLine());

        Set<Integer> set1 = new HashSet();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n1; i++)
            set1.add(Integer.parseInt(st.nextToken()));

        int n2 = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n2; i++){
            int num = Integer.parseInt(st.nextToken());
            if(set1.contains(num))
                sb.append("1 ");
            else
                sb.append("0 ");
        }

        System.out.println(sb);
        bw.close();
        br.close();
    }
}