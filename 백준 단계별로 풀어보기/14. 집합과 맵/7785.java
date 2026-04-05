import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        /*
            여행가서 무지성 코딩한거라 설명은 생략.
            현재 TLE가 발생한다. 사실 leave가 있는 것은 저장할 필요가 없긴 하다.
            sort는 어차피 한번은 필요하기에 collections에 add하고 remove하는 부분에서
            최적화가 필요해보인다.

            우선 문자열 비교해서 최적화를 해보자. String비교가 아닌 Char로 앞자리 비교하자.
            여전히 TLE가 발생한다.

            아니면 Tree에 넣어서 저장과 동시에 배열시켜 정렬 코드를 최소화 하면 어떨까?
            TreeSet은 레드-블랙 트리 구조로, 내림차순 정렬 시 생성자로 커스텀한 Comparator를 전달하면 되낟.

            통과! 확실히 collection add remove는 필수적이었다.
            앞으로도 정렬이 필요하면 Tree구조를 이용해보자.
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        //List<String> dic = new ArrayList();
        // 최적화 2: 트리를 이용해 저장과 동시에 정렬
        TreeSet<String> dic = new TreeSet<>(Collections.reverseOrder());

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String status = st.nextToken();

            // 최적화 1: String비교 char비교로 변경
            if(status.charAt(0)=='e'){
                dic.add(name);
            } else{
                dic.remove(name);
            }
        }

        //Collections.sort(dic, (a,b)->b.compareTo(a));
        for(String name : dic){
            bw.write(name);
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}