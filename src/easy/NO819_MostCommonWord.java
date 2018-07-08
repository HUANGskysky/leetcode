package easy;

import java.util.*;

/**
 * Created by Hsky on 2018/4/30.
 */
public class NO819_MostCommonWord {
    /**
     * Description:
     * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.
     * It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
     * Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.
     * The answer is in lowercase.
     * <p>
     * Example:
     * Example:
     * Input:
     * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
     * banned = ["hit"]
     * Output: "ball"
     * Explanation:
     * "hit" occurs 3 times, but it is a banned word.
     * "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
     * Note that words in the paragraph are not case sensitive,
     * that punctuation is ignored (even if adjacent to words, such as "ball,"),
     * and that "hit" isn't the answer even though it occurs more because it is banned.
     * <p>
     * <p>
     * Note:
     * <p>
     * 1 <= paragraph.length <= 1000.
     * 1 <= banned.length <= 100.
     * 1 <= banned[i].length <= 10.
     * The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
     * paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
     * Different words in paragraph are always separated by a space.
     * There are no hyphens or hyphenated words.
     * Words only consist of letters, never apostrophes or other punctuation symbols.
     */
//
    public static void main(String[] args) {
        //更新一下
        //并且更新于2018.7.8
        String paragraph=new String("Bob!");//hit a ball, the hit BALL flew far after it was hit.
        String[] banned=new String[]{"hit"};
        String res=mostCommonWord(paragraph,banned);
        System.out.println(res);

    }

    public static String mostCommonWord(String p, String[] banned) {
        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> count = new HashMap<>();
        String[] words = p.replaceAll("\\pP" , "").toLowerCase().split("\\s+");
        String res = "";
        int max = 0;
        for (String w : words) {
            if (!ban.contains(w)) {
                count.put(w, count.getOrDefault(w, 0) + 1);
                if (count.get(w) > max) {
                    res = w;
                    max = count.get(w);
                }}}
        return res;
    }
}
