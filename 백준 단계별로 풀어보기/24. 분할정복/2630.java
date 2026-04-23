import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[][] arr;
    static int white_count = 0, blue_count = 0;

    public static void calc_func(int x, int y, int size){
        int sum=0;
        for(int i=0; i<size; i++)
            for(int j=0; j<size; j++)
                sum+=arr[x+i][y+j];

        if(sum==0){
            white_count++;
            return;
        } else if(sum==size*size){
            blue_count++;
            return;
        }

        int half_size = size/2;

        for(int i=0; i<2; i++)
            for(int j=0; j<2; j++)
                calc_func(x+half_size*i, y+half_size*j, half_size);
    }

    public static void main(String[] args) throws IOException{
        /*
            변의 길이 N(2, 4, 8, 16, 32, 64, 128 중 하나.). 파란색으로 칠해진 칸을 1로 주어짐.
            다양한 크기의 색종이를 만들거임. 모두 같은색이 아니라면 2/N으로 잘라 4개의 종이로 만듬.
            이렇게 반복하는 행위를 잘려진 색종이가 모두 같은 색이 될 때 까지 반복.
            이 때, 최종 개수를 구하면 됨.

            전략부터 세워보자. 우선 전부 배열에 저장. 해봐야 128x128이니.
            이 때 생각할건 딱 하나.
            큰 네모가 같은색일 경우를 종료조건, 아닐 때 잘라서 재귀.
            재귀하려면 인수로 정보를 전달해야하는데 확실하게 i1 i2 j1 j2 넣어야하나.
            변 크기랑 시작점만 있으면 될 듯. 좌측상단을 시작점으로 고정.
            재귀는 종료조건을 무조건 만족할 수 밖에 없는게 나중엔 1x1로 될거라 별다른 처리는 x
            편하게 전체 배열은 스태틱으로.

            분할정복 섹션이기에 알아둘 개념은 분할적용가능하면 맨 처음 상태에서부터 적용하여 일반화하여 해결.
        */
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        calc_func(0,0,n);

        System.out.println(white_count);
        System.out.println(blue_count);
        br.close();
    }
}