import java.lang.*;
import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result=0;

        for(int i=0; i<N; i++){
            if(isGroupWord(br.readLine()))
                result++;
        }
        System.out.println(result);
        br.close();
    }

    public static boolean isGroupWord(String str){
        boolean[] is_exist=new boolean[26];
        char[] input = str.toCharArray();
        char prev = ' ';
        for(int i=0; i<input.length; i++){
            char curr = input[i];
            if(prev!=curr && is_exist[curr-'a'])
                return false;
            is_exist[curr-'a']=true;
            prev = curr;
        }
        return true;
    }
}