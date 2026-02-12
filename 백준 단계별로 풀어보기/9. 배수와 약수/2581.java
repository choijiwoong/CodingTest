import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    private static boolean is_prime(int n){
        if(n<2)
            return false;
        if(n==2)
            return true;
        if(n%2==0)
            return false;
        for(int i=2; i*i<=n; i++)
            if(n%i==0)
                return false;
        return true;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int min_prime=-1, sum_prime=0;
        for(int i=N; i>=M; i--){
            if(is_prime(i)){
                min_prime=i;
                sum_prime+=i;
            }
        }
        if(min_prime!=-1)
            System.out.println(sum_prime);
        System.out.println(min_prime);
        br.close();
    }
}