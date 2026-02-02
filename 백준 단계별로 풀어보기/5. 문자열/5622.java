import java.lang.*;
import java.util.*;
import java.io.IOException;

class Main{
    public static void main(String[] args) throws IOException{
        int total_time = 0;
        int c;

        while ((c = System.in.read()) >= 'A') {
            if (c <= 'C') total_time += 3;
            else if (c <= 'F') total_time += 4;
            else if (c <= 'I') total_time += 5;
            else if (c <= 'L') total_time += 6;
            else if (c <= 'O') total_time += 7;
            else if (c <= 'S') total_time += 8;
            else if (c <= 'V') total_time += 9;
            else if (c <= 'Z') total_time += 10;
        }
        System.out.println(total_time);
    }
}