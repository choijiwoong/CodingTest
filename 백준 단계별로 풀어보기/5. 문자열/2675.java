import java.lang.System;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.lang.StringBuilder;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int repeat = Integer.parseInt(st.nextToken());
            char[] target = st.nextToken().toCharArray();
            for(int j=0; j<target.length; j++)
                for(int r=0; r<repeat; r++)
                    sb.append(target[j]);
            bw.write(sb.toString()+"\n");
            sb.setLength(0);
        }
        bw.flush();
        br.close();
        bw.close();

    }
}