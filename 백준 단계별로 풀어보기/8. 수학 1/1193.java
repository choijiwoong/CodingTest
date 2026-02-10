import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int level, offset;
        for(level=1; level*(level+1)/2 < n; level++){}
        offset = level*(level+1)/2 - n;

        int up, down;
        if(level%2!=0){
            up = 1 + offset;
            down = level - offset;
        } else{
            up = level - offset;
            down = 1 + offset;
        }

        System.out.println(up+"/"+down);
        sc.close();
    }
}