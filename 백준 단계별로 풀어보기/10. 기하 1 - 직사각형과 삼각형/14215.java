import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        final int MAX = 3;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] list = new int[MAX];
        for(int i=0; i<MAX; i++)
            list[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(list);
        // 삼각형의 조건은 빗변의 길이가 다른 두 변의 합보다 작아야 한다는 것이다.
        // 작은 두 막대의 합에 2배하고 1 빼면 된다.
        int small_sum = list[0]+list[1];
        int result;
        //이미 조건을 만족한다면
        if(small_sum > list[2]){
            result = small_sum + list[2];
        } else {
            result = small_sum * 2 - 1;
        }
        System.out.println(result);
        br.close();
    }
}