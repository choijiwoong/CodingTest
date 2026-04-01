import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        /*
            n개로 집합을, m개로 포함여부.
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> dic = new HashSet<>();
        for(int i=0; i<n; i++)
            dic.add(br.readLine());

        int result=0;
        for(int i=0; i<m; i++)
            if(dic.contains(br.readLine()))
                result++;

        System.out.println(result);

        bw.close();
        br.close();
    }
}