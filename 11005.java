import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int number = Integer.parseInt(st.nextToken());
        int std = Integer.parseInt(st.nextToken());

        if (number == 0) {
            System.out.println("0");
            return;
        }

        StringBuilder sb = new StringBuilder();
        while(number>0){
            int remainer = number%std;
            if(remainer<10)
                sb.append(remainer);
            else
                sb.append((char)(remainer-10+'A'));
            number/=std;
        }

        System.out.println(sb.reverse().toString());
        br.close();
    }
}