import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        /*
            CLI를 설계하면 된다. 각 기능을 하나씩 구현해보자.
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Integer> stack = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());
        while(n-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n1 = Integer.parseInt(st.nextToken());
            int n2 = -1;
            if(n1==1)
                n2 = Integer.parseInt(st.nextToken());

            switch(n1){
                case 1:
                    stack.push(n2);
                    break;
                case 2:
                    if(!stack.isEmpty())
                        bw.write(String.valueOf(stack.pop()));
                    else
                        bw.write("-1");

                    bw.newLine();
                    break;
                case 3:
                    bw.write(String.valueOf(stack.size()));
                    bw.newLine();
                    break;
                case 4:
                    if(!stack.isEmpty())
                        bw.write("0");
                    else
                        bw.write("1");
                    bw.newLine();
                    break;
                case 5:
                    if(!stack.isEmpty())
                        bw.write(String.valueOf(stack.peek()));
                    else
                        bw.write("-1");
                    bw.newLine();
                    break;
                default:
                    bw.write("ERROR");
                    bw.newLine();
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}