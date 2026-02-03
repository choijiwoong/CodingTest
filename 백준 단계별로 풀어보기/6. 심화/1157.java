import java.lang.*;
import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        int[] alphabet = new int[26];
        int max = -1;
        char result = '?';
        int c;

        while((c=System.in.read())>32){//공백이나 엔터 전까지
            if(c>='a')
                alphabet[c-'a']++;
            else
                alphabet[c-'A']++;
        }

        for(int i=0; i<26; i++){
            if(alphabet[i]>max){
                max = alphabet[i];
                result = (char)('A'+i);
            } else if(alphabet[i]==max){
                result = '?';
            }
        }

        System.out.println(result);
    }
}