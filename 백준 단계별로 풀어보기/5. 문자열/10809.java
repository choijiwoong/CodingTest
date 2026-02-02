import java.lang.System;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        int N = 'z'-'a'+1;
        int[] position = new int[N];
        for(int i=0; i<N; i++)
            position[i]=-1;
        char[] input = sc.next().toCharArray();
        for(int i=input.length-1; i>=0; i--){
            position[input[i]-'a']=i;
        }
        for(int i=0; i<N; i++)
            bw.write(position[i]+" ");
        bw.flush();
        bw.close();
    }
}