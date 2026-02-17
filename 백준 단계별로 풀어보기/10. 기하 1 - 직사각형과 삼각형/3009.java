import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static int get_distance_multiple(int x1, int y1, int x2, int y2){
        return (x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);
    }

    public static void main(String[] args) throws IOException{
        int SIZE = 3;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] xs = new int[SIZE];
        int[] ys = new int[SIZE];
        for(int i=0; i<SIZE; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            xs[i] = Integer.parseInt(st.nextToken());
            ys[i] = Integer.parseInt(st.nextToken());
        }
        //피타고라스로 직각점을 구한 후, 다른 두 점의 중점으로부터 xy대칭

        for(int i=0; i<SIZE; i++){
            int point2_x = xs[(i+1)%SIZE];
            int point2_y = ys[(i+1)%SIZE];
            int point3_x = xs[(i+2)%SIZE];
            int point3_y = ys[(i+2)%SIZE];
            int sum_right_sides = get_distance_multiple(xs[i],ys[i], point2_x, point2_y)
                    + get_distance_multiple(xs[i], ys[i], point3_x, point3_y);
            if(sum_right_sides == get_distance_multiple(point2_x, point2_y, point3_x, point3_y)){
                int mid_x = (point2_x+point3_x)/2;
                int mid_y = (point2_y+point3_y)/2;
                int result_x, result_y;
                if(mid_x<xs[i])
                    result_x = mid_x - (xs[i]-mid_x);
                else
                    result_x = mid_x + (mid_x-xs[i]);
                if(mid_y<ys[i])
                    result_y = mid_y - (ys[i]-mid_y);
                else
                    result_y = mid_y + (mid_y-ys[i]);
                StringBuilder sb = new StringBuilder();
                sb.append(result_x);
                sb.append(" ");
                sb.append(result_y);
                System.out.println(sb);
                break;
            }
        }

    }
}