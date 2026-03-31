import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        /*
            나이 오름차순, 나이 같으면 먼저 입력된 순
            입력크기는 100,000 이하.
            1<=나이<=200
            이름 영어소문자, 길이 100이하.
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String[] names = new String[n];
        int[] ages = new int[n];
        Integer[] idxs = new Integer[n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            ages[i] = Integer.parseInt(st.nextToken());
            names[i] = st.nextToken();
            idxs[i] = i;
        }

        Arrays.sort(idxs, (i,j)->{
            if(ages[i]!=ages[j])
                return ages[i]-ages[j];
            else
                return i-j;
        });

        for(int i=0; i<n; i++){
            bw.write(String.valueOf(ages[idxs[i]]));
            bw.write(" ");
            bw.write(names[idxs[i]]);
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}