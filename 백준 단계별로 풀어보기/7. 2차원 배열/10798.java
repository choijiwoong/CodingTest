import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer inputs = new StringBuffer();

        // 1. 여러 줄 입력 받기
        String curr;
        while((curr = br.readLine())!=null){
            inputs.append(curr);
            // 각 줄을 .으로 구분
            inputs.append(".");
        }
        //2. 최대 길이의 열 찾기
        String[] input = inputs.toString().split("\\.");
        int N = input.length;// 입력 줄 개수
        int max_cols=0;
        for(int i=0; i<N; i++){
            // 각 줄별 col 계산
            int cols = input[i].length();
            if(cols > max_cols)
                max_cols = cols;
        }
        //3. 최대 길이 기준으로 열 크기 맞추기
        for(int i=0; i<N; i++){
            if(input[i].length()<max_cols){
                input[i]+=".".repeat(max_cols-input[i].length());
            }
        }
        //4. 인덱스 기반 역순 출력하기
        for(int i=0; i<max_cols; i++){
            for(int j=0; j<N; j++){
                if(input[j].charAt(i) != '.'){
                    bw.write(String.valueOf(input[j].charAt(i)));
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}