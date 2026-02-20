import java.lang.*;
import java.util.*;
import java.io.*;

class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int depth = Integer.parseInt(br.readLine());
        System.out.println(depth*4);
        br.close();
    }
}