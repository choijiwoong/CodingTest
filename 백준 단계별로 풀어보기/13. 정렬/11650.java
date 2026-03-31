import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] xs = new int[n];
        int[] ys = new int[n];
        //Arrays.sort()의 comparator에는 객체타입(원시타임x)만 받을 수 있다.
        Integer[] idxs = new Integer[n];

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            xs[i] = Integer.parseInt(st.nextToken());
            ys[i] = Integer.parseInt(st.nextToken());
            idxs[i] = i;
        }

        //Arrays.sort()는 람다를 이용해 기준을 전달 가능하다.
        //x를 기준으로 idxs 정렬
        //y를 기준으로 x 중복에 한해 idxs 정렬
        Arrays.sort(idxs, (i, j)->{
            if(xs[i]!=xs[j])
                return xs[i]-xs[j];
            else
                return ys[i]-ys[j];
        });

        //idxs순서대로 출력
        for(int i : idxs){
            bw.write(String.valueOf(xs[i]));
            bw.write(" ");
            bw.write(String.valueOf(ys[i]));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}