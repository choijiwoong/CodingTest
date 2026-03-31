import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] dic = new String[n];
        for(int i=0; i<n; i++)
            dic[i] = br.readLine();

        Arrays.sort(dic, (s1, s2)->{
            if(s1.length()!=s2.length())
                return s1.length() - s2.length();
            else
                return s1.compareTo(s2);
        });
        for(int i=0; i<n; i++){
            if(i>0 && dic[i-1].equals(dic[i]))
                continue;
            bw.write(dic[i]);
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}