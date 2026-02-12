import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int result = 0;

        for(int i=1; i<=a; i++){
            if(a%i==0)
                b--;
            if(b==0){
                result = i;
                break;
            }
        }
        System.out.println(result);
        br.close();
    }
}