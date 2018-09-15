package qiuzhao.tongcheng58;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Huangsky on 2018/9/15.
 */
public class Main_1 {
    static class Node {
        int val;
        Node next;

        Node(int v) {
            val = v;
        }
    }//成员类，代表节点，类似于数据结构中的结构体

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();//这个表示总人数
        int M = scanner.nextInt();//数到几的人出局
        List<Integer> list = jiguchuanhua(N, M);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static List<Integer> jiguchuanhua(int N, int M) {
        List<Integer> list = new LinkedList<>();
        Node t = new Node(1);//头节点单列出来，方便形成循环链表
        Node x = t;
        for (int i = 2; i <= N; i++) x = (x.next = new Node(i));//建立单向链表
        x.next = t;//最后一个节点的next指向第一个节点，形成循环链表
        while (x != x.next) {
            for (int i = 1; i < M; i++)
                x = x.next;
            //此时x是将出列的节点的前一个节点
            list.add(x.next.val);
            x.next = x.next.next;
        }
        list.add(x.val);
        return list;
    }
}
