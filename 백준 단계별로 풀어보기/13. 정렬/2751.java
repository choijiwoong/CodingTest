import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void selection_sort(int[] arr, int n){
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(arr[i]>arr[j]){
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    public static void insertion_sort(int[] arr, int n){
        for(int i=1; i<n; i++){
            int key = arr[i];
            int j=i-1;
            while(j>=0 && arr[j]>key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }

    public static void quick_sort(int[] arr, int low, int high){
        if(low<high){
            int pivotIdx = partition(arr, low, high);
            quick_sort(arr, low, pivotIdx-1);
            quick_sort(arr, pivotIdx+1, high);
        }
    }

    private static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        //작은값들의 기준점
        int i = low-1;
        for(int j=low; j<high; j++){//high는 차피 pivot이니 앞까지
            if(arr[j]<pivot){//pivot보다 작은 값 발견 시 작은값들의 기준점을 이용하여 swap
                i++;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        //위 과정이 완료되면, i는 pivot보다 작은 값 중 가장 큰 값을 가리키게 됨. 즉 i+1이 pivot위치
        int tmp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = tmp;
        //목적은 결국 pivot값을 반환하여 다음 재귀 때 써야하므로 i+1을 리턴
        return i+1;
    }

    public static void merge_sort(int[] arr, int left, int right){
        if(left<right){
            int mid = left+(right-left)/2;
            merge_sort(arr, left, mid);//mid를 left가 포함하게 통일
            merge_sort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right){
        // 왼쪽&오른쪽 그룹의 배열 사이즈 크기 계산
        int n1 = mid-left+1;//mid를 left가 포함하게 통일하니 +1
        int n2 = right-mid;

        // 임시 배열 생성
        int[] L = new int[n1];
        int[] R = new int[n2];

        // arr에서 해당되는 범위의 값을 임시 배열에 저장
        for(int i=0; i<n1; i++)
            L[i] = arr[left+i];
        for(int i=0; i<n2; i++)
            R[i] = arr[mid+1+i];

        int i=0, j=0, k=left;//왼쪽 배열 인덱스, 오른쪽 배열 인덱스, 실제 배열 인덱스
        while(i<n1 && j<n2){
            if(L[i]<=R[j]){
                arr[k]=L[i];
                i++;
            } else{
                arr[k]=R[j];
                j++;
            }
            k++;
        }

        while(i<n1)
            arr[k++] = L[i++];
        while(j<n2)
            arr[k++] = R[j++];
    }

    public static void heap_sort(int[] arr, int n){
        // 배열의 절반 뒤쪽은 모두 자식노드를 저장하는 목적으로 사용하며,
        // 배열로 트리를 나타내기 위해 i노드의 자식을 i*2+1이 왼쪽, i*2+2에 오른쪽을 저장한다.
        // 이때 마지막 부모노드의 자식을 담으려면 2칸이 더 필요하므로 부모노드는 n/2-1까지만 담는다.

        // 1. 초기 트리 초기화
        for(int i=n/2-1; i>=0; i--)
            heapify(arr, n, i);

        // 현재 max heap이 구성이 완료된 형태이지만, 부모의 자식 2*i+1|2의 규칙으로 인해
        // 실제 오름차순 정렬이 되어있는 배열도 아닐 뿐 더러, 현재는 heap으로 봐도 max_heap이라
        // 내림차순임. 이를 실제 배열 형태로 구현하는 것

        for(int i=n-1; i>0; i--){//최댓값을 하나씩 저장할(뒤에서부터-내림차순) 인덱스
            // 현재 가장 큰 값은 무조건 arr[0]에 있기에 해당 값을 최댓값 저장 index인 i와 swap하고
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            // 힙의 규칙이 깨졌을 테니 다시 heapify로 처음부터 검증 시작.
            // 이때 맨 뒤로 옮긴 최댓값은 건들면 안되기에(실제 배열 상정렬 완료 상태)
            // 전체 반복문에서 i값을 -1씩 하여 전체 힙의 범위에서 아예 빼버려 접근하지 못하게 한다.
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i){
        //n은 현재 처리 중인 힙의 크기, i는 검사할 부모 노드의 인덱스
        int largest = i; // 부모가 가장 크다고 가정
        int left = 2*i+1; // 왼쪽 자식 인덱스
        int right = 2*i+2; // 오른쪽 자식 인덱스

        if(left<n && arr[left]>arr[largest]) // 범위조건만족하며, 왼쪽자식이 부모보다 크다면 부모를 변경
            largest = left;
        if(right<n && arr[right]>arr[largest]) // 오른쪽 자식이 부모보다 크다면 부모를 변경
            largest = right;
        // 현 시점 largest부모는 자식 두 값보다는 확실히 큼.
        // 그리고 만약 검사대상인 i가 올바르게 자식보다 크게 되어있었다면, largest는 바뀌지 않아 i 그대로의 값이었을거임.
        // 하지만 검사대상인 i즉, largest가 자식보다 작아 큰 값이 바뀌었다면 현재 노드(부모-자식)상에서는
        // 바로 위에서 if문으로 바꾸었기에 잘 들어가있겠지만, 그 자식의 자식까지도 제대로 배열이 된건지를 다시 확인해야함.

        // 그래서 만약 현재 검사대상인 i가 부모-자식 규칙이 어긋나 한번 바꿨었다면
        if(largest != i){
            // largest였던 i와 새롭게 바뀐(자식) largest간의 swap을 이용하여 실제 배열에서도 위치를 바꿔주고
            int tmp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = tmp;

            // 새롭개 올라간 원래 자식이었지만 지금은 부모가 새로이 된 largest에 대해 재귀적으로 다시 자식노드를 검사.
            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) throws IOException{
        /*
            수의 개수가 1,000,000개로 늘어났다.
            수는 |x|<=1,000,000으로 int로 처리 가능하다.
            수의 중복은 없다.

            우선 2초이긴하나, 공부 차원에서 앞서 정리한 삽입 정렬과 선택 정렬을 사용해서 성능을 비교해보자.
            남은 퀵, 분할, 합병 정렬 등은 어차피 성능이 좋을 것 같기에 뒤에 문제에 필요할 것이다.

            여기부터 필요한 듯 하다. 둘 다 시간초과가 발생했다.

            퀵정렬, 병합정렬, 힙정렬을 하나씩 사용해보자.

            1. 퀵 정렬
            퀵 정렬은 low, high(정확한 인덱스여야하기에 n이 아닌 n-1)을 사용한다.
            재귀를 사용하기에 초기에 low<high인지 검사해야만 무한루프가 돌지 않는다.
            high pivot기준(low도 가능하긴 하겠지만 이해를 위해 통일) partition을 계산하는 함수 호출 후
            해당 partition_idx값을 기준으로 재귀 호출한다.

            partition 함수 내에서는 high를 pivot으로 했을 때
            pivot보다 작은 수를 삽입하기 위한 경계변수 low-1이 우선 필요하다.
            low~high-1까지의 수 중 pivot보다 작은 수를 발견하게 되면
            pivot작은수의 경계변수 low-1했던걸 +1씩 하면서 발견값과 경계값을 swap한다.
            반복문이 끝나면 경계변수에는 pivot보다 작지만 가장 큰 수의 index를 가리키기에
            마지막으로 pivot인 high와 경계변수+1값을 swap시키고,
            실질적으로 반환에 필요한 값은 pivot의 인덱스이기에 경계변수+1를 리턴한다.

            2. 병합 정렬
            하지만 위 방식으로도 현재 TLE가 발생하고 있다. 다음으로 병합정렬을 사용해보자.
            병합정렬은 인덱스를 조금 더 신경써야한다. mid값을 기준으로 나누는 것은 맞지만
            mid값을 pivot으로 따로 처리하는 quick_sort와 달리 mid값도 left혹은 right에서 처리해줘야한다.
            그래서 left에서 mid값을 처리하기로 통일하자.(범위의 경우 left는 +1한번씩 해준단 얘기임)

            merge_sort역시 left<right인지 재귀호출할 것이기에 종료조건을 먼저 체크해준다.
            그 뒤 중간 지점을 left + (right-left)/2로 계산하는데
            왼쪽 쪼개기 시 퀵 정렬과 달리 mid까지 포함되어야 하기에 left, mid를
            우측 쪼개기 시 mid는 왼쪽 쪼개기 범위에 포함되어있으니 mid+1, right를 재귀한다.
            그 후 병합 로직 함수 merge(arr, left, mid, right)로 재귀로 호출된 모든 것들을 통합한다.

            merge함수 안에서는 두개의 배열을 사용할 것이다. 이 때 좌측에서 mid를 포함해야하니
            n1(첫번째 배열의 사이즈)은 mid-left+1이 , n2는 right-mid가 된다.
            그 후 임시배열을 생성하고 실제 arr에서 해당되는 범위까지의 원소를 각 임시배열에 저장한다.
            그리고 인덱스 3개를 사용하여 배열할 것이다.
            왼쪽 배열의 i, 오른쪽 배열의 j, 그리고 실제로 정렬할 arr전체 배열의 인덱스 k(=left이다.)
            while(i<n1 && j<n2) 즉 두 배열 중 하나가 다 들어갈때 까지 둘 중 뭐가 작은지 확인한 후
            원본 arr배열 k위치에다가 크기순으로 박아넣는다.
            그 후 남아있는 배열이 있다면 마찬가지로 싹 박아넣는다.

            이 떄 다음와 같은 의문이 들 수 있다. 어차피 merge_sort에서 잙게잘게 배열이 쪼개진다면,
            merge함수에서 대소비교만 하면 되지 않나? 복잡한 배열의 연산이 아니라 크기 1짜리 배열인데
            뭐하러 배열의 연산을 고려하나?

            맞는 말이다. 다만 그 1짜리 배열이 merge되어 2짜리가 되었다고 생각해보자. 전체 배열이 대충 4라고 하더라도
            1+1+1+1에서 두번 merge되면  2+2로 결국 배열의 연산이 필요해진다.

            우선 현재 병합정렬을 이용했을 때 TLE가 발생하지 않았다. 메모리를 희생하여 속도를 챙긴 것 같다.

            3. 힙정렬
            '힙'은 완전이진트리 중 하나로, 부모노드는 자식의 값보다 크거나 같은 상태를 Max Heap이라고 한다.
            힙을 만들기만 하면, 정렬은 빼기만 하면 된다.

            4. Arrays.sort() 정렬
            자바에서 기본적으로 제공하는 위 정렬은, 퀵 정렬의 변형인 Dual-Pivot Quicksort를 사용한다고 한다.

            5. 효율성 비교
            삽입, 선택, 퀵 정렬은 TLE가 발생하여 제외한다.
            병합 정렬은 메모리 228,984KB에 시간 1032ms
            힙 정렬은 메모리 113,140KB에 시간 940ms
            콜렉션 정렬은 메모리 121,224KB에 시간 1412ms
            힙 정렬이 메모리와 시간 측면에서 제일 좋았고,
            병합 정렬은 콜렉션 정렬보다 빨랐지만 알고리즘 특성 상 메모리가 2개 사용된 것을 볼 수 있었다.

            원래 quick정도만 정리하고 끝내려고했는데 얼떨결에 모든 정렬을 살펴보았다.
            병합과 quick은 상황에 따라 각각 쓰일 듯 하니 알아두되,
            제일 좋은 힙 정렬은 사실 로직이 아직은 좀 복잡하게 느껴져 적응이 더 필요해보인다.
            이상.
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(br.readLine());
        //insertion_sort(arr, n);
        //selection_sort(arr, n);
        //quick_sort(arr, 0, n-1);
        //merge_sort(arr, 0, n-1);
        //heap_sort(arr, n);
        Arrays.sort(arr);
        for(int i=0; i<n; i++){
            bw.write(String.valueOf(arr[i]));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}