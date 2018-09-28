package qiuzhao.huawei;


import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Huangsky on 2018/9/26.
 */
public class Main {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        Main huff = new Main();
        huff.createHFMTree(str);
        huff.output();

        System.out.println(huff.toHufmCode(str));


    }

    private String str;
    private HNode root;
    private boolean flag;
    private LinkedList<CharData> charList;
    private LinkedList<HNode> NodeList;

    private class CharData {
        int num = 1;
        char c;

        public CharData(char ch) {
            c = ch;
        }
    }

    /**
     * 构造哈弗曼树
     *
     * @param str
     */
    public void createHFMTree(String str) {
        this.str = str;
        NodeList = new LinkedList<HNode>();
        charList = new LinkedList<CharData>();


        getCharNum(str);

        createNodes();

        sort(NodeList);

        createTree();

        root = NodeList.get(0);

    }

    public void getCharNum(String str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            flag = true;
            for (int j = 0; j < charList.size(); j++) {
                CharData data = charList.get(j);

                if (ch == data.c) {
                    data.num++;
                    flag = false;
                    break;

                }
            }
            if (flag) {
                charList.add(new CharData(ch));
            }
        }

    }

    public void createNodes() {
        for (int i = 0; i < charList.size(); i++) {
            String data = charList.get(i).c + "";
            int count = charList.get(i).num;
            HNode node = new HNode(data, count);
            NodeList.add(node);
        }
    }

    public void createTree() {
        while (NodeList.size() > 1) {
            HNode left = NodeList.poll();
            HNode right = NodeList.poll();

            left.code = "0";
            right.code = "1";

            setCode(left);
            setCode(right);

            int parentWeight = left.count + right.count;
            HNode parent = new HNode(parentWeight, left, right);

            NodeList.addFirst(parent);
            sort(NodeList);

        }
    }

    private void sort(LinkedList<HNode> nodeList) {
        for (int i = 0; i < nodeList.size() - 1; i++) {
            for (int j = i + 1; j < nodeList.size(); j++) {
                HNode temp;
                if (nodeList.get(i).count > nodeList.get(j).count) {
                    temp = nodeList.get(i);
                    nodeList.set(i, nodeList.get(j));
                    nodeList.set(j, temp);
                }
            }
        }
    }

    private void setCode(HNode root) {
        if (root.lChild != null) {
            root.lChild.code = root.code + "0";
            setCode(root.lChild);
        }

        if (root.rChild != null) {
            root.rChild.code = root.code + "1";
            setCode(root.rChild);
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

    private void search(HNode root, String c) {
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

    String result = "";
    boolean target = false;

    public String codeToString(String codeStr) {
        int start = 0;
        int end = 1;
        while (end <= codeStr.length()) {
            target = false;
            String s = codeStr.substring(start, end);
            matchCode(root, s);
            if (target) {
                start = end;
            }
            end++;
        }
        return result;
    }

    public void matchCode(HNode root, String code) {
        if (root.rChild == null && root.lChild == null) {
            if (code.equals(root.code)) {
                result += root.data;
                target = true;
            }
        }
        if (root.lChild != null)
            matchCode(root.lChild, code);
        if (root.rChild != null)
            matchCode(root.rChild, code);
    }

    private void output(HNode node) {
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


}

class HNode {
    public String code = "";
    public String data = "";
    public int count;
    public HNode lChild;
    public HNode rChild;

    public HNode() {

    }

    public HNode(String data, int count) {
        this.data = data;
        this.count = count;
    }

    public HNode(int count, HNode lChild, HNode rChild) {
        this.count = count;
        this.lChild = lChild;
        this.rChild = rChild;
    }

    public HNode(String data, int count, HNode lChild, HNode rChild) {
        this.data = data;
        this.count = count;
        this.lChild = lChild;
        this.rChild = rChild;
    }

}
