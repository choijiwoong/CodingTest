import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int number = Integer.parseInt(st.nextToken());
        int std = Integer.parseInt(st.nextToken());
        if(number==0){
            System.out.println(0);
            return;
        }

        long multiplier = 1;
        while(number/multiplier>=1)
            multiplier *= std;
        multiplier/=std;

        StringBuilder sb = new StringBuilder();
        for(;multiplier>0; multiplier/=std){
            long value = number/multiplier;
            if(value>=1 && value<=9)
                sb.append(String.valueOf(value));
            else if(value>=10)
                sb.append((char)(value-10+'A'));
            else
                sb.append("0");
            number%=multiplier;
        }
        System.out.println(sb.toString());
        br.close();
    }
}