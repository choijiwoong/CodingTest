import java.lang.*;
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String input = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        int result=0;
        int multiplier = 1;

        for(int i=input.length()-1; i>=0; i--){
            char c= input.charAt(i);
            int value;
            if(c>='0' && c<='9')
                value = c-'0';
            else
                value = c-'A'+10;
            result+=value*multiplier;
            multiplier*=B;
        }
        System.out.println(result);
        br.close();
    }
}