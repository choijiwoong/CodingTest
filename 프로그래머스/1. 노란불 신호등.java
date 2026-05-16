class Solution {
    public int solution(int[][] signals) {
        int answer = -1;

        int len = signals.length;
        int[] cur = new int[len];
        for(int i=0; i<len; i++)
            cur[i]=1;

        return answer;
    }

    public boolean is_same(int[] input){
        boolean result = true;
        int n = input[0];
        for(int i=1; i<input.length; i++){
            if(n!=input[i]){
                result = false;
                break;
            }
        }
        return result;
    }
}