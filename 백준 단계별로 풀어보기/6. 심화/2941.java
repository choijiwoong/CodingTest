import java.lang.*;
import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] set = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        for(int i=0; i<set.length; i++)
            input = input.replace(set[i], "#");

        System.out.println(input.length());
        br.close();
    }
}