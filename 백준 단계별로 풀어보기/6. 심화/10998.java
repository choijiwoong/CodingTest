import java.lang.*;
import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String original = br.readLine();
        String reversed = new StringBuilder(original).reverse().toString();
        System.out.println(original.equals(reversed)?1:0);
        br.close();
    }
}