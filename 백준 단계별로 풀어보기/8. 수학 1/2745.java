import java.lang.*;
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String input = st.nextToken();
        int B = Integer.parseInt(st.nextToken());
        char[] array = input.toCharArray();
        int length = array.length;
        int result=0;
        for(int i=0; i<length; i++){
            char c = array[length-1-i];
            if (c>='0' && c<='9'){
                result+=Math.pow(B, i)*(c-'0');
            } else if (c>='A' && c<='Z'){
                result+=Math.pow(B, i)*(c-'A'+10);
            }
        }
        System.out.println(result);
        br.close();
    }
}