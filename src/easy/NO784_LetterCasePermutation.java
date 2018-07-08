package easy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by LXM on 2018/4/30.
 */

/**
 * Description:
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.
 * Return a list of all possible strings we could create.
 *
 * Example:
 *
     Input: S = "a1b2"
     Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

     Input: S = "3z4"
     Output: ["3z4", "3Z4"]

     Input: S = "12345"
     Output: ["12345"]
 *
 *
 * Note:

     S will be a string with length at most 12.
     S will consist only of letters or digits.
 */
public class NO784_LetterCasePermutation {

    public static void main(String[] args){
        String s=new String("a1b2");
        System.out.println("Result:::"+letterCasePermutation(s));
    }

    /**
     * BFS-广度优先算法
     */
     public static List<String> letterCasePermutation(String S) {
         Queue<String> queue=new LinkedList<>();
         queue.add(S);
         for(int i=0;i<S.length();i++){
             int size=queue.size();
             if(Character.isDigit(S.charAt(i)))
                 continue;
             for(int j=0;j<size;j++){
                 String str=queue.poll();
                 char[] arrCh=str.toCharArray();

                 arrCh[i]=Character.toUpperCase(arrCh[i]);
                 queue.add(new String(arrCh));

                 arrCh[i]=Character.toLowerCase(arrCh[i]);
                 queue.add(new String(arrCh));
             }

         }
         return new LinkedList<>(queue);
     }

}
