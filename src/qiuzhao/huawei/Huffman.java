package qiuzhao.huawei;

/**
 * Created by Huangsky on 2018/9/26.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Huffman {
    private String str;// 最初用于压缩的字符串
    private String newStr = "";// 哈夫曼编码连接成的字符串
    private Node root;// 哈夫曼二叉树的根节点
    private boolean flag;// 最新的字符是否已经存在的标签
    private ArrayList<String> charList;// 存储不同字符的队列 相同字符存在同一位置
    private ArrayList<Node> NodeList;// 存储节点的队列

    /**
     * 构建哈夫曼树
     *
     * @param str
     */
    public void creatHfmTree(String str) {
        this.str = str;
        charList = new ArrayList<String>();
        NodeList = new ArrayList<Node>();
        // 1.统计字符串中字符以及字符的出现次数
        // 基本思想是将一段无序的字符串如ababccdebed放到charList里，分别为aa,bbb,cc,dd,ee
        // 并且列表中字符串的长度就是对应的权值
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i); // 从给定的字符串中取出字符
            flag = true;
            for (int j = 0; j < charList.size(); j++) {
                if (charList.get(j).charAt(0) == ch) {// 如果找到了同一字符
                    String s = charList.get(j) + ch;
                    charList.set(j, s);
                    flag = false;
                    break;
                }
            }
            if (flag) {
                charList.add(charList.size(), ch + "");
            }
        }
        // 2.根据第一步的结构，创建节点
        for (int i = 0; i < charList.size(); i++) {
            String data = charList.get(i).charAt(0) + ""; // 获取charList中每段字符串的首个字符
            int count = charList.get(i).length(); // 列表中字符串的长度就是对应的权值
            Node node = new Node(data, count); // 创建节点对象
            NodeList.add(i, node); // 加入到节点队列
        }

        // 3.对节点权值升序排序
        Sort(NodeList);
        while (NodeList.size() > 1) {// 当节点数目大于一时
            // 4.取出权值最小的两个节点，生成一个新的父节点
            // 5.删除权值最小的两个节点，将父节点存放到列表中
            Node left = NodeList.remove(0);
            Node right = NodeList.remove(0);
            int parentWeight = left.count + right.count;// 父节点权值等于子节点权值之和
            Node parent = new Node(parentWeight, left, right);
            NodeList.add(0, parent); // 将父节点置于首位

        }
        // 6.重复第四五步，就是那个while循环
        // 7.将最后的一个节点赋给根节点
        root = NodeList.get(0);
    }

    /**
     * 升序排序
     *
     * @param nodelist
     */
    public void Sort(ArrayList<Node> nodelist) {
        for (int i = 0; i < nodelist.size() - 1; i++) {
            for (int j = i + 1; j < nodelist.size(); j++) {
                Node temp;
                if (nodelist.get(i).count > nodelist.get(j).count) {
                    temp = nodelist.get(i);
                    nodelist.set(i, nodelist.get(j));
                    nodelist.set(j, temp);
                }

            }
        }

    }

    private String hfmCodeStr = "";

    public String toHufmCode(String str) {
        for (int i = 0; i < str.length(); i++) {
            String c = str.charAt(i) + "";
            search(root, c);
        }
        return hfmCodeStr;
    }

    private void search(Node root, String c) {
        if (root.lChild == null && root.rChild == null) {
            if (c.equals(root.data)) {
                hfmCodeStr += root.code;
            }
        }
        if (root.lChild != null) {
            search(root.lChild, c);
        }
        if (root.rChild != null) {
            search(root.rChild, c);
        }
    }

    private void output(Node node) {
        if (node.lChild == null && node.rChild == null)
            System.out.println(node.data + ":" + node.code);

        if (node.lChild != null)
            output(node.lChild);
        if (node.rChild != null)
            output(node.rChild);
    }

    private void output() {
        output(root);
    }

    /**
     * 主方法
     *
     * @param args
     */
    public static void main(String[] args) {
        Huffman huff = new Huffman();//创建哈弗曼对象

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        huff.creatHfmTree(str);
        huff.output();
        System.out.println(huff.toHufmCode(str));


    }

}

class Node {
    public String code = "";
    public String codeSize = "";
    public int count;
    public String data;
    public Node lChild;
    public Node rChild;

    public Node() {

    }

    public Node(String data, int count) {
        this.data = data;
        this.count = count;
    }

    public Node(int count, Node lChild, Node rChild) {
        this.count = count;
        this.lChild = lChild;
        this.rChild = rChild;
    }

    public Node(String data, int count, Node lChild, Node rChild) {
        this.data = data;
        this.count = count;
        this.lChild = lChild;
        this.rChild = rChild;
    }

}

