package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Huangsky on 2018/5/25.
 */
public class NO438_FindAllAnagramsInAString {
    public static void main(String[] args){
        String s=new String("cbaebabacd");
        String p=new String("abc");
        List<Integer> list=findAnagrams(s,p);
        System.out.println(list);
        return ;
    }
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list=new ArrayList<Integer>();
        int len=p.length();
        for(int i=0;i<=s.length()-len;i++){
            String str=s.substring(i,i+len);
            if(compareStr(str,p))
                list.add(i);
        }
        return list;
    }
    public static boolean compareStr(String a,String b){
        char[] strA=a.toCharArray();
        char[] strB=b.toCharArray();
        Arrays.sort(strA);
        Arrays.sort(strB);
        int i=0;
        for(;i< strA.length;i++){
            if (strA[i]!=strB[i])
                break;
        }
        return i==strA.length;

    }
}
