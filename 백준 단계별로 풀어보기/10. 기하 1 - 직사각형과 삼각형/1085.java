import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int width, height;
        if(w/2-x < 0)
            width = w-x;
        else
            width = x;

        if(h/2-y < 0)
            height = y-h;
        else
            height = y;

        System.out.println(Math.abs(height<width?height:width));
        br.close();

    }
}