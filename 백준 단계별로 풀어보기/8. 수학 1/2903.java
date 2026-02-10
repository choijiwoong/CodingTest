import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int side = (1<<n) +1;
        System.out.println(side*side);
        sc.close();
    }
}