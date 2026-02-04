import java.lang.*;
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line;
        StringTokenizer st;
        int row=0, col=0, max=0, curr, max_row=0, max_col=0;
        while((line = br.readLine()) != null){
            st = new StringTokenizer(line);

            while(st.hasMoreTokens()){
                curr = Integer.parseInt(st.nextToken());
                if(max<curr){
                    max=curr;
                    max_row=row;
                    max_col=col;
                }
                col++;
            }
            row++;
            col=0;
        }
        bw.write(String.valueOf(max));
        bw.newLine();
        bw.write(String.valueOf(max_row+1));
        bw.write(" ");
        bw.write(String.valueOf(max_col+1));
        bw.flush();
        br.close();
        bw.close();
    }
}