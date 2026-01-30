import java.lang.System;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        float result=0;
        int max = 0;
        for(int i=0; i<N; i++){
            int score = Integer.parseInt(st.nextToken());
            result+=score;
            if (max<score)
                max = score;
        }
        //  a b c, 100*(a + b + c)/(3*m)
        result = 100*result/(N*max);
        System.out.println(result);
        br.close();
    }
}