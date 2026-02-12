import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int input;
        StringBuilder sb = new StringBuilder();
        while((input=Integer.parseInt(br.readLine())) != -1){
            bw.write(String.valueOf(input));
            int sum=0;

            for(int i=1; i<input; i++){
                if(input%i==0){
                    sb.append(i+" + ");
                    sum+=i;
                }
            }
            if(sum!=input){
                bw.write(" is NOT perfect.");
            } else {
                bw.write(" = ");
                sb.delete(sb.length()-3, sb.length());
                bw.write(sb.toString());
            }
            sb.setLength(0);
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}