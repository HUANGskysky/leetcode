package qiuzhao.pingduoduo;

import javax.sound.midi.Soundbank;
import java.util.*;

/**
 * Created by Huangsky on 2018/9/21.
 */
public class Main_1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] strs = scanner.nextLine().trim().toLowerCase().split(" ");
        List<String> res = getFrequentWord(strs);
        for (int i = 0; i < res.size(); i++) {
            if (i == res.size() - 1)
                System.out.println(res.get(i));
            else
                System.out.print(res.get(i) + " ");
        }

    }

    public static List<String> getFrequentWord(String[] strs) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            if (!map.containsKey(strs[i]))
                map.put(strs[i], 1);
            else {
                map.put(strs[i], map.get(strs[i]) + 1);
            }
        }
        int max = Integer.MIN_VALUE;
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, Integer> it = (Map.Entry<String, Integer>) iter.next();
            max = Math.max(max, it.getValue());
        }

        ArrayList<String> res = new ArrayList<>();

        iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, Integer> it = (Map.Entry<String, Integer>) iter.next();
            if (it.getValue().equals(max))
                res.add(it.getKey());
        }
        return res;
    }
}
