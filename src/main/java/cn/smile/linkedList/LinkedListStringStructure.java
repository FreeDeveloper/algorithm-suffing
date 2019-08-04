package cn.smile.linkedList;

/**
 * 链表是一种在物理上非连续、非顺序的数据结构，由若干节点所组成
 *
 * 链表根据结构可分为单链表，双链表和循环链表
 * */
public class LinkedListStringStructure {
    //头结点
    public Node head;
    //尾节点
    private Node last;
    //链表的实际长度
    private int size;

    public LinkedListStringStructure(){
        super();
    }

    public LinkedListStringStructure(String args){

        if(args == null || args.length() == 0){

        }else{
            for(int i = 0;i < args.length();i++){
                insert(args.charAt(i)+"",i);
            }
        }
    }


    /**
     * 插入操作时间复杂度是O(1),查到动作的时间复杂度是O(n)
     * */
    public void insert(String data,int index){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("链表节点超出限制");
        }

        Node insertNode = new Node(data);

        if(size == 0){
            head = insertNode;
            last = insertNode;
        }else if(index == 0){
            insertNode.next = head;
            head = insertNode;
        }else if(index == size){
            last.next = insertNode;
            last = insertNode;
        }else{
            //插入位置的前置节点
            Node prevNode = get(index-1);
            insertNode.next = prevNode.next;
            prevNode.next = insertNode;

        }

        size ++;
    }

    public Node get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("链表节点超出限制");
        }

        Node temp = head;
        for(int i = 0; i < index;i++){
            temp = temp.next;
        }

        return temp;
    }

    /**
     * 删除操作的时间复杂度是O(1),但是需要经过一次查找
     * */
    public Node remove(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("链表节点超出限制");
        }

        Node removeNode = null;
        if(index == 0){
            removeNode = head;
            head = head.next;
        }else if(index == size-1){
            Node prevNode = get(index -1);
            removeNode = prevNode.next;
            prevNode.next = null;
            last = prevNode;
        }else{
            Node prevNode = get(index -1);
            Node nextNode = prevNode.next.next;
            removeNode = prevNode.next;
            prevNode.next = nextNode;
        }

        size -- ;
        return removeNode;
    }


    public boolean isPalindrome(){
        Node prev = null;
        Node next = null;
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (!slow.data.equals(prev.data)) {
                return false;
            }
            slow = slow.next;
            prev = prev.next;
        }

        return true;
    }

    /**
     * LeetCode对应编号：206
     * https://leetcode-cn.com/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-by-leetcode/
     * */
    public void reverseLink(){
        Node prev = null;
        Node cur = head;
        Node next = null;

        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        output(prev);
    }

    /**
     * LeetCode对应编号：141
     *
     * 快慢指针判断是否有环
     * https://leetcode-cn.com/problems/linked-list-cycle/solution/huan-xing-lian-biao-by-leetcode/
     * */
    public boolean isLinkCircle(){
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast){
                return true;
            }
            if(slow == null){
                return false;
            }
        }

        return false;
    }

    /**
     * 两个有序链表的合并
     * https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/he-bing-liang-ge-you-xu-lian-biao-by-leetcode/
     * */
    public static Node mergeTwoLists(Node l1, Node l2) {
        // 类似归并排序中的合并过程
//        Node dummyHead = new Node("");
//        Node cur = dummyHead;
//        while (l1 != null && l2 != null) {
//            if (l1.data.compareTo(l2.data) < 0) {
//                cur.next = l1;
//                cur = cur.next;
//                l1 = l1.next;
//            } else {
//                cur.next = l2;
//                cur = cur.next;
//                l2 = l2.next;
//            }
//        }
//        // 任一为空，直接连接另一条链表
//        if (l1 == null) {
//            cur.next = l2;
//        } else {
//            cur.next = l1;
//        }
//        output(dummyHead.next);

        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.data.compareTo(l2.data) < 0) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }

    /**
     * 使用两个指针，间隔为1，当第二个指针的下个节点是null的时候说明到底，删除
     * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/shan-chu-lian-biao-de-dao-shu-di-nge-jie-dian-by-l/
     * */
    public Node removeNthFromEnd(Node head, int n) {
        Node dummy = new Node("");
        dummy.next = head;
        Node first = dummy;
        Node second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    /**
     * 求中间节点
     * 快慢指针法
     * https://leetcode-cn.com/problems/middle-of-the-linked-list/solution/lian-biao-de-zhong-jian-jie-dian-by-leetcode/
     * */
    public Node middleNode(){
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    public void output(){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void output(Node head){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }


    private static class Node{
        String data;
        Node next;

        public Node(){
            super();
        }

        public Node(String data){
            this.data = data;
        }
    }

}
