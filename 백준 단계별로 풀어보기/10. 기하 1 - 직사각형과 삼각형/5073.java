import java.lang.*;
import java.util.*;
import java.io.*;

class Main{
    static final int MAX = 3;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        String message;
        while(true){
            line = br.readLine();
            if(line.equals("0 0 0"))
                break;
            StringTokenizer st = new StringTokenizer(line);
            int[] list = new int[MAX];
            for(int i=0; i<MAX; i++)
                list[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(list);

            if(list[2]>=list[1]+list[0])
                message = "Invalid";
            else if(list[0]==list[1] && list[1]==list[2])
                message = "Equilateral";
            else if(list[0]!=list[1] && list[1]!=list[2])
                message = "Scalene";
            else
                message = "Isosceles";

            System.out.println(message);
        }
// 이 번호 맞나? 여튼 삼각형 최대 조건이려면 긴변 =두변 합+1이어야할거임. 
        br.close();
    }
}