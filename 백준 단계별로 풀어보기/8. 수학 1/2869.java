import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());


        int day;
        if (a==v)//안하면 아래 division by zero뜸.
            day=1;
        else
            day = ((v-a)/(a-b)<1?1:(v-a)/(a-b) )+1;

        System.out.println(day);
        br.close();
    }
}