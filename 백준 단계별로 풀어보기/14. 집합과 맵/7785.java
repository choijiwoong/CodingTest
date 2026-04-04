import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<String> dic = new ArrayList();

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String status = st.nextToken();

            if(status.equals("enter")){
                dic.add(name);
            } else{
                dic.remove(name);
            }
        }

        Collections.sort(dic);
        Collections.reverse(dic);
        for(String name : dic){
            bw.write(name);
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}