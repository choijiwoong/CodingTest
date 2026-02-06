import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 5, M = 15;
        char[][] array = new char[N][M];

        for(int i=0; i<N; i++){
            String line = br.readLine();
            if (line == null) break;

            for(int j=0; j<line.length(); j++)
                array[i][j]=line.charAt(j);
        }

        StringBuilder sb = new StringBuilder();
        for(int j=0; j<M; j++){
            for(int i=0; i<N; i++){
                if(array[i][j] == '\0')
                    continue;
                sb.append(array[i][j]);
            }
        }
        System.out.println(sb.toString());
        br.close();
    }
}