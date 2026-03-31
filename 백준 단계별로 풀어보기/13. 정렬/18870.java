import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        /*
            수들 중 밑에서 몇번째인지 출력(0부터 시작)
            수는 1,000,000이하 자연수이나
            개수가 2,000,000,000 20억개일 수 있다.
            int 범위는 -21억~21억. 가능.

            결국 중복제거 오름차순의 인덱스 출력임.
            걸리는건 탐색인데, 입력을 모두 중복없이 정렬한 뒤 다시 앞에서부터 몇번째 인덱스인지 전부 탐색해서 찾아야 한다.

            일단 작성해보고 최적화를 고민해보자.
            중복 된 값을 저장하고 싶지 않은데, 해당하는 값에 대해 다 출력을 해야하니 어쩔 수 없을 듯 하다.

            TLE가 발생했다. 문제 힌트로는 대소관계만 필요하니 모든 수를 0~N미만의 촘촘한 수로 바꿔보라 한다.

        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for(int i=0; i<n; i++)
            nums[i] = Integer.parseInt(st.nextToken());

        // Arrays.stream().distinct()는 편리하지만 대량의 데이터에선 느리다.
        // 3번째 방법인 HashMap을 사용하며, put 시에 containsKey()를 활용해 중복을 제거하는게 좋다.
        int[] deduplicated_nums = Arrays.stream(nums).distinct().toArray();

        Arrays.sort(deduplicated_nums);

        // 1. 내가 사용한 O(n^2) 방법, TLE 발생.
        // for(int i=0; i<n; i++){
        //     for(int j=0; j<deduplicated_nums.length; j++){
        //         if(nums[i]==deduplicated_nums[j]){
        //             bw.write(String.valueOf(j));
        //             bw.write(" ");
        //         }
        //     }
        // }

        // 2. 이미 정렬된 배열을 탐색할 경우 이진탐색 함수를 이용해 인덱스를 알아낼 수 있다. O(logN)
        for(int i=0; i<n; i++)
            bw.write(Arrays.binarySearch(deduplicated_nums, nums[i])+" ");

        // 3. 정렬된 인덱스를 값으로 찾을 수 있는 해시맵(딕셔너리)에 넣고 nums를 .get인덱스로 호출
        // Map<Integer, Integer> map = new HashMap<>();
        // for(int i=0; i<deduplicated_nums.length; i++)
        //     map.put(deduplicated_nums[i], i);
        // for(int i=0; i<n; i++)
        //     bw.write(map.get(nums[i])+" ");

        bw.flush();
        bw.close();
        br.close();
    }
}