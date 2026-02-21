import java.lang.*;
import java.util.*;
import java.io.*;

class Main{
    public static void main(String args[]) throws IOException{
        int MAX = 100001;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        if(length==1){
            System.out.println("0");
            return;
        }
        int min_x=MAX, min_y=MAX, max_x=-MAX, max_y=-MAX;
        while(length-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(min_x > x)
                min_x = x;
            if(min_y > y)
                min_y = y;
            if(max_x < x)
                max_x = x;
            if(max_y < y)
                max_y = y;
        }
        // 이 때 좌표는 음수일수도, 양수일수도 있다. 하지만 큰 값을 기준으로 빼기에 무조건 양수이기에 별도로 고려하지 않는다.
        // 한 변은 최대 20,000까지 가능하기에 result는 400,000,000 4억까지 가능하다. int로 담을 수 있다.(약20억)
        int result = (max_x-min_x)*(max_y-min_y);
        System.out.println(result);
        br.close();
    }
}