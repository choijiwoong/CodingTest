import java.lang.*;
import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = sc.nextInt();//5
        for(int i=0; i<N; i++){
            for(int j=N-1; j>i; j--)
                bw.write(" ");
            for(int j=1; j<=1+2*i; j++)
                bw.write("*");
            bw.newLine();
        }
        for(int i=0; i<N-1; i++){
            for(int j=0; j<i+1; j++)
                bw.write(" ");
            for(int j=2*N-3; j>2*i; j--)
                bw.write("*");
            bw.newLine();
        }
        bw.flush();
        bw.close();
        sc.close();
    }
}