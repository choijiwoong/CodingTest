import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int price;
        int[] list = {25,10,5,1};
        while(n-- > 0){
            price = Integer.parseInt(br.readLine());
            for(int i=0; i<list.length; i++){
                bw.write(price/list[i]+" ");
                price%=list[i];
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}