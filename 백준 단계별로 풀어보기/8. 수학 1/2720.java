import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    private static final int[] COINS = {25,10,5,1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        while(n-- > 0){
            int price = Integer.parseInt(br.readLine());
            for(int coin : COINS){
                sb.append(price/coin).append(" ");
                price%=coin;
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}