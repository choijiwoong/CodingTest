import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer inputs = new StringBuffer();
        String curr;
        while((curr = br.readLine())!=null){
            inputs.append(curr);
            inputs.append('\n');
        }
        String[] input = inputs.toString().split('\n');
        int max_cols = input[0].length;
        char[][] data;
        for(int i=0; i<input.length; i++){
            data[i] = input[i].toCharArray();
        }

        for(int i=0; i<max_cols; i++){
            for(int j=0; j<data.length; j++){
                bw.write(data[j][i]);
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}