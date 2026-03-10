import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        /*
            연립방정식 풀기. 유일해 존재. 입력은 -900~+900.
            x = (c-by)/a (a==0제외)
            y = (f-dx)/e (e==0제외)
            x = {c-b(f-dx)/e}/a
            x = (c-bf+dbx)/e/a
            eax = c-bf+bdx
            (ea-bd)x = c-bf
            x = (c-bf)/(ea-bd)
            y = {f-d(c-bf)/(ea-bd)}/e

            만약 a==0 && e==0이라면?
            by = c
            y = c/b
            dx = f
            x = f/d

            만약 a==0 && e!=0이면?
            y=c/b
            x = 0

            만약 a!=0 && e==0이면?
            x = f/d
            y = 0
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        int x,y;
        if(a==0 && e==0){
            x=f/d;
            y=c/b;
        } else if(a!=0 && c==0){
            y=0;
            x=f/d;
        } else if(a==0 && c!=0){
            x=0;
            y=c/b;
        } else{
            x = (c-b*f)/(e*a-b*d);
            y = (f-d*(c-b*f)/(e*a-b*d))/e;
        }
        bw.write(String.valueOf(x));
        bw.write(" ");
        bw.write(String.valueOf(y));
        bw.flush();
        bw.close();
        br.close();
    }
}