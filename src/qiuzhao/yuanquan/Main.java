package qiuzhao.yuanquan;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Huangsky on 2018/9/22.
 */

/**
 * 计算逆波兰表达式的结果
 * <p>
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().trim().split(" ");
        System.out.println(evalRPN(str));

    }


    public static int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<Integer>();
        for (int i = 0; i < tokens.length; i++) {

            if (tokens[i].equals("+")) {
                int right = s.pop();
                int left = s.pop();
                int result = left + right;
                s.push(result);
            } else if (tokens[i].equals("*")) {
                int right = s.pop();
                int left = s.pop();
                int result = left * right;
                s.push(result);
            } else if (tokens[i].equals("-")) {
                int right = s.pop();
                int left = s.pop();
                int result = left - right;
                s.push(result);
            } else if (tokens[i].equals("/")) {
                int right = s.pop();
                int left = s.pop();
                int result = left / right;
                s.push(result);
            } else {
                s.push(Integer.parseInt(tokens[i]));
            }
        }
        return s.pop();
    }
}
