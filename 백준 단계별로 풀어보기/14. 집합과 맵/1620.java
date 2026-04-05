import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        /*
            도감 포켓몬 개수 N, 문제의 개수 M. (N,M >=1)
            포켓몬 이름은 첫글자만 대문자. 일부 포켓몬은 마지막 문자만 대문자
            최대 이름 길이 20, 최소 2.

            문제가 이름으로 오면 번호를, 숫자로 오면 이름을 출력.

        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, String> int_to_string = new HashMap();
        Map<String, Integer> string_to_int = new HashMap();
        for(int i=1; i<=N; i++){
            String tmp = br.readLine();
            int_to_string.put(i, tmp);
            string_to_int.put(tmp, i);
        }

        for(int i=0; i<M; i++){
            String prob_tmp = br.readLine();
            int num;

            if(48<=prob_tmp.charAt(0) && prob_tmp.charAt(0)<=57)
                bw.write(int_to_string.get(Integer.parseInt(prob_tmp)));
            else
                bw.write(String.valueOf(string_to_int.get(prob_tmp)));

            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}