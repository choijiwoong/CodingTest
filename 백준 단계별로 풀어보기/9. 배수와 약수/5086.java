import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(String temp=br.readLine(); temp!=null; temp=br.readLine()){
            StringTokenizer st = new StringTokenizer(temp);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a==0 || b==0)
                break;
            else if(a%b==0)
                bw.write("multiple");
            else if(b%a==0)
                bw.write("factor");
            else
                bw.write("neither");
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}