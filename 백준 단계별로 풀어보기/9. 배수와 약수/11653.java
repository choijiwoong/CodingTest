import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        if(num==1){

        } else if (num<=3){
            bw.write(String.valueOf(num));
        } else{
            for(int i=2; i<=num; i++){
                while(num%i==0){
                    num/=i;
                    bw.write(String.valueOf(i));
                    bw.newLine();
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}