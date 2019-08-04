package cn.smile.linkedList;

/**
 * 链表是一种在物理上非连续、非顺序的数据结构，由若干节点所组成
 *
 * 链表根据结构可分为单链表，双链表和循环链表
 * */
public class LinkedListStructure {
    //头结点
    private Node head;
    //尾节点
    private Node last;
    //链表的实际长度
    private int size;


    /**
     * 插入操作时间复杂度是O(1),查到动作的时间复杂度是O(n)
     * */
    public void insert(int data,int index){
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

    public void output(){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }


}
