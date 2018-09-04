package basicAlgoInBaoDian.list;

/**
 * Created by Huangsky on 2018/8/17.
 */

/**
 * 实现链表的增删，并提供排序方法
 */
class Node {
    Node next = null;
    private int val;

    public Node(int val) {
        this.val = val;
    }

}

public class MyLinkedList {
    Node head = null;//链表头

    /**
     * 向链表中插入数据
     *
     * @param data 插入的数据
     */
    public void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = newNode;

    }

    /**
     * @param index :删除第index个结点
     * @return 成功返回true，失败返回false
     */

    public Boolean deleteNode(int index) {
        if (index < 1 || index > length()) {
            return false;
        }
        int count = 1;
        return false;
    }

    /**
     * @return 返回链表的长度
     */

    public int length() {
        Node tmp = head;
        int len = 0;
        while (tmp != null) {
            len++;
            tmp = tmp.next;
        }
        return len;
    }

    /**
     *
     */
    public Node orderList() {

        return null;
    }

}
