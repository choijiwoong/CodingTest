import java.lang.*;
import java.util.*;
import java.io.*;

class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int depth = Integer.parseInt(br.readLine());
        // 이때 depth의 범위가 10^9승으로 10억. int는 약 20억까지 된다.
        // 하지만 4배를 하면 범위가 초과되기에 버퍼 오버플로우가 발생할 것이다.
        // 4에 L을 붙여 Long으로 변환시켜보자.
        System.out.println(depth*4L);
        br.close();
    }
}